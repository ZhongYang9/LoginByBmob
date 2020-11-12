package com.zhongyang.loginbybmob.view;

import com.zhongyang.loginbybmob.model.domain.User;

import java.util.List;

/**
 * @项目名称 LoginByBmob
 * @类名 ILoginViewCallback
 * @包名 com.zhongyang.loginbybmob.view
 * @创建时间 2020/11/12 15:13
 * @作者 钟阳
 * @描述 登录界面的回调接口
 */
public interface ILoginViewCallback {

    /**
     * 校验用户是否存在的结果
     *
     * @param users 查询结果
     */
    void onCheckAccountResult(List<User> users);

    /**
     * 是否正确
     *
     * @param isSuccess 是否正确
     */
    void onCheckPwdResult(boolean isSuccess);

    /**
     * 查询中
     */
    void onLoading();

    /**
     * 网络错误
     */
    void onNetWorkError();
}
