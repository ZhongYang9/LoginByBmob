package com.zhongyang.loginbybmob.presenter;

import com.zhongyang.loginbybmob.view.ILoginViewCallback;

/**
 * @项目名称 LoginByBmob
 * @类名 ILoginPresenterImpl
 * @包名 com.zhongyang.loginbybmob.presenter
 * @创建时间 2020/11/12 15:20
 * @作者 钟阳
 * @描述 登录界面的实现接口
 */
public interface ILoginPresenterImpl {

    /**
     * 校验账号是否注册
     *
     * @param account 账号
     */
    void checkAccount(String account);

    /**
     * 校验密码是否正确
     *
     * @param account  账号
     * @param password 密码
     */
    void checkPwd(String account, String password);

    /**
     * 注册UI回调接口
     *
     * @param callback 接口对象
     */
    void registerViewCallback(ILoginViewCallback callback);

    /**
     * 取消注册接口
     *
     * @param callback 接口对象
     */
    void unRegisterViewCallback(ILoginViewCallback callback);
}
