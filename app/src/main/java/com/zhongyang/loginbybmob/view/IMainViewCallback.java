package com.zhongyang.loginbybmob.view;

import com.zhongyang.loginbybmob.model.domain.User;

import java.util.List;

/**
 * @项目名称 LoginByBmob
 * @类名 IMainViewCallback
 * @包名 com.zhongyang.loginbybmob.view
 * @创建时间 2020/11/12 20:16
 * @作者 钟阳
 * @描述 主界面回调接口
 */
public interface IMainViewCallback {

    /**
     * 获取用户列表的结果
     *
     * @param users
     */
    void onUserListLoaded(List<User> users);

    /**
     * 网络错误
     */
    void onNteWorkError();

    /**
     * 加载中
     */
    void onLoading();

    /**
     * 数据为空
     */
    void onEmpty();
}
