package com.zhongyang.loginbybmob.base;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.zhongyang.loginbybmob.R;
import com.zhongyang.loginbybmob.utils.StatusBarUtil;

import butterknife.ButterKnife;

/**
 * @项目名称 LoginByBmob
 * @类名 BaseActivity
 * @包名 com.zhongyang.loginbybmob.base
 * @创建时间 2020/11/10 15:28
 * @作者 钟阳
 * @描述
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载子类布局ID
        setContentView(getResId());
        //设置状态字体颜色
        setStatusBar();
        //绑定黄油刀
        ButterKnife.bind(this);
        //设置逻辑层相关
        setPresenterData();
        //初始化活动监听事件
        initListenerEvent();
    }

    /**
     * 设置逻辑层数据，由子类根据情况自行实现
     */
    protected void setPresenterData() {

    }

    /**
     * 初始化监听事件，由子类根据情况自行实现
     */
    protected void initListenerEvent() {

    }

    protected abstract int getResId();

    /**
     * 设置状态栏颜色方法，由子类根据情况实现
     */
    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isUseFullScreenMode()) {
                StatusBarUtil.transparencyBar(this);
            } else {
                StatusBarUtil.setStatusBarColor(this, getStatusBarColor());
            }

            if (isUseBlackFontWithStatusBar()) {
                StatusBarUtil.setLightStatusBar(this, true, isUseFullScreenMode());
            }
        }
    }

    /**
     * 是否设置成透明状态栏，即就是全屏模式
     */
    protected boolean isUseFullScreenMode() {
        return true;
    }

    /**
     * 更改状态栏颜色，只有非全屏模式下有效
     */
    protected int getStatusBarColor() {
        return R.color.colorTransparent;
    }

    /**
     * 是否改变状态栏文字颜色为黑色，默认为黑色
     */
    protected boolean isUseBlackFontWithStatusBar() {
        return true;
    }
}
