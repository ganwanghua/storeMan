package com.pinnoocle.storeman.bean;

public class QrCodeBean {
    /**
     * data : {"qrcode":"http://djsh.meiliancheng.cn/QRcode/8521e72c4cc714b20c19aa1e9bf15707.png"}
     * code : 1
     * msg : 操作成功
     */

    private DataBean data;
    private int code;
    private String msg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * qrcode : http://djsh.meiliancheng.cn/QRcode/8521e72c4cc714b20c19aa1e9bf15707.png
         */

        private String qrcode;

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }
    }
}
