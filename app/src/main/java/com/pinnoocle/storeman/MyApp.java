package com.pinnoocle.storeman;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.storeman.util.FastData;
import com.pinnoocle.storeman.util.TTSUtils;

import cn.jpush.android.api.JPushInterface;

public class MyApp extends Application {
    public static Context instanse;
    public static boolean isForeground = false;
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";
    public static final String MESSAGE_RECEIVED_ACTION = "com.pinnoocle.storeman.MESSAGE_RECEIVED_ACTION";
    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this);
        instanse = this;
        FastData.getInstance();
        JPushInterface.setDebugMode(true);//打印log
        JPushInterface.init(this);
        MultiDex.install(this);
        SpeechUtility.createUtility(this, SpeechConstant.APPID +"=5ee9d94e");
        TTSUtils.getInstance().init();
    }

    public static Context getInstanse() {
        return instanse;
    }
}
