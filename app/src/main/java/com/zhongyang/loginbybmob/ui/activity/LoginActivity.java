package com.zhongyang.loginbybmob.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.zhongyang.loginbybmob.R;
import com.zhongyang.loginbybmob.base.BaseActivity;
import com.zhongyang.loginbybmob.model.domain.User;
import com.zhongyang.loginbybmob.presenter.ILoginPresenterImpl;
import com.zhongyang.loginbybmob.presenter.Impl.LoginPresenterImpl;
import com.zhongyang.loginbybmob.view.ILoginViewCallback;

import java.util.List;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements ILoginViewCallback {

    private static final String TAG = "LoginActivity";
    @BindView(R.id.tv_toRegister)
    TextView tv_toRegister;
    private ILoginPresenterImpl mLoginPresenter;
    @BindView(R.id.cl_toLogin)
    ConstraintLayout cl_toLogin;
    @BindView(R.id.et_account)
    EditText et_account;
    @BindView(R.id.et_password)
    EditText et_password;
    private String mAccount;
    private String mPassword;
    @BindView(R.id.cl_loginContainer)
    ConstraintLayout cl_loginContainer;
    @BindView(R.id.cl_loggingIn)
    ConstraintLayout cl_loggingIn;

    //-----------------------复写父类的方法----------------------
    @Override
    protected int getResId() {
        return R.layout.activity_login;
    }

    @Override
    protected int getStatusBarColor() {
        return super.getStatusBarColor();
    }

    @Override
    protected void initListenerEvent() {
        //登录按钮点击事件
        cl_toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //去登录
                toLogin();
            }
        });
        //去注册文字点击事件
        tv_toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到注册页面
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    @Override
    protected void setPresenterData() {
        //获取逻辑层对象
        mLoginPresenter = LoginPresenterImpl.getLoginPresenter();
        //注册接口
        mLoginPresenter.registerViewCallback(this);
    }

    @Override
    protected void release() {
        //释放资源
        if (mLoginPresenter != null) {
            mLoginPresenter.unRegisterViewCallback(this);
        }
    }
    //-----------------------复写父类的方法 end----------------------

    //-------------------实现逻辑层方法------------------------------
    @Override
    public void onCheckAccountResult(List<User> users) {
        //设置控件显示
        cl_loggingIn.setVisibility(View.GONE);
        cl_loginContainer.setVisibility(View.VISIBLE);
        //校验密码
        if (mLoginPresenter != null) {
            mLoginPresenter.checkPwd(mAccount, mPassword);
        }
    }

    @Override
    public void onCheckPwdResult(boolean isSuccess) {
        //密码正确，即可跳转
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        //关闭当前界面
        finish();
    }

    @Override
    public void onLoading() {
        //设置控件显示
        cl_loggingIn.setVisibility(View.VISIBLE);
        cl_loginContainer.setVisibility(View.GONE);
    }

    @Override
    public void onNetWorkError() {
        //设置控件显示
        cl_loggingIn.setVisibility(View.GONE);
        cl_loginContainer.setVisibility(View.VISIBLE);
        //提示用户
        Toast.makeText(this, "网络错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmpty() {
        //设置控件显示
        cl_loggingIn.setVisibility(View.GONE);
        cl_loginContainer.setVisibility(View.VISIBLE);
        //提示用户
        Toast.makeText(this, "账号未注册", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPwdError() {
        //提示用户密码错误
        Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
    }
    //-------------------实现逻辑层方法 end---------------------------

    private void toLogin() {
        /*获取输入框*/
        mAccount = et_account.getText().toString();
        mPassword = et_password.getText().toString();
        /*校验输入框内容*/
        if (mAccount.isEmpty() || mPassword.isEmpty()) {
            Toast.makeText(LoginActivity.this, "数据不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        /*调用校验账号方法*/
        if (mLoginPresenter != null) {
            mLoginPresenter.checkAccount(mAccount);
        }
    }
}