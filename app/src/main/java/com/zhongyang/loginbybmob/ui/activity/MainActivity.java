package com.zhongyang.loginbybmob.ui.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhongyang.loginbybmob.R;
import com.zhongyang.loginbybmob.base.BaseActivity;
import com.zhongyang.loginbybmob.model.domain.User;
import com.zhongyang.loginbybmob.presenter.IMainPresenterImpl;
import com.zhongyang.loginbybmob.presenter.Impl.MainPresenterImpl;
import com.zhongyang.loginbybmob.ui.adapter.UserListAdapter;
import com.zhongyang.loginbybmob.view.IMainViewCallback;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements IMainViewCallback {

    @BindView(R.id.tv_mainState)
    TextView tv_mainState;
    @BindView(R.id.cl_mainLoading)
    ConstraintLayout cl_mainLoading;
    @BindView(R.id.rv_userList)
    RecyclerView rv_userList;
    private IMainPresenterImpl mMainPresenter;
    private UserListAdapter mUserListAdapter;

    //------------------------实现父类的方法---------------------
    @Override
    protected int getResId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getStatusBarColor() {
        return super.getStatusBarColor();
    }

    @Override
    protected void setPresenterData() {
        //获取逻辑层操作对象
        mMainPresenter = MainPresenterImpl.getMainPresenter();
        //注册接口
        mMainPresenter.registerViewCallback(this);
        //获取用户列表
        mMainPresenter.getUserList();
    }

    @Override
    protected void initActivityView() {
        //设置适配器相关
        rv_userList.setLayoutManager(new LinearLayoutManager(this));//设置布局管理器
        mUserListAdapter = new UserListAdapter();//实例化适配器
        rv_userList.setAdapter(mUserListAdapter);//设置适配器
    }

    @Override
    protected void release() {
        //释放资源
        if (mMainPresenter != null) {
            mMainPresenter.unRegisterViewCallback(this);
        }
    }

    //------------------------实现父类的方法---------------------

    //-----------------------注册接口实现的方法------------------
    @Override
    public void onUserListLoaded(List<User> users) {
        //设置控件显示
        cl_mainLoading.setVisibility(View.GONE);
        rv_userList.setVisibility(View.VISIBLE);
        //将查询回来的数据给到适配器
        if (mUserListAdapter != null) {
            mUserListAdapter.setData(users);
        }
    }

    @Override
    public void onNteWorkError() {
        //提示用户
        Toast.makeText(this, "网络错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoading() {
        //设置控件显示
        cl_mainLoading.setVisibility(View.VISIBLE);
        rv_userList.setVisibility(View.GONE);
        //设置文字控件显示内容
        tv_mainState.setText("加载中...");
    }

    @Override
    public void onEmpty() {
        //设置控件显示
        cl_mainLoading.setVisibility(View.GONE);
        rv_userList.setVisibility(View.VISIBLE);
        //设置文字显示
        tv_mainState.setText("暂无用户");
    }
    //-----------------------注册接口实现的方法 end----------------
}