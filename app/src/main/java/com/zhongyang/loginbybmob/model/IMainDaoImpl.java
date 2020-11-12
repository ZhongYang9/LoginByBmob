package com.zhongyang.loginbybmob.model;

/**
 * @项目名称 LoginByBmob
 * @类名 IMainDao
 * @包名 com.zhongyang.loginbybmob.model
 * @创建时间 2020/11/12 21:14
 * @作者 钟阳
 * @描述 主界面DAO层实现接口
 */
public interface IMainDaoImpl {

    /**
     * 设置回调接口
     *
     * @param callback
     */
    void setViewCallback(IMainDaoViewCallback callback);

    /**
     * 获取用户列表
     */
    void getUserList();
}
