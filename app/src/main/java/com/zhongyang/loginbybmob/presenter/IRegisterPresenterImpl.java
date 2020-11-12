package com.zhongyang.loginbybmob.presenter;

import com.zhongyang.loginbybmob.model.domain.User;
import com.zhongyang.loginbybmob.view.IRegisterViewCallback;

/**
 * @项目名称 LoginByBmob
 * @类名 IRegisterPresenterImpl
 * @包名 com.zhongyang.loginbybmob.presenter
 * @创建时间 2020/11/11 15:03
 * @作者 钟阳
 * @描述 注册界面的注动作接口
 */
public interface IRegisterPresenterImpl{

    /**
     * 校验用户是否已经存在
     *
     * @param account 账号
     */
    void checkedUser(String account);

    /**
     * 添加用户
     *
     * @param user 用户实体类对象
     */
    void addUser(User user);

    /**
     * UI注册接口
     *
     * @param callback 接口对象
     */
    void registerViewCallback(IRegisterViewCallback callback);

    /**
     * 取消UI注册接口
     *
     * @param callback 接口对象
     */
    void unRegisterViewCallback(IRegisterViewCallback callback);
}
