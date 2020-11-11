package com.zhongyang.loginbybmob.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.zhongyang.loginbybmob.R;
import com.zhongyang.loginbybmob.base.BaseActivity;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.ll_register)
    LinearLayout ll_register;
    @BindView(R.id.et_registerAccount)
    EditText et_registerAccount;
    @BindView(R.id.et_registerPwd)
    EditText et_registerPwd;
    @BindView(R.id.et_confirmPwd)
    EditText et_confirmPwd;

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

    private void registerEvent() {
        //TODO 获取输入框内容
    }

    //------------------------------继承父类实现的一些方法 end-------------------------
}