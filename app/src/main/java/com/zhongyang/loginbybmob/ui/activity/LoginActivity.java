package com.zhongyang.loginbybmob.ui.activity;

import com.zhongyang.loginbybmob.R;
import com.zhongyang.loginbybmob.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    //-----------------------复写父类的方法----------------------
    @Override
    protected int getResId() {
        return R.layout.activity_login;
    }

    @Override
    protected int getStatusBarColor() {
        return super.getStatusBarColor();
    }
    //-----------------------复写父类的方法 end----------------------
}