package com.zhongyang.loginbybmob.view;

import com.zhongyang.loginbybmob.model.damain.User;

import java.util.List;

/**
 * @项目名称 LoginByBmob
 * @类名 IRegisterViewCallback
 * @包名 com.zhongyang.loginbybmob.view
 * @创建时间 2020/11/11 15:02
 * @作者 钟阳
 * @描述 注册界面UI回调接口
 */
public interface IRegisterViewCallback {

    /**
     * 校验用户是否存在的结果
     *
     * @param users 实体类对象
     */
    void onCheckUserResult(List<User> users);

    /**
     * 添加用户的结果
     *
     * @param isSuccess
     */
    void onAddUserResult(boolean isSuccess);

    /**
     * 查询中
     */
    void onQuerying();

    /**
     * 查询网络出错
     */
    void onNetWorkError();

    /**
     * 查询到的用户为空
     */
    void onUserIsEmpty();
}
