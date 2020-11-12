package com.zhongyang.loginbybmob.presenter.Impl;

import com.zhongyang.loginbybmob.model.IRegisterDaoCallback;
import com.zhongyang.loginbybmob.model.IRegisterDaoImpl;
import com.zhongyang.loginbybmob.model.RegisterDao;
import com.zhongyang.loginbybmob.model.domain.User;
import com.zhongyang.loginbybmob.presenter.IRegisterPresenterImpl;
import com.zhongyang.loginbybmob.view.IRegisterViewCallback;

import java.util.List;

/**
 * @项目名称 LoginByBmob
 * @类名 LoginPresenter
 * @包名 com.zhongyang.loginbybmob.presenter.Impl
 * @创建时间 2020/11/11 15:23
 * @作者 钟阳
 * @描述 注册界面逻辑实现类
 */
public class RegisterPresenter implements IRegisterPresenterImpl, IRegisterDaoCallback {

    private static final String TAG = "RegisterPresenter";
    private IRegisterViewCallback mRegisterViewCallback = null;
    private final IRegisterDaoImpl mRegisterDao;

    //单例
    private RegisterPresenter() {
        //获取M层DAO数据对象
        mRegisterDao = RegisterDao.getRegisterDao();
        //注册接口过去
        mRegisterDao.setViewCallback(this);
    }

    private static RegisterPresenter sRegisterPresenter = null;

    public static RegisterPresenter getRegisterPresenter() {
        if (sRegisterPresenter == null) {
            sRegisterPresenter = new RegisterPresenter();
        }
        return sRegisterPresenter;
    }

    //-----------------------------------实现接口动作实现的方法-------------------
    @Override
    public void checkedUser(String account) {
        //设置UI
        if (mRegisterViewCallback != null) {
            mRegisterViewCallback.onQuerying();
        }
        //请求数据库查询结果
        if (mRegisterDao != null) {
            mRegisterDao.checkUser(account);
        }
    }

    @Override
    public void addUser(User user) {
        //处理数据，添加用户
        if (mRegisterDao != null) {
            mRegisterDao.addUser(user);
        }
    }

    @Override
    public void registerViewCallback(IRegisterViewCallback callback) {
        //保存注册进来的接口
        this.mRegisterViewCallback = callback;
    }

    @Override
    public void unRegisterViewCallback(IRegisterViewCallback callback) {
        //移除接口
        this.mRegisterViewCallback = null;
    }
    //----------------------------实现接口动作实现的方法 end-------------------

    //--------------------------实现注册功能DAO层的方法------------------------
    @Override
    public void onCheckUserResult(List<User> users) {
        //通知结果到UI
        if (mRegisterViewCallback != null) {
            mRegisterViewCallback.onCheckUserResult(users);
        }
    }

    @Override
    public void onAddUserResult(boolean isSuccess) {
        //Log.d(TAG, "isSuccess is ==> " + isSuccess);
        //通知结果到UI层
        if (mRegisterViewCallback != null) {
            mRegisterViewCallback.onAddUserResult(isSuccess);
        }
    }

    @Override
    public void queryNetWorkError() {
        //将网络错误结果通知到UI
        if (mRegisterViewCallback != null) {
            mRegisterViewCallback.onNetWorkError();
        }
    }

    @Override
    public void userIsEmpty() {
        //用户不存在，将结果给到UI，让UI处理
        if (mRegisterViewCallback != null) {
            mRegisterViewCallback.onUserIsEmpty();
        }
    }
    //--------------------------实现注册功能DAO层的方法 end------------------------
}
