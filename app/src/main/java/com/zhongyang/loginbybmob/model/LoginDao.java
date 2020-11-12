package com.zhongyang.loginbybmob.model;

import android.util.Log;

import com.zhongyang.loginbybmob.model.domain.User;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * @项目名称 LoginByBmob
 * @类名 LoginDao
 * @包名 com.zhongyang.loginbybmob.model
 * @创建时间 2020/11/12 15:42
 * @作者 钟阳
 * @描述 登录界面的DAO层
 */
public class LoginDao implements ILoginDaoImpl {

    private static final String TAG = "LoginDao";
    private ILoginDaoCallback mDaoViewCallback = null;

    //单例
    private LoginDao() {
    }

    private static LoginDao sLoginDao = null;

    public static LoginDao getLoginDao() {
        if (sLoginDao == null) {
            sLoginDao = new LoginDao();
        }
        return sLoginDao;
    }

    //--------------------------------实现ILoginDaoImpl接口后实现的方法-----------------
    @Override
    public void setViewCallback(ILoginDaoCallback callback) {
        //保存注册的接口
        this.mDaoViewCallback = callback;
    }

    @Override
    public void queryAccount(String account) {
        //查询后端数据库
        BmobQuery<User> bmobQuery = new BmobQuery<>();
        //设置查询条件
        bmobQuery.addWhereEqualTo("telephone", account);
        //调用查询方法事件
        bmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                //处理查询结果
                handlerQueryResult(list, e);
            }
        });
    }

    @Override
    public void checkPwd(String account, String password) {
        /*查询后端校验密码是否正确*/
        BmobQuery<User> bmobQuery = new BmobQuery<>();//实例化实体类
        /*设置查询条件*/
        bmobQuery.addWhereEqualTo("telephone", account);//账号字段等于传进来的account
        /*查询方法事件*/
        bmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                for (User user : list) {
                    //处理校验结果
                    handlerCheckPwdResult(user, password, e);
                }
            }
        });
    }
    //--------------------------------实现ILoginDaoImpl接口后实现的方法 end-----------------

    private void handlerQueryResult(List<User> list, BmobException e) {
        if (mDaoViewCallback != null) {
            if (e == null) {
                //Log.d(TAG, "查询到" + list.size() + "条数据");
                //将查询结果通知出去
                mDaoViewCallback.onQueryAccountResult(list);
            } else {
                Log.d(TAG, "登录界面查询账号出错，错误信息 ==> " + e.toString());
                //将网络错误的结果通知出去
                mDaoViewCallback.onNetWorkError();
            }
        }
    }

    private void handlerCheckPwdResult(User user, String password, BmobException e) {
        //定义标示量
        boolean isCorrect = false;
        if (mDaoViewCallback != null) {
            if (e == null) {
                if (user.getPassword().equals(password)) {
                    //更新标示量的值
                    isCorrect = true;
                } else {
                    //更新标示量的值
                    isCorrect = false;
                }
                //将结果通知到P层
                mDaoViewCallback.onCheckPwdResult(isCorrect);
            } else {
                //网络错误
                mDaoViewCallback.onNetWorkError();
            }
        }
    }
}
