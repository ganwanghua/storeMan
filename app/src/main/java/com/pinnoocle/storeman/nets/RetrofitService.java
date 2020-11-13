package com.pinnoocle.storeman.nets;

import com.pinnoocle.storeman.bean.AddressBean;
import com.pinnoocle.storeman.bean.AliPayBean;
import com.pinnoocle.storeman.bean.ByNowClassBean;
import com.pinnoocle.storeman.bean.ClassBean;
import com.pinnoocle.storeman.bean.ClassDetailBean;
import com.pinnoocle.storeman.bean.ClassListBean;
import com.pinnoocle.storeman.bean.CommissionBean;
import com.pinnoocle.storeman.bean.HomeModel;
import com.pinnoocle.storeman.bean.MyClassBean;
import com.pinnoocle.storeman.bean.MyClassDetailsBean;
import com.pinnoocle.storeman.bean.MyMoneyBean;
import com.pinnoocle.storeman.bean.NewUserLogin;
import com.pinnoocle.storeman.bean.OrderBean;
import com.pinnoocle.storeman.bean.OrderDetailBean;
import com.pinnoocle.storeman.bean.PackageManagerBean;
import com.pinnoocle.storeman.bean.PersonalBean;
import com.pinnoocle.storeman.bean.QrCodeBean;
import com.pinnoocle.storeman.bean.RefundBean;
import com.pinnoocle.storeman.bean.StatusBean;
import com.pinnoocle.storeman.bean.UserManagerBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by whs on 2017/2/17
 * Retrofit 接口
 */

public interface RetrofitService {
    // 登录
    @POST("index.php?s=/shop/api.passport/login")
    Observable<NewUserLogin> login(@QueryMap Map<String, String> queryMap);

    // 首页
    @POST("index.php?s=/shop/api.index/indexNew")
    Observable<HomeModel> indexNew(@QueryMap Map<String, String> queryMap);

    // 套餐列表
    @POST("index.php?s=/shop/api.goods/goodsList")
    Observable<PackageManagerBean> goodsList(@QueryMap Map<String, String> queryMap);

    // 修改套餐状态
    @POST("index.php?s=/shop/api.goods/goodsStatus")
    Observable<StatusBean> goodsStatus(@QueryMap Map<String, String> queryMap);

    // 用户管理
    @POST("index.php?s=/shop/api.index/myTeam")
    Observable<UserManagerBean> myTeam(@QueryMap Map<String, String> queryMap);

    // 收款码
    @POST("index.php?s=/shop/api.index/getPaycode")
    Observable<QrCodeBean> getPayCode(@QueryMap Map<String, String> queryMap);

    // 个人中心
    @POST("index.php?s=/shop/api.index/shop")
    Observable<PersonalBean> shop(@QueryMap Map<String, String> queryMap);

    // 订单列表
    @POST("index.php?s=/shop/api.order/orderList")
    Observable<OrderBean> orderList(@QueryMap Map<String, String> queryMap);

    // 售后列表
    @POST("index.php?s=/shop/api.order/refundList")
    Observable<RefundBean> refundList(@QueryMap Map<String, String> queryMap);

    // 扫码核销
    @POST("index.php?s=/shop/api.order/extract")
    Observable<StatusBean> extract(@QueryMap Map<String, String> queryMap);

    // 订单详情
    @POST("index.php?s=/shop/api.order/orderDetail")
    Observable<OrderDetailBean> orderDetail(@QueryMap Map<String, String> queryMap);

    // 我的资产
    @POST("index.php?s=/shop/api.index/myMoney")
    Observable<MyMoneyBean> myMoney(@QueryMap Map<String, String> queryMap);

    // 佣金明细
    @POST("index.php?s=/shop/api.index/commission")
    Observable<CommissionBean> commission(@QueryMap Map<String, String> queryMap);

    // 课程分类
    @POST("index.php?s=/shop/api.index/classIndex")
    Observable<ClassBean> classIndex();

    // 课程列表
    @POST("index.php?s=/shop/api.index/classList")
    Observable<ClassListBean> classList(@QueryMap Map<String, String> queryMap);

    // 课程详情
    @POST("index.php?s=/shop/api.goods/detail")
    Observable<ClassDetailBean> classDetail(@QueryMap Map<String, String> queryMap);

    // 我的课程
    @POST("index.php?s=/shop/api.user/order")
    Observable<MyClassBean> order(@QueryMap Map<String, String> queryMap);

    // 我的课程详情
    @POST("index.php?s=/shop/api.user/orderDetail")
    Observable<MyClassDetailsBean> MyOrderDetail(@QueryMap Map<String, String> queryMap);

    // 课程购买
    @GET("index.php")
    Observable<ByNowClassBean> buyNow(@Query("s") String s, @Query("goods_id") String goods_id, @Query("goods_num") String goods_num, @Query("goods_sku_id") String goods_sku_id,
                                      @Query("shop_id") String shop_id);

    // 支付
    @POST("index.php?s=/shop/api.pay/buyNow")
    Observable<AliPayBean> buyPay(@QueryMap Map<String, String> queryMap);

    // 收货地址
    @POST("index.php?s=/shop/api.address/lists")
    Observable<AddressBean> lists(@QueryMap Map<String, String> queryMap);

    // 新增收货地址
    @POST("index.php?s=/shop/api.address/add")
    Observable<StatusBean> add(@QueryMap Map<String, String> queryMap);

    // 设置默认地址
    @POST("index.php?s=/shop/api.address/setDefault")
    Observable<StatusBean> setDefault(@QueryMap Map<String, String> queryMap);

    // 修改地址
    @POST("index.php?s=/shop/api.address/edit")
    Observable<StatusBean> edit(@QueryMap Map<String, String> queryMap);

    // 删除地址
    @POST("index.php?s=/shop/api.address/delete")
    Observable<StatusBean> delete(@QueryMap Map<String, String> queryMap);
}
