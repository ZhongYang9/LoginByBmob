package com.zhongyang.loginbybmob.presenter;

import com.zhongyang.loginbybmob.view.IMainViewCallback;

/**
 * @项目名称 LoginByBmob
 * @类名 IMainPresenterImpl
 * @包名 com.zhongyang.loginbybmob.presenter
 * @创建时间 2020/11/12 20:17
 * @作者 钟阳
 * @描述 主界面实现接口
 */
public interface IMainPresenterImpl {

    /**
     * 获取用户列表
     */
    void getUserList();

    /**
     * 注册接口回调
     *
     * @param callback
     */
    void registerViewCallback(IMainViewCallback callback);

    /**
     * 取消注册接口回调
     *
     * @param callback
     */
    void unRegisterViewCallback(IMainViewCallback callback);
}
