package com.pinnoocle.storeman.bean;

public class HomeModel {

    /**
     * data : {"list":{"today_total":0.11,"total_wechat":0.15,"total_alipay":0.03,"total_all":0.3,"scan_order_num":7,"pay_order_num":25,"df_order_num":0,"dt_order_num":18}}
     * code : 1
     * msg : 获取成功
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
         * list : {"today_total":0.11,"total_wechat":0.15,"total_alipay":0.03,"total_all":0.3,"scan_order_num":7,"pay_order_num":25,"df_order_num":0,"dt_order_num":18}
         */

        private ListBean list;

        public ListBean getList() {
            return list;
        }

        public void setList(ListBean list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * today_total : 0.11
             * total_wechat : 0.15
             * total_alipay : 0.03
             * total_all : 0.3
             * scan_order_num : 7
             * pay_order_num : 25
             * df_order_num : 0
             * dt_order_num : 18
             */

            private double today_total;
            private double total_wechat;
            private double total_alipay;
            private double total_all;
            private int scan_order_num;
            private int pay_order_num;
            private int df_order_num;
            private int dt_order_num;

            public double getToday_total() {
                return today_total;
            }

            public void setToday_total(double today_total) {
                this.today_total = today_total;
            }

            public double getTotal_wechat() {
                return total_wechat;
            }

            public void setTotal_wechat(double total_wechat) {
                this.total_wechat = total_wechat;
            }

            public double getTotal_alipay() {
                return total_alipay;
            }

            public void setTotal_alipay(double total_alipay) {
                this.total_alipay = total_alipay;
            }

            public double getTotal_all() {
                return total_all;
            }

            public void setTotal_all(double total_all) {
                this.total_all = total_all;
            }

            public int getScan_order_num() {
                return scan_order_num;
            }

            public void setScan_order_num(int scan_order_num) {
                this.scan_order_num = scan_order_num;
            }

            public int getPay_order_num() {
                return pay_order_num;
            }

            public void setPay_order_num(int pay_order_num) {
                this.pay_order_num = pay_order_num;
            }

            public int getDf_order_num() {
                return df_order_num;
            }

            public void setDf_order_num(int df_order_num) {
                this.df_order_num = df_order_num;
            }

            public int getDt_order_num() {
                return dt_order_num;
            }

            public void setDt_order_num(int dt_order_num) {
                this.dt_order_num = dt_order_num;
            }
        }
    }
}
