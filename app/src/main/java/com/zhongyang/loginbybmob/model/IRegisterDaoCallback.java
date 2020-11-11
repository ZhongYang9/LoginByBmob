package com.zhongyang.loginbybmob.model;

import com.zhongyang.loginbybmob.model.damain.User;

import java.util.List;

/**
 * @项目名称 LoginByBmob
 * @类名 IRegisterDaoCallback
 * @包名 com.zhongyang.loginbybmob.model
 * @创建时间 2020/11/11 19:53
 * @作者 钟阳
 * @描述 注册功能的数据DAO层的回调结果
 */
public interface IRegisterDaoCallback {

    /**
     * 校验用户是否存在的结果，结果是一个集合
     *
     * @param users 查询结果
     */
    void onCheckUserResult(List<User> users);

    /**
     * 添加用户的结果
     *
     * @param isSuccess 是否成功
     */
    void onAddUserResult(boolean isSuccess);

    /**
     * 查询用户网络错误
     */
    void queryNetWorkError();

    /**
     * 没有查询到用户
     */
    void userIsEmpty();

    /**
     * 查询中
     */
    void querying();
}
