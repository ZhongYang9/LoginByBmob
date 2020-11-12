package com.zhongyang.loginbybmob.model;

import com.zhongyang.loginbybmob.model.domain.User;

import java.util.List;

/**
 * @项目名称 LoginByBmob
 * @类名 IMainDaoViewCallback
 * @包名 com.zhongyang.loginbybmob.model
 * @创建时间 2020/11/12 21:13
 * @作者 钟阳
 * @描述 主界面DAO层回调接口
 */
public interface IMainDaoViewCallback {

    /**
     * 获取用户列表的结果
     *
     * @param users
     */
    void onUserListLoaded(List<User> users);

    /**
     * 网络错误
     */
    void onNetWorkError();
}
