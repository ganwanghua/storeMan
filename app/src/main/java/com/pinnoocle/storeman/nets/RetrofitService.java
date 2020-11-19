package com.pinnoocle.storeman.nets;

import com.pinnoocle.storeman.bean.AddressBean;
import com.pinnoocle.storeman.bean.AliPayBean;
import com.pinnoocle.storeman.bean.ApplyInfoBean;
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
import com.pinnoocle.storeman.bean.ScanBean;
import com.pinnoocle.storeman.bean.SearchBean;
import com.pinnoocle.storeman.bean.StatusBean;
import com.pinnoocle.storeman.bean.TraceBean;
import com.pinnoocle.storeman.bean.UploadModel;
import com.pinnoocle.storeman.bean.UserManagerBean;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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

    // 是否开启通知
    @POST("index.php?s=/shop/api.index/switchNotice")
    Observable<StatusBean> switchNotice(@QueryMap Map<String, String> queryMap);

    // 商家搜索
    @POST("index.php?s=/shop/api.shop/search")
    Observable<SearchBean> search(@QueryMap Map<String, String> queryMap);

    // 商家入驻信息
    @POST("index.php?s=/shop/api.shop/applyInfo")
    Observable<ApplyInfoBean> applyInfo(@QueryMap Map<String, String> queryMap);

    // 待支付订单去支付
    @POST("index.php?s=/shop/api.user/pay")
    Observable<AliPayBean> pay(@QueryMap Map<String, String> queryMap);

    // 入驻支付
    @POST("index.php?s=/shop/api.shop/pay")
    Observable<AliPayBean> pays(@QueryMap Map<String, String> queryMap);

    // 图片上传
    @Multipart
    @POST("index.php?s=/api/upload/image")
    Observable<UploadModel> upUserHead(@QueryMap Map<String, String> queryMap, @Part MultipartBody.Part file);

    //申请入驻
    @POST("index.php?s=/shop/api.shop/apply")
    Observable<StatusBean> apply(@QueryMap Map<String, String> queryMap);

    //物流信息
    @POST("index.php?s=/shop/api.user/express")
    Observable<TraceBean> express(@QueryMap Map<String, String> queryMap);

    //扫码付款记录
    @POST("index.php?s=/shop/api.order/ScanList")
    Observable<ScanBean> ScanList(@QueryMap Map<String, String> queryMap);

    //确认收货
    @POST("index.php?s=/shop/api.user/receipt")
    Observable<StatusBean> receipt(@QueryMap Map<String, String> queryMap);
}
