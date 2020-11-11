package com.zhongyang.loginbybmob.presenter.Impl;

import com.zhongyang.loginbybmob.model.damain.User;
import com.zhongyang.loginbybmob.presenter.IRegisterPresenterImpl;
import com.zhongyang.loginbybmob.view.IRegisterViewCallback;

/**
 * @项目名称 LoginByBmob
 * @类名 LoginPresenter
 * @包名 com.zhongyang.loginbybmob.presenter.Impl
 * @创建时间 2020/11/11 15:23
 * @作者 钟阳
 * @描述 登录界面
 */
public class RegisterPresenter implements IRegisterPresenterImpl {

    private IRegisterViewCallback mRegisterViewCallback = null;

    //-----------------------------------实现接口动作实现的方法-------------------
    @Override
    public void checkedUser(String account) {
        //TODO 请求数据
    }

    @Override
    public void addUser(User user) {
        //TODO 处理数据
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
}
