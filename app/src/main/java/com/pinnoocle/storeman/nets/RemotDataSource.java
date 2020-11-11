package com.pinnoocle.storeman.nets;

import java.util.Map;

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

    void classIndex(getCallback callback);
}
