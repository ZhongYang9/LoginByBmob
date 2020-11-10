package com.zhongyang.loginbybmob.base;

import android.app.Application;
import android.content.Context;

import com.zhongyang.loginbybmob.utils.Constants;

import cn.bmob.v3.Bmob;

/**
 * @项目名称 LoginByBmob
 * @类名 BaseApplication
 * @包名 com.zhongyang.loginbybmob.base
 * @创建时间 2020/11/10 13:34
 * @作者 钟阳
 * @描述
 */
public class BaseApplication extends Application {

    public static Context sContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        //配置Bmob后端云
        Bmob.initialize(this, Constants.BMOB_AP_KEY);
        //实例化上下文参数
        sContext = getBaseContext();
    }

    /**
     * 用于全局获取上下文
     *
     * @return
     */
    public static Context getAppContext() {
        return sContext;
    }
}
