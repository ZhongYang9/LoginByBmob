package com.zhongyang.loginbybmob.model;

import com.zhongyang.loginbybmob.model.domain.User;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * @项目名称 LoginByBmob
 * @类名 MainDao
 * @包名 com.zhongyang.loginbybmob.model
 * @创建时间 2020/11/12 21:13
 * @作者 钟阳
 * @描述 主界面DAO层
 */
public class MainDao implements IMainDaoImpl {

    private IMainDaoViewCallback mDaoViewCallback = null;

    //单例
    private MainDao() {
    }

    private static MainDao sMainDao = null;

    public static MainDao getMainDao() {
        if (sMainDao == null) {
            sMainDao = new MainDao();
        }
        return sMainDao;
    }

    //-------------------------继承接口实现的方法--------------------
    @Override
    public void setViewCallback(IMainDaoViewCallback callback) {
        //保存接口
        this.mDaoViewCallback = callback;
    }

    @Override
    public void getUserList() {
        BmobQuery<User> bmobQuery = new BmobQuery<>();
        /*不用设置查询条件*/
        /*查询方法*/
        bmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (mDaoViewCallback != null) {
                    if (e == null) {
                        //
                        mDaoViewCallback.onUserListLoaded(list);
                    } else {
                        //
                        mDaoViewCallback.onNetWorkError();
                    }
                }
            }
        });
    }
    //-------------------------继承接口实现的方法 end------------------
}
