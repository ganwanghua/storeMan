package com.pinnoocle.storeman.nets;


import android.content.Context;

import com.pinnoocle.storeman.bean.CommissionBean;
import com.pinnoocle.storeman.bean.HomeModel;
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
}
