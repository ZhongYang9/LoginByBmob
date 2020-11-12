package com.zhongyang.loginbybmob.presenter.Impl;

import com.zhongyang.loginbybmob.model.IMainDaoImpl;
import com.zhongyang.loginbybmob.model.IMainDaoViewCallback;
import com.zhongyang.loginbybmob.model.MainDao;
import com.zhongyang.loginbybmob.model.domain.User;
import com.zhongyang.loginbybmob.presenter.IMainPresenterImpl;
import com.zhongyang.loginbybmob.view.IMainViewCallback;

import java.util.List;

/**
 * @项目名称 LoginByBmob
 * @类名 MainPresenterImpl
 * @包名 com.zhongyang.loginbybmob.presenter.Impl
 * @创建时间 2020/11/12 20:20
 * @作者 钟阳
 * @描述 主界面实现类
 */
public class MainPresenterImpl implements IMainPresenterImpl, IMainDaoViewCallback {

    private IMainViewCallback mMainViewCallback = null;
    private final IMainDaoImpl mMainDao;

    //单例
    private MainPresenterImpl() {
        //获取M层操作对象
        mMainDao = MainDao.getMainDao();
        //设置回调家口
        mMainDao.setViewCallback(this);
    }

    private static MainPresenterImpl sMainPresenter = null;

    public static MainPresenterImpl getMainPresenter() {
        if (sMainPresenter == null) {
            sMainPresenter = new MainPresenterImpl();
        }
        return sMainPresenter;
    }

    //-----------------------------继承IMainPresenterImpl接口实现的方法----------------------
    @Override
    public void getUserList() {
        //设置UI状态
        if (mMainViewCallback != null) {
            mMainViewCallback.onLoading();
        }
        //请求M层查询数据
        if (mMainDao != null) {
            mMainDao.getUserList();
        }
    }

    @Override
    public void registerViewCallback(IMainViewCallback callback) {
        //保存接口
        this.mMainViewCallback = callback;
    }

    @Override
    public void unRegisterViewCallback(IMainViewCallback callback) {
        //移除接口
        this.mMainViewCallback = null;
    }
    //-----------------------------继承IMainPresenterImpl接口实现的方法 end--------------------

    //----------------------------注册实现类实现的方法--------------------------
    @Override
    public void onUserListLoaded(List<User> users) {
        if (mMainViewCallback != null) {
            //处理结果
            if (users == null || users.size() == 0) {
                //数据为空
                mMainViewCallback.onEmpty();
            } else {
                //将查询结果通知到UI
                mMainViewCallback.onUserListLoaded(users);
            }
        }
    }

    @Override
    public void onNetWorkError() {
        //将网络错误结果通知到UI
        if (mMainViewCallback != null) {
            mMainViewCallback.onNteWorkError();
        }
    }
    //----------------------------注册实现类实现的方法 end------------------------
}
