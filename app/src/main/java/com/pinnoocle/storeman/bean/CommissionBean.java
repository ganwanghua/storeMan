package com.pinnoocle.storeman.bean;

import java.util.List;

public class CommissionBean {
    /**
     * data : {"list":{"total":1460,"per_page":15,"current_page":1,"last_page":98,"data":[{"log_id":3911,"user_id":19119,"source_id":14918,"money":"0.66","remark":"爆款商品：芒果酸奶商家分成，订单id：18908","type":null,"create_time":"2020-11-10 17:11:19","wxapp_id":10001,"nickName":"知一万毕????","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/wMibdN0u6vu16YGNJNI86ZcylmhOs69tCBLm4kYad5ebgYhtia44cX2bxFQTSJG2uT4xSmZfvOoyFQTbknR6GbMQ/132"},{"log_id":3912,"user_id":14844,"source_id":14918,"money":"0.66","remark":"爆款商品：芒果酸奶商旅分成，订单id：18908","type":null,"create_time":"2020-11-10 17:11:19","wxapp_id":10001,"nickName":"知一万毕????","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/wMibdN0u6vu16YGNJNI86ZcylmhOs69tCBLm4kYad5ebgYhtia44cX2bxFQTSJG2uT4xSmZfvOoyFQTbknR6GbMQ/132"},{"log_id":3913,"user_id":14825,"source_id":14918,"money":"0.11","remark":"爆款商品：芒果酸奶董事分成，订单id：18908","type":null,"create_time":"2020-11-10 17:11:19","wxapp_id":10001,"nickName":"知一万毕????","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/wMibdN0u6vu16YGNJNI86ZcylmhOs69tCBLm4kYad5ebgYhtia44cX2bxFQTSJG2uT4xSmZfvOoyFQTbknR6GbMQ/132"},{"log_id":3909,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商家分成，订单id：18906","type":null,"create_time":"2020-11-09 22:57:57","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3910,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商旅分成，订单id：18906","type":null,"create_time":"2020-11-09 22:57:57","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3907,"user_id":14864,"source_id":17220,"money":"0.05","remark":"爆款商品：苹果约300g商家分成，订单id：18905","type":null,"create_time":"2020-11-09 22:57:13","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3908,"user_id":14864,"source_id":17220,"money":"0.05","remark":"爆款商品：苹果约300g商旅分成，订单id：18905","type":null,"create_time":"2020-11-09 22:57:13","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3905,"user_id":14864,"source_id":17220,"money":"0.05","remark":"爆款商品：苹果约300g商家分成，订单id：18904","type":null,"create_time":"2020-11-09 22:56:37","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3906,"user_id":14864,"source_id":17220,"money":"0.05","remark":"爆款商品：苹果约300g商旅分成，订单id：18904","type":null,"create_time":"2020-11-09 22:56:37","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3903,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商家分成，订单id：18903","type":null,"create_time":"2020-11-09 22:55:20","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3904,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商旅分成，订单id：18903","type":null,"create_time":"2020-11-09 22:55:20","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3901,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商家分成，订单id：18902","type":null,"create_time":"2020-11-09 22:54:40","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3902,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商旅分成，订单id：18902","type":null,"create_time":"2020-11-09 22:54:40","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3899,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：橘子商家分成，订单id：18901","type":null,"create_time":"2020-11-09 22:52:22","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3900,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：橘子商旅分成，订单id：18901","type":null,"create_time":"2020-11-09 22:52:22","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"}]},"count":{"total":0,"month_total":0}}
     * code : 1
     * msg : 获取成功
     */

    private DataBeanX data;
    private int code;
    private String msg;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
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

    public static class DataBeanX {
        /**
         * list : {"total":1460,"per_page":15,"current_page":1,"last_page":98,"data":[{"log_id":3911,"user_id":19119,"source_id":14918,"money":"0.66","remark":"爆款商品：芒果酸奶商家分成，订单id：18908","type":null,"create_time":"2020-11-10 17:11:19","wxapp_id":10001,"nickName":"知一万毕????","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/wMibdN0u6vu16YGNJNI86ZcylmhOs69tCBLm4kYad5ebgYhtia44cX2bxFQTSJG2uT4xSmZfvOoyFQTbknR6GbMQ/132"},{"log_id":3912,"user_id":14844,"source_id":14918,"money":"0.66","remark":"爆款商品：芒果酸奶商旅分成，订单id：18908","type":null,"create_time":"2020-11-10 17:11:19","wxapp_id":10001,"nickName":"知一万毕????","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/wMibdN0u6vu16YGNJNI86ZcylmhOs69tCBLm4kYad5ebgYhtia44cX2bxFQTSJG2uT4xSmZfvOoyFQTbknR6GbMQ/132"},{"log_id":3913,"user_id":14825,"source_id":14918,"money":"0.11","remark":"爆款商品：芒果酸奶董事分成，订单id：18908","type":null,"create_time":"2020-11-10 17:11:19","wxapp_id":10001,"nickName":"知一万毕????","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/wMibdN0u6vu16YGNJNI86ZcylmhOs69tCBLm4kYad5ebgYhtia44cX2bxFQTSJG2uT4xSmZfvOoyFQTbknR6GbMQ/132"},{"log_id":3909,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商家分成，订单id：18906","type":null,"create_time":"2020-11-09 22:57:57","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3910,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商旅分成，订单id：18906","type":null,"create_time":"2020-11-09 22:57:57","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3907,"user_id":14864,"source_id":17220,"money":"0.05","remark":"爆款商品：苹果约300g商家分成，订单id：18905","type":null,"create_time":"2020-11-09 22:57:13","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3908,"user_id":14864,"source_id":17220,"money":"0.05","remark":"爆款商品：苹果约300g商旅分成，订单id：18905","type":null,"create_time":"2020-11-09 22:57:13","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3905,"user_id":14864,"source_id":17220,"money":"0.05","remark":"爆款商品：苹果约300g商家分成，订单id：18904","type":null,"create_time":"2020-11-09 22:56:37","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3906,"user_id":14864,"source_id":17220,"money":"0.05","remark":"爆款商品：苹果约300g商旅分成，订单id：18904","type":null,"create_time":"2020-11-09 22:56:37","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3903,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商家分成，订单id：18903","type":null,"create_time":"2020-11-09 22:55:20","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3904,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商旅分成，订单id：18903","type":null,"create_time":"2020-11-09 22:55:20","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3901,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商家分成，订单id：18902","type":null,"create_time":"2020-11-09 22:54:40","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3902,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商旅分成，订单id：18902","type":null,"create_time":"2020-11-09 22:54:40","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3899,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：橘子商家分成，订单id：18901","type":null,"create_time":"2020-11-09 22:52:22","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3900,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：橘子商旅分成，订单id：18901","type":null,"create_time":"2020-11-09 22:52:22","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"}]}
         * count : {"total":0,"month_total":0}
         */

        private ListBean list;
        private CountBean count;

        public ListBean getList() {
            return list;
        }

        public void setList(ListBean list) {
            this.list = list;
        }

        public CountBean getCount() {
            return count;
        }

        public void setCount(CountBean count) {
            this.count = count;
        }

        public static class ListBean {
            /**
             * total : 1460
             * per_page : 15
             * current_page : 1
             * last_page : 98
             * data : [{"log_id":3911,"user_id":19119,"source_id":14918,"money":"0.66","remark":"爆款商品：芒果酸奶商家分成，订单id：18908","type":null,"create_time":"2020-11-10 17:11:19","wxapp_id":10001,"nickName":"知一万毕????","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/wMibdN0u6vu16YGNJNI86ZcylmhOs69tCBLm4kYad5ebgYhtia44cX2bxFQTSJG2uT4xSmZfvOoyFQTbknR6GbMQ/132"},{"log_id":3912,"user_id":14844,"source_id":14918,"money":"0.66","remark":"爆款商品：芒果酸奶商旅分成，订单id：18908","type":null,"create_time":"2020-11-10 17:11:19","wxapp_id":10001,"nickName":"知一万毕????","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/wMibdN0u6vu16YGNJNI86ZcylmhOs69tCBLm4kYad5ebgYhtia44cX2bxFQTSJG2uT4xSmZfvOoyFQTbknR6GbMQ/132"},{"log_id":3913,"user_id":14825,"source_id":14918,"money":"0.11","remark":"爆款商品：芒果酸奶董事分成，订单id：18908","type":null,"create_time":"2020-11-10 17:11:19","wxapp_id":10001,"nickName":"知一万毕????","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/wMibdN0u6vu16YGNJNI86ZcylmhOs69tCBLm4kYad5ebgYhtia44cX2bxFQTSJG2uT4xSmZfvOoyFQTbknR6GbMQ/132"},{"log_id":3909,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商家分成，订单id：18906","type":null,"create_time":"2020-11-09 22:57:57","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3910,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商旅分成，订单id：18906","type":null,"create_time":"2020-11-09 22:57:57","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3907,"user_id":14864,"source_id":17220,"money":"0.05","remark":"爆款商品：苹果约300g商家分成，订单id：18905","type":null,"create_time":"2020-11-09 22:57:13","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3908,"user_id":14864,"source_id":17220,"money":"0.05","remark":"爆款商品：苹果约300g商旅分成，订单id：18905","type":null,"create_time":"2020-11-09 22:57:13","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3905,"user_id":14864,"source_id":17220,"money":"0.05","remark":"爆款商品：苹果约300g商家分成，订单id：18904","type":null,"create_time":"2020-11-09 22:56:37","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3906,"user_id":14864,"source_id":17220,"money":"0.05","remark":"爆款商品：苹果约300g商旅分成，订单id：18904","type":null,"create_time":"2020-11-09 22:56:37","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3903,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商家分成，订单id：18903","type":null,"create_time":"2020-11-09 22:55:20","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3904,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商旅分成，订单id：18903","type":null,"create_time":"2020-11-09 22:55:20","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3901,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商家分成，订单id：18902","type":null,"create_time":"2020-11-09 22:54:40","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3902,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：香蕉250g商旅分成，订单id：18902","type":null,"create_time":"2020-11-09 22:54:40","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3899,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：橘子商家分成，订单id：18901","type":null,"create_time":"2020-11-09 22:52:22","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"},{"log_id":3900,"user_id":14864,"source_id":17220,"money":"0.03","remark":"爆款商品：橘子商旅分成，订单id：18901","type":null,"create_time":"2020-11-09 22:52:22","wxapp_id":10001,"nickName":"涂成文","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/GCWrD9vukLyp2xJyyTFCspH83kgRrV5MXUp7icTk2p4nWODnkpdurBPDRHqQWAemzfYb2g0wn7klr3RwV2QoB8Q/132"}]
             */

            private int total;
            private int per_page;
            private int current_page;
            private int last_page;
            private List<DataBean> data;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPer_page() {
                return per_page;
            }

            public void setPer_page(int per_page) {
                this.per_page = per_page;
            }

            public int getCurrent_page() {
                return current_page;
            }

            public void setCurrent_page(int current_page) {
                this.current_page = current_page;
            }

            public int getLast_page() {
                return last_page;
            }

            public void setLast_page(int last_page) {
                this.last_page = last_page;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * log_id : 3911
                 * user_id : 19119
                 * source_id : 14918
                 * money : 0.66
                 * remark : 爆款商品：芒果酸奶商家分成，订单id：18908
                 * type : null
                 * create_time : 2020-11-10 17:11:19
                 * wxapp_id : 10001
                 * nickName : 知一万毕????
                 * avatarUrl : https://thirdwx.qlogo.cn/mmopen/vi_32/wMibdN0u6vu16YGNJNI86ZcylmhOs69tCBLm4kYad5ebgYhtia44cX2bxFQTSJG2uT4xSmZfvOoyFQTbknR6GbMQ/132
                 */

                private int log_id;
                private int user_id;
                private int source_id;
                private String money;
                private String remark;
                private Object type;
                private String create_time;
                private int wxapp_id;
                private String nickName;
                private String avatarUrl;

                public int getLog_id() {
                    return log_id;
                }

                public void setLog_id(int log_id) {
                    this.log_id = log_id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public int getSource_id() {
                    return source_id;
                }

                public void setSource_id(int source_id) {
                    this.source_id = source_id;
                }

                public String getMoney() {
                    return money;
                }

                public void setMoney(String money) {
                    this.money = money;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public Object getType() {
                    return type;
                }

                public void setType(Object type) {
                    this.type = type;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }

                public int getWxapp_id() {
                    return wxapp_id;
                }

                public void setWxapp_id(int wxapp_id) {
                    this.wxapp_id = wxapp_id;
                }

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public String getAvatarUrl() {
                    return avatarUrl;
                }

                public void setAvatarUrl(String avatarUrl) {
                    this.avatarUrl = avatarUrl;
                }
            }
        }

        public static class CountBean {
            /**
             * total : 0
             * month_total : 0
             */

            private double total;
            private double month_total;

            public double getTotal() {
                return total;
            }

            public void setTotal(double total) {
                this.total = total;
            }

            public double getMonth_total() {
                return month_total;
            }

            public void setMonth_total(double month_total) {
                this.month_total = month_total;
            }
        }
    }
}
