package com.zhongyang.loginbybmob.model;

import android.util.Log;

import com.zhongyang.loginbybmob.model.domain.User;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * @项目名称 LoginByBmob
 * @类名 RegisterDao
 * @包名 com.zhongyang.loginbybmob.model
 * @创建时间 2020/11/11 20:07
 * @作者 钟阳
 * @描述 注册功能的DAO层
 */
public class RegisterDao implements IRegisterDaoImpl {

    private static final String TAG = "RegisterDao";
    private IRegisterDaoCallback mDaoViewCallback = null;

    //单例
    private RegisterDao() {
    }

    private static RegisterDao sRegisterDao = null;

    public static RegisterDao getRegisterDao() {
        if (sRegisterDao == null) {
            synchronized (RegisterDao.class) {
                if (sRegisterDao == null) {
                    sRegisterDao = new RegisterDao();
                }
            }
        }
        return sRegisterDao;
    }

    //---------------------------实现IRegisterDaoImpl接口后实现的方法--------------------
    @Override
    public void setViewCallback(IRegisterDaoCallback callback) {
        //保存注册接口
        this.mDaoViewCallback = callback;
    }

    @Override
    public void checkUser(String account) {
        //查询后端数据库
        BmobQuery<User> bmobQuery = new BmobQuery<>();
        bmobQuery.addWhereEqualTo("telephone", account);
        bmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (e == null) {
                    Log.d(TAG, "查询成功，查询到的数据 ==> " + list);
                    //查询数据成功，将结果通知到P层
                    handlerQueryWasSuccessful(list);
                } else {
                    int errorCode = e.getErrorCode();
                    Log.d(TAG, "查询失败，错误码 ==> " + errorCode + "错误信息 ==> " + e.toString());
                    //将查询数据失败的结果通知到P层
                    if (mDaoViewCallback != null) {
                        mDaoViewCallback.queryNetWorkError();
                    }
                }
            }
        });
    }

    @Override
    public void addUser(User user) {
        //向后端云添加数据
        User userData = new User();
        /*设置数据*/
        userData.setTelephone(user.getTelephone());
        userData.setPassword(user.getPassword());
        //添加
        userData.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    Log.d(TAG, "添加成功，数据ID ==> " + s);
                    //将结果通知到P层
                    if (mDaoViewCallback != null) {
                        mDaoViewCallback.onAddUserResult(true);
                    }
                } else {
                    Log.d(TAG, "注册用户失败，错误信息 ==> " + e.toString());
                }
            }
        });
    }
    //---------------------------实现IRegisterDaoImpl接口后实现的方法 end--------------------

    private void handlerQueryWasSuccessful(List<User> list) {
        //通知结果到UI
        if (mDaoViewCallback != null) {
            //对查询出来的集合进行处理
            if (list == null || list.size() == 0) {
                mDaoViewCallback.userIsEmpty();
            } else {
                mDaoViewCallback.onCheckUserResult(list);
            }
        }
    }
}
