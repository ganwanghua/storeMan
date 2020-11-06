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
}
