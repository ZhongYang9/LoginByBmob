package com.zhongyang.loginbybmob.model;

/**
 * @项目名称 LoginByBmob
 * @类名 ILoginDaoImpl
 * @包名 com.zhongyang.loginbybmob.model
 * @创建时间 2020/11/12 15:36
 * @作者 钟阳
 * @描述 登录DAO实现接口
 */
public interface ILoginDaoImpl {

    /**
     * 设置回调接口
     *
     * @param callback
     */
    void setViewCallback(ILoginDaoCallback callback);

    /**
     * 查询账号
     *
     * @param account
     */
    void queryAccount(String account);

    /**
     * 校验密码
     *
     * @param account
     * @param password
     */
    void checkPwd(String account, String password);
}
