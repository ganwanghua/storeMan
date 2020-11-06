package com.pinnoocle.storeman.nets;

import com.pinnoocle.storeman.bean.HomeModel;
import com.pinnoocle.storeman.bean.NewUserLogin;
import com.pinnoocle.storeman.bean.PackageManagerBean;
import com.pinnoocle.storeman.bean.PersonalBean;
import com.pinnoocle.storeman.bean.QrCodeBean;
import com.pinnoocle.storeman.bean.StatusBean;
import com.pinnoocle.storeman.bean.UserManagerBean;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by whs on 2017/2/17
 * Retrofit 接口
 */

public interface RetrofitService {
    // 登录
    @POST("index.php?s=/shop/api.passport/login")
    Observable<NewUserLogin>login(@QueryMap Map<String, String> queryMap);

    // 首页
    @POST("index.php?s=/shop/api.index/indexNew")
    Observable<HomeModel>indexNew(@QueryMap Map<String, String> queryMap);

    // 套餐列表
    @POST("index.php?s=/shop/api.goods/goodsList")
    Observable<PackageManagerBean>goodsList(@QueryMap Map<String, String> queryMap);

    // 修改套餐状态
    @POST("index.php?s=/shop/api.goods/goodsStatus")
    Observable<StatusBean>goodsStatus(@QueryMap Map<String, String> queryMap);

    // 用户管理
    @POST("index.php?s=/shop/api.index/myTeam")
    Observable<UserManagerBean>myTeam(@QueryMap Map<String, String> queryMap);

    // 收款码
    @POST("index.php?s=/shop/api.index/getPaycode")
    Observable<QrCodeBean>getPayCode(@QueryMap Map<String, String> queryMap);

    // 个人中心
    @POST("index.php?s=/shop/api.index/shop")
    Observable<PersonalBean>shop(@QueryMap Map<String, String> queryMap);
}
