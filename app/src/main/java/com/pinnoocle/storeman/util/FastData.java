package com.pinnoocle.storeman.util;


import com.pinnoocle.storeman.MyApp;

/**
 * Created by WS on 2019/1/4.
 */

public class FastData extends Remember {

    protected static Remember remember = null;

    private static final String SHARED_PREFS_NAME = "wineShop";

    public static synchronized Remember getInstance() {
        if (remember == null) {
            remember = init(MyApp.getInstanse(), SHARED_PREFS_NAME);
        }
        return remember;
    }

    //首次登录
    public static void setFirstLogin(String firstLogin) {
        putString("firstLogin", firstLogin);
    }

    public static String getFirstLogin() {
        return getString("firstLogin", "");
    }

    //保存shopId
    public static void setShopId(String uid) {
        putString("shopid", uid);
    }

    public static String getShopId() {
        return getString("shopid", "");
    }

    //保存账号
    public static void setPhone(String phone) {
        putString("phone", phone);
    }

    public static String getPhone() {
        return getString("phone", "");
    }

    //保存密码
    public static void setPwd(String pwd) {
        putString("pwd", pwd);
    }

    public static String getPwd() {
        return getString("pwd", "");
    }

    //是否启动音效
    public static void setSoundflag(boolean flag) {
        putBoolean("soundflag", flag);
    }

    public static boolean getSoundflag() {
        return getBoolean("soundflag", false);
    }


    //保存nickname
    public static void setNickName(String nickname) {
        putString("nickname", nickname);
    }

    public static String getNickName() {
        return getString("nickname", "");
    }


    //registration_id
    public static void setRegistration_id(String registration_id) {
        putString("registration_id", registration_id);
    }

    public static String getRegistration_id() {
        return getString("registration_id", "");
    }


    //token
    public static void setToken(String token) {
        putString("token", token);
    }

    public static String getToken() {
        return getString("token", "");
    }

    //保存店铺
    public static void setStoreName(String store) {
        putString("store", store);
    }

    public static String getStoreName() {
        return getString("store", "");
    }

    //保存店铺logo
    public static void setStoreLogo(String storelogo) {
        putString("storelogo", storelogo);
    }

    public static String getStoreLogo() {
        return getString("storelogo", "");
    }


    //通知信息
    public static void setCan_notice(String Can_notice) {
        putString("Can_notice", Can_notice);
    }

    public static String getCan_notice() {
        return getString("Can_notice", "");
    }

    //保存wxappid
    public static void setWxAppId(String wxAppId) {
        putString("wxapp_id", wxAppId);
    }

    public static String getWxAppId() {
        return getString("wxapp_id", "");
    }
}