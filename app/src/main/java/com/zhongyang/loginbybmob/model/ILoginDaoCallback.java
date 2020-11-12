package com.zhongyang.loginbybmob.model;

import com.zhongyang.loginbybmob.model.domain.User;

import java.util.List;

/**
 * @项目名称 LoginByBmob
 * @类名 ILoginDaoCallback
 * @包名 com.zhongyang.loginbybmob.model
 * @创建时间 2020/11/12 15:34
 * @作者 钟阳
 * @描述 登录DAO回调接口
 */
public interface ILoginDaoCallback {

    /**
     * 查询账号的结果
     *
     * @param users
     */
    void onQueryAccountResult(List<User> users);

    /**
     * 校验账号密码是否正确的结果
     *
     * @param isCorrect
     */
    void onCheckPwdResult(boolean isCorrect);

    /**
     * 网络错误
     */
    void onNetWorkError();
}
