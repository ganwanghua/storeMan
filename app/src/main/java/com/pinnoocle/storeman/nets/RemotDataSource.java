package com.pinnoocle.storeman.nets;

import java.util.Map;

import okhttp3.MultipartBody;

/**
 * Created by whs on 2017/6/7
 */

public interface RemotDataSource {
    interface getCallback {

        void onFailure(String info);

        void onSuccess(Object data);
    }

    void login(Map<String, String> queryMap, getCallback callback);

    void indexNew(Map<String, String> queryMap, getCallback callback);

    void goodsList(Map<String, String> queryMap, getCallback callback);

    void goodsStatus(Map<String, String> queryMap, getCallback callback);

    void myTeam(Map<String, String> queryMap, getCallback callback);

    void getPayCode(Map<String, String> queryMap, getCallback callback);

    void shop(Map<String, String> queryMap, getCallback callback);

    void orderList(Map<String, String> queryMap, getCallback callback);

    void refundList(Map<String, String> queryMap, getCallback callback);

    void extract(Map<String, String> queryMap, getCallback callback);

    void orderDetail(Map<String, String> queryMap, getCallback callback);

    void myMoney(Map<String, String> queryMap, getCallback callback);

    void commission(Map<String, String> queryMap, getCallback callback);

    void classList(Map<String, String> queryMap, getCallback callback);

    void classDetail(Map<String, String> queryMap, getCallback callback);

    void order(Map<String, String> queryMap, getCallback callback);

    void MyOrderDetail(Map<String, String> queryMap, getCallback callback);

    void buyPay(Map<String, String> queryMap, getCallback callback);

    void lists(Map<String, String> queryMap, getCallback callback);

    void add(Map<String, String> queryMap, getCallback callback);

    void setDefault(Map<String, String> queryMap, getCallback callback);

    void edit(Map<String, String> queryMap, getCallback callback);

    void delete(Map<String, String> queryMap, getCallback callback);

    void switchNotice(Map<String, String> queryMap, getCallback callback);

    void search(Map<String, String> queryMap, getCallback callback);

    void applyInfo(Map<String, String> queryMap, getCallback callback);

    void pay(Map<String, String> queryMap, getCallback callback);

    void pays(Map<String, String> queryMap, getCallback callback);

    void apply(Map<String, String> queryMap, getCallback callback);

    void express(Map<String, String> queryMap, getCallback callback);

    void ScanList(Map<String, String> queryMap, getCallback callback);

    void receipt(Map<String, String> queryMap, getCallback callback);

    void updateImei(Map<String, String> queryMap, getCallback callback);

    void withdraw(Map<String, String> queryMap, getCallback callback);

    void upUserHead(Map<String, String> queryMap, MultipartBody.Part file, getCallback callback);

    void classIndex(getCallback callback);

    void buyNow(String s, String goods_id, String goods_num, String goods_sku_id,
                String shop_id, getCallback callback);
}
