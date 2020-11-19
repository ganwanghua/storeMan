package com.pinnoocle.storeman.nets;


import android.content.Context;

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
import retrofit2.http.Path;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by whs on 2017/5/18
 */

public class RemotDataSourceImpl implements RemotDataSource {

    private static Context mContext;

    private static class Laydz {
        private static RemotDataSourceImpl instance = new RemotDataSourceImpl();
    }


    public static RemotDataSourceImpl getInstance(Context context) {
        mContext = context;
        return Laydz.instance;
    }

    @Override
    public void login(Map<String, String> queryMap, final getCallback callback) {
        Observable<NewUserLogin> observable = RetrofitHelper.getInstance(mContext).getServer().login(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewUserLogin>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(NewUserLogin s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void indexNew(Map<String, String> queryMap, final getCallback callback) {
        Observable<HomeModel> observable = RetrofitHelper.getInstance(mContext).getServer().indexNew(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(HomeModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void goodsList(Map<String, String> queryMap, final getCallback callback) {
        Observable<PackageManagerBean> observable = RetrofitHelper.getInstance(mContext).getServer().goodsList(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PackageManagerBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(PackageManagerBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void goodsStatus(Map<String, String> queryMap, final getCallback callback) {
        Observable<StatusBean> observable = RetrofitHelper.getInstance(mContext).getServer().goodsStatus(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void myTeam(Map<String, String> queryMap, final getCallback callback) {
        Observable<UserManagerBean> observable = RetrofitHelper.getInstance(mContext).getServer().myTeam(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserManagerBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(UserManagerBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void getPayCode(Map<String, String> queryMap, final getCallback callback) {
        Observable<QrCodeBean> observable = RetrofitHelper.getInstance(mContext).getServer().getPayCode(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<QrCodeBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(QrCodeBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void shop(Map<String, String> queryMap, final getCallback callback) {
        Observable<PersonalBean> observable = RetrofitHelper.getInstance(mContext).getServer().shop(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PersonalBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(PersonalBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void orderList(Map<String, String> queryMap, final getCallback callback) {
        Observable<OrderBean> observable = RetrofitHelper.getInstance(mContext).getServer().orderList(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(OrderBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void refundList(Map<String, String> queryMap, final getCallback callback) {
        Observable<RefundBean> observable = RetrofitHelper.getInstance(mContext).getServer().refundList(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RefundBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(RefundBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void extract(Map<String, String> queryMap, final getCallback callback) {
        Observable<StatusBean> observable = RetrofitHelper.getInstance(mContext).getServer().extract(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void orderDetail(Map<String, String> queryMap, final getCallback callback) {
        Observable<OrderDetailBean> observable = RetrofitHelper.getInstance(mContext).getServer().orderDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderDetailBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(OrderDetailBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void myMoney(Map<String, String> queryMap, final getCallback callback) {
        Observable<MyMoneyBean> observable = RetrofitHelper.getInstance(mContext).getServer().myMoney(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyMoneyBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(MyMoneyBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void commission(Map<String, String> queryMap, final getCallback callback) {
        Observable<CommissionBean> observable = RetrofitHelper.getInstance(mContext).getServer().commission(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommissionBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(CommissionBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void classIndex(final getCallback callback) {
        Observable<ClassBean> observable = RetrofitHelper.getInstance(mContext).getServer().classIndex();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClassBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ClassBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void classList(Map<String, String> queryMap, final getCallback callback) {
        Observable<ClassListBean> observable = RetrofitHelper.getInstance(mContext).getServer().classList(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClassListBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ClassListBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void classDetail(Map<String, String> queryMap, final getCallback callback) {
        Observable<ClassDetailBean> observable = RetrofitHelper.getInstance(mContext).getServer().classDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClassDetailBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ClassDetailBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void order(Map<String, String> queryMap, final getCallback callback) {
        Observable<MyClassBean> observable = RetrofitHelper.getInstance(mContext).getServer().order(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyClassBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(MyClassBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void MyOrderDetail(Map<String, String> queryMap, final getCallback callback) {
        Observable<MyClassDetailsBean> observable = RetrofitHelper.getInstance(mContext).getServer().MyOrderDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyClassDetailsBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(MyClassDetailsBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void buyNow(String s, String goods_id, String goods_num, String goods_sku_id,
                       String shop_id, final getCallback callback) {
        Observable<ByNowClassBean> observable = RetrofitHelper.getInstance(mContext).getServer().buyNow(s, goods_id, goods_num, goods_sku_id, shop_id);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ByNowClassBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ByNowClassBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void buyPay(Map<String, String> queryMap, final getCallback callback) {
        Observable<AliPayBean> observable = RetrofitHelper.getInstance(mContext).getServer().buyPay(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AliPayBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(AliPayBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void lists(Map<String, String> queryMap, final getCallback callback) {
        Observable<AddressBean> observable = RetrofitHelper.getInstance(mContext).getServer().lists(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddressBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(AddressBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void add(Map<String, String> queryMap, final getCallback callback) {
        Observable<StatusBean> observable = RetrofitHelper.getInstance(mContext).getServer().add(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void setDefault(Map<String, String> queryMap, final getCallback callback) {
        Observable<StatusBean> observable = RetrofitHelper.getInstance(mContext).getServer().setDefault(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void edit(Map<String, String> queryMap, final getCallback callback) {
        Observable<StatusBean> observable = RetrofitHelper.getInstance(mContext).getServer().edit(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void delete(Map<String, String> queryMap, final getCallback callback) {
        Observable<StatusBean> observable = RetrofitHelper.getInstance(mContext).getServer().delete(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void switchNotice(Map<String, String> queryMap, final getCallback callback) {
        Observable<StatusBean> observable = RetrofitHelper.getInstance(mContext).getServer().switchNotice(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void search(Map<String, String> queryMap, final getCallback callback) {
        Observable<SearchBean> observable = RetrofitHelper.getInstance(mContext).getServer().search(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(SearchBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void applyInfo(Map<String, String> queryMap, final getCallback callback) {
        Observable<ApplyInfoBean> observable = RetrofitHelper.getInstance(mContext).getServer().applyInfo(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApplyInfoBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ApplyInfoBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void pay(Map<String, String> queryMap, final getCallback callback) {
        Observable<AliPayBean> observable = RetrofitHelper.getInstance(mContext).getServer().pay(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AliPayBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(AliPayBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void pays(Map<String, String> queryMap, final getCallback callback) {
        Observable<AliPayBean> observable = RetrofitHelper.getInstance(mContext).getServer().pays(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AliPayBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(AliPayBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void upUserHead(Map<String, String> queryMap, MultipartBody.Part file, final getCallback callback) {
        Observable<UploadModel> observable = RetrofitHelper.getInstance(mContext).getServer().upUserHead(queryMap, file);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UploadModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(UploadModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void apply(Map<String, String> queryMap, final getCallback callback) {
        Observable<StatusBean> observable = RetrofitHelper.getInstance(mContext).getServer().apply(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void express(Map<String, String> queryMap, final getCallback callback) {
        Observable<TraceBean> observable = RetrofitHelper.getInstance(mContext).getServer().express(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TraceBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(TraceBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void ScanList(Map<String, String> queryMap, final getCallback callback) {
        Observable<ScanBean> observable = RetrofitHelper.getInstance(mContext).getServer().ScanList(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ScanBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ScanBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void receipt(Map<String, String> queryMap, final getCallback callback) {
        Observable<StatusBean> observable = RetrofitHelper.getInstance(mContext).getServer().receipt(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusBean>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusBean s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }
}
