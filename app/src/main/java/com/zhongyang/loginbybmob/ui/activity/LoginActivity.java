package com.zhongyang.loginbybmob.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.zhongyang.loginbybmob.R;
import com.zhongyang.loginbybmob.base.BaseActivity;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.tv_toRegister)
    TextView tv_toRegister;

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
        //去注册文字点击事件
        tv_toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到注册页面
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    //-----------------------复写父类的方法 end----------------------
}