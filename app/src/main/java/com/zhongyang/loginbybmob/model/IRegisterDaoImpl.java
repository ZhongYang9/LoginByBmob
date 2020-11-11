package com.zhongyang.loginbybmob.model;

import com.zhongyang.loginbybmob.model.damain.User;

/**
 * @项目名称 LoginByBmob
 * @类名 IRegisterDaoImpl
 * @包名 com.zhongyang.loginbybmob.model
 * @创建时间 2020/11/11 20:00
 * @作者 钟阳
 * @描述 注册功能的DAO层实现接口
 */
public interface IRegisterDaoImpl {

    /**
     * 设置回调接口
     *
     * @param callback 接口对象
     */
    void setViewCallback(IRegisterDaoCallback callback);

    /**
     * 校验用户是否存在
     *
     * @param account 账号
     */
    void checkUser(String account);

    /**
     * 添加用户
     *
     * @param user 实体类对象
     */
    void addUser(User user);
}
