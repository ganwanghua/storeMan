package com.pinnoocle.storeman.bean;

public class AliPayBean {
    /**
     * data : {"payment":"alipay_sdk=alipay-sdk-php-20161101&app_id=2021002110602174&biz_content=%7B%22body%22%3A%22%5Cu8ba2%5Cu5355%5Cu53f7SHOP_2020111218405050511015%22%2C%22subject%22%3A%22%5Cu8d2d%5Cu4e70%5Cu5546%5Cu54c1%22%2C%22out_trade_no%22%3A%22SHOP_2020111218405050511015_travel%22%2C%22total_amount%22%3A%220.01%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fdjsh.meiliancheng.cn%2F%2Findex.php%2Fapi%2Falipay%2Falipay_notify&sign_type=RSA2&timestamp=2020-11-12+18%3A40%3A51&version=1.0&sign=gQRlwIQLNh7Tkho4%2FEhwNcAaAcQz6fCC6eODzKEzLzv9Shsp%2FVg%2FGKWseC%2Fs08IA9LwjRBQ40SirZtm4SlVvjgmtuwLERmfC3Z7z2LaBIC%2FJdCqDCD%2BgzJyUYtjLH3nCI1DBZXFzVEY0qgMKBT%2FyvlmwsmPiIZM%2FKMaLHuNzmKggj4EjXFkDigFp4WlXwNjDdX%2FyklFSuTobqrBcz30LYK%2FI7bgITKHrtPdATSd2oeLcT90TyZum21peKzO64BCCKLXi%2F6NXvxJhQYAJCrW7dISo%2FbQvwnoOTXne%2FrXHqa8BXYbjjZFAs8jsAVqqL4DGsUVWu%2BOdbNoNsQXAk73S5w%3D%3D"}
     * code : 1
     * msg : 支付成功
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
         * payment : alipay_sdk=alipay-sdk-php-20161101&app_id=2021002110602174&biz_content=%7B%22body%22%3A%22%5Cu8ba2%5Cu5355%5Cu53f7SHOP_2020111218405050511015%22%2C%22subject%22%3A%22%5Cu8d2d%5Cu4e70%5Cu5546%5Cu54c1%22%2C%22out_trade_no%22%3A%22SHOP_2020111218405050511015_travel%22%2C%22total_amount%22%3A%220.01%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fdjsh.meiliancheng.cn%2F%2Findex.php%2Fapi%2Falipay%2Falipay_notify&sign_type=RSA2&timestamp=2020-11-12+18%3A40%3A51&version=1.0&sign=gQRlwIQLNh7Tkho4%2FEhwNcAaAcQz6fCC6eODzKEzLzv9Shsp%2FVg%2FGKWseC%2Fs08IA9LwjRBQ40SirZtm4SlVvjgmtuwLERmfC3Z7z2LaBIC%2FJdCqDCD%2BgzJyUYtjLH3nCI1DBZXFzVEY0qgMKBT%2FyvlmwsmPiIZM%2FKMaLHuNzmKggj4EjXFkDigFp4WlXwNjDdX%2FyklFSuTobqrBcz30LYK%2FI7bgITKHrtPdATSd2oeLcT90TyZum21peKzO64BCCKLXi%2F6NXvxJhQYAJCrW7dISo%2FbQvwnoOTXne%2FrXHqa8BXYbjjZFAs8jsAVqqL4DGsUVWu%2BOdbNoNsQXAk73S5w%3D%3D
         */

        private String payment;

        public String getPayment() {
            return payment;
        }

        public void setPayment(String payment) {
            this.payment = payment;
        }
    }
}
