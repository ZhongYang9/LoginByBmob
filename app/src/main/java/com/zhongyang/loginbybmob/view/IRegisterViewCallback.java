package com.zhongyang.loginbybmob.view;

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
     * @param isExistence 是否存在
     */
    void onCheckUserResult(boolean isExistence);

    /**
     * 添加用户的结果
     *
     * @param isSuccess
     */
    void onAddUserResult(boolean isSuccess);
}
