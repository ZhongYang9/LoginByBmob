package com.zhongyang.loginbybmob.presenter.Impl;

import com.zhongyang.loginbybmob.model.ILoginDaoCallback;
import com.zhongyang.loginbybmob.model.LoginDao;
import com.zhongyang.loginbybmob.model.domain.User;
import com.zhongyang.loginbybmob.presenter.ILoginPresenterImpl;
import com.zhongyang.loginbybmob.view.ILoginViewCallback;

import java.util.List;

/**
 * @项目名称 LoginByBmob
 * @类名 LoginPresenterImpl
 * @包名 com.zhongyang.loginbybmob.presenter.Impl
 * @创建时间 2020/11/12 15:28
 * @作者 钟阳
 * @描述 登录界面实现类，逻辑层
 */
public class LoginPresenterImpl implements ILoginPresenterImpl, ILoginDaoCallback {

    private ILoginViewCallback mILoginViewCallback = null;
    private final LoginDao mLoginDao;

    //单例
    private LoginPresenterImpl() {
        //获取DAO层单例对象
        mLoginDao = LoginDao.getLoginDao();
        //设置接口，持有引用
        mLoginDao.setViewCallback(this);
    }

    private static LoginPresenterImpl sLoginPresenter = null;

    public static LoginPresenterImpl getLoginPresenter() {
        if (sLoginPresenter == null) {
            sLoginPresenter = new LoginPresenterImpl();
        }
        return sLoginPresenter;
    }

    //--------------------------实现ILoginPresenterImpl接口后实现的方法------------------
    @Override
    public void checkAccount(String account) {
        //设置UI状态
        if (mILoginViewCallback != null) {
            mILoginViewCallback.onLoading();
        }
        //请求M层获取数据库查询数据
        if (mLoginDao != null) {
            mLoginDao.queryAccount(account);
        }
    }

    @Override
    public void checkPwd(String account, String password) {
        //请求M层查询数据
        if (mLoginDao != null) {
            mLoginDao.checkPwd(account, password);
        }
    }

    @Override
    public void registerViewCallback(ILoginViewCallback callback) {
        //保存接口
        this.mILoginViewCallback = callback;
    }

    @Override
    public void unRegisterViewCallback(ILoginViewCallback callback) {
        //移除接口
        this.mILoginViewCallback = null;
    }
    //--------------------------实现ILoginPresenterImpl接口后实现的方法 end------------------

    //--------------------------注册DAO接口实现的方法---------------------------------------
    @Override
    public void onQueryAccountResult(List<User> users) {
        if (mILoginViewCallback != null) {
            //处理请求查询的结果
            if (users == null || users.size() == 0) {
                mILoginViewCallback.onEmpty();
            } else {
                mILoginViewCallback.onCheckAccountResult(users);
            }
        }
    }

    @Override
    public void onCheckPwdResult(boolean isCorrect) {
        //处理校验结果
        handlerCheckPwdResult(isCorrect);
    }

    @Override
    public void onNetWorkError() {
        //将网络错误的结果通知到UI
        if (mILoginViewCallback != null) {
            mILoginViewCallback.onNetWorkError();
        }
    }
    //--------------------------注册DAO接口实现的方法 end-------------------------------------

    private void handlerCheckPwdResult(boolean isCorrect) {
        if (mILoginViewCallback != null) {
            //判断是否有用户
            if (isCorrect) {
                mILoginViewCallback.onCheckPwdResult(isCorrect);
            } else {
                mILoginViewCallback.onPwdError();
            }
        }
    }
}
