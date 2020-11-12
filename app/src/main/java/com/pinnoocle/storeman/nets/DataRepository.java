package com.pinnoocle.storeman.nets;

import android.content.Context;

import java.util.Map;

/**
 * Created by whs on 2017/5/18
 */

public class DataRepository implements RemotDataSource {
    private Context mContext;

    private static DataRepository INSTANCE = null;


    private final RemotDataSourceImpl mRemoteDataSource;

    public static DataRepository getInstance(RemotDataSourceImpl remoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DataRepository(remoteDataSource);
        }
        return INSTANCE;
    }

    private DataRepository(RemotDataSourceImpl remoteDataSource) {
        //this.mContext=context;
        this.mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void login(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.login(queryMap, callback);
    }

    @Override
    public void indexNew(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.indexNew(queryMap, callback);
    }

    @Override
    public void goodsList(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.goodsList(queryMap, callback);
    }

    @Override
    public void goodsStatus(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.goodsStatus(queryMap, callback);
    }

    @Override
    public void myTeam(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.myTeam(queryMap, callback);
    }

    @Override
    public void getPayCode(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.getPayCode(queryMap, callback);
    }

    @Override
    public void shop(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.shop(queryMap, callback);
    }

    @Override
    public void orderList(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.orderList(queryMap, callback);
    }

    @Override
    public void refundList(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.refundList(queryMap, callback);
    }

    @Override
    public void extract(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.extract(queryMap, callback);
    }

    @Override
    public void orderDetail(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.orderDetail(queryMap, callback);
    }

    @Override
    public void myMoney(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.myMoney(queryMap, callback);
    }

    @Override
    public void commission(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.commission(queryMap, callback);
    }

    @Override
    public void classList(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.classList(queryMap, callback);
    }

    @Override
    public void classDetail(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.classDetail(queryMap, callback);
    }

    @Override
    public void order(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.order(queryMap, callback);
    }

    @Override
    public void MyOrderDetail(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.MyOrderDetail(queryMap, callback);
    }

    @Override
    public void buyPay(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.buyPay(queryMap, callback);
    }

    @Override
    public void lists(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.lists(queryMap, callback);
    }

    @Override
    public void classIndex(getCallback callback) {
        mRemoteDataSource.classIndex(callback);
    }

    @Override
    public void buyNow(String s, String goods_id, String goods_num, String goods_sku_id,
                       String shop_id, getCallback callback) {
        mRemoteDataSource.buyNow(s, goods_id, goods_num, goods_sku_id, shop_id, callback);
    }
}
