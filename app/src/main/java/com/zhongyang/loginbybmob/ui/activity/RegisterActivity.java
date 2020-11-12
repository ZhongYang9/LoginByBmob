package com.zhongyang.loginbybmob.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.zhongyang.loginbybmob.R;
import com.zhongyang.loginbybmob.base.BaseActivity;
import com.zhongyang.loginbybmob.model.damain.User;
import com.zhongyang.loginbybmob.presenter.IRegisterPresenterImpl;
import com.zhongyang.loginbybmob.presenter.Impl.RegisterPresenter;
import com.zhongyang.loginbybmob.view.IRegisterViewCallback;

import java.util.List;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity implements IRegisterViewCallback {

    private static final String TAG = "RegisterActivity";
    @BindView(R.id.ll_register)
    LinearLayout ll_register;
    @BindView(R.id.et_registerAccount)
    EditText et_registerAccount;
    @BindView(R.id.et_registerPwd)
    EditText et_registerPwd;
    @BindView(R.id.et_confirmPwd)
    EditText et_confirmPwd;
    private IRegisterPresenterImpl mRegisterPresenter;
    @BindView(R.id.cl_loading)
    ConstraintLayout cl_loading;
    @BindView(R.id.cl_container)
    ConstraintLayout cl_container;
    private String mAccount;
    private String mPassword;

    //------------------------------继承父类实现的一些方法-------------------------
    @Override
    protected int getResId() {
        return R.layout.activity_register;
    }

    @Override
    protected int getStatusBarColor() {
        return super.getStatusBarColor();
    }

    @Override
    protected void initListenerEvent() {
        //注册按钮点击事件
        ll_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注册事件
                registerEvent();
            }
        });
    }

    @Override
    protected void setPresenterData() {
        //获取注册逻辑层的操作对象
        mRegisterPresenter = RegisterPresenter.getRegisterPresenter();
        //注册接口，持有引用
        mRegisterPresenter.registerViewCallback(this);
    }

    //------------------------------继承父类实现的一些方法 end-------------------------

    //----------------------------注册逻辑层后实现的方法------------------------
    @Override
    public void onCheckUserResult(List<User> users) {
        //设置UI状态
        cl_loading.setVisibility(View.GONE);
        cl_container.setVisibility(View.VISIBLE);
        //提示用户账号已经存在
        Toast.makeText(this, "该用户已存在", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddUserResult(boolean isSuccess) {
        //添加用户的结果
        /*提示用户*/
        Toast.makeText(this, "注册成功，请登录", Toast.LENGTH_SHORT).show();
        /*关闭注册界面*/
        finish();
    }

    @Override
    public void onQuerying() {
        //设置加载布局未显示状态
        cl_loading.setVisibility(View.VISIBLE);
        cl_container.setVisibility(View.GONE);
    }

    @Override
    public void onNetWorkError() {
        //设置UI
        cl_loading.setVisibility(View.GONE);
        cl_container.setVisibility(View.VISIBLE);
        //提示用户
        Toast.makeText(this, "网络错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserIsEmpty() {
        //设置UI状态
        cl_loading.setVisibility(View.GONE);
        cl_container.setVisibility(View.VISIBLE);
        //用户不存在，可以进行注册
        /*封装数据*/
        User user = new User();
        user.setTelephone(mAccount);
        user.setPassword(mPassword);
        //交给逻辑层操作
        if (mRegisterPresenter != null) {
            mRegisterPresenter.addUser(user);
        }
    }
    //----------------------------注册逻辑层后实现的方法 end------------------------

    private void registerEvent() {
        /*获取输入框内容*/
        mAccount = et_registerAccount.getText().toString();
        mPassword = et_registerPwd.getText().toString();
        String confirmPwd = et_confirmPwd.getText().toString();
        /*校验输入框内容*/
        if (mAccount.isEmpty() || mPassword.isEmpty() || confirmPwd.isEmpty()) {
            Toast.makeText(this, "关键数据不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!mPassword.equals(confirmPwd)) {
            Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
            //清空密码输入框
            et_registerPwd.setText("");
            et_confirmPwd.setText("");
            return;
        }
        /*给密码加盐*/
        /*校验用户是否存在*/
        if (mRegisterPresenter != null) {
            mRegisterPresenter.checkedUser(mAccount);
        }
    }
}