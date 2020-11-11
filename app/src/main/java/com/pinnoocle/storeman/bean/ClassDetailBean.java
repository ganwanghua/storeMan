package com.pinnoocle.storeman.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClassDetailBean {
    /**
     * data : {"detail":{"goods_id":12014,"shop_id":10020,"supplier_id":0,"type":3,"goods_name":"测试课程","selling_point":"测试课程测试课程测试课程测试课程","use_rule":null,"category_id":10541,"spec_type":10,"deduct_stock_type":10,"content":"<p><img src=\"http://dijiush.oss-cn-beijing.aliyuncs.com/20201022165000794ee0767.png\"/><\/p><p><span style=\"color: rgb(14, 23, 38); font-family: \" pingfang=\"\" helvetica=\"\" hiragino=\"\" sans=\"\" source=\"\" han=\"\" noto=\"\" cjk=\"\" microsoft=\"\" white-space:=\"\" background-color:=\"\"><\/span><br/><\/p>","content2":"","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":0,"delivery_type":20,"is_new_user_enjoy":0,"is_points_gift":1,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"10020":"","10021":"","10022":"","10023":"","10024":""},"is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","is_new_user":0,"new_need_points_num":0,"new_need_points_money":"0.00","video":null,"goods_status":{"text":"上架","value":10},"is_hot":1,"use_code":0,"is_check":1,"share_buy":0,"share_num":0,"view_num":155,"is_baopin":0,"is_ziyin":0,"is_pinpai":0,"brand_id":0,"comment_data_count":0,"goods_stock":6,"goods_image":"http://dijiush.oss-cn-beijing.aliyuncs.com/202009151725453455d7261.jpg","goods_sku":{"goods_sku_id":29175,"goods_id":12014,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.01","line_price":"0.00","real_price":"0.00","stock_num":6,"goods_sales":0,"goods_weight":0,"image":null},"goods_multi_spec":null,"is_user_grade":false,"bought_num":0,"is_like":0,"video_url":"","category":{"category_id":10541,"name":"扶商咨询","parent_id":0,"image_id":0,"sort":100,"type":3,"create_time":"2020-09-15 17:25:16"},"image":[{"id":31258,"goods_id":12014,"image_id":24584,"file_path":"http://dijiush.oss-cn-beijing.aliyuncs.com/202009151725453455d7261.jpg","file_name":"202009151725453455d7261.jpg","file_url":"http://dijiush.oss-cn-beijing.aliyuncs.com"}],"sku":[{"goods_sku_id":29175,"goods_id":12014,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.01","line_price":"0.00","real_price":"0.00","stock_num":6,"goods_sales":0,"goods_weight":0,"image":null}],"comment_data":[],"goods_sales":3},"specData":null,"videoList":[{"study_id":1,"goods_id":12014,"title":"测试1","video_id":25820,"sort":10,"free":0,"create_time":1600674149,"update_time":1600675906,"wxapp_id":10001,"is_delete":0,"video_url":"http://dijiush.oss-cn-beijing.aliyuncs.com/20200921154225ffd781956.mp4"},{"study_id":2,"goods_id":12014,"title":"测试222","video_id":32974,"sort":100,"free":1,"create_time":1603676280,"update_time":1603676280,"wxapp_id":10001,"is_delete":0,"video_url":"http://dijiush.oss-cn-beijing.aliyuncs.com/20201026093753c35035864.mp4"}]}
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
         * detail : {"goods_id":12014,"shop_id":10020,"supplier_id":0,"type":3,"goods_name":"测试课程","selling_point":"测试课程测试课程测试课程测试课程","use_rule":null,"category_id":10541,"spec_type":10,"deduct_stock_type":10,"content":"<p><img src=\"http://dijiush.oss-cn-beijing.aliyuncs.com/20201022165000794ee0767.png\"/><\/p><p><span style=\"color: rgb(14, 23, 38); font-family: \" pingfang=\"\" helvetica=\"\" hiragino=\"\" sans=\"\" source=\"\" han=\"\" noto=\"\" cjk=\"\" microsoft=\"\" white-space:=\"\" background-color:=\"\"><\/span><br/><\/p>","content2":"","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":0,"delivery_type":20,"is_new_user_enjoy":0,"is_points_gift":1,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"10020":"","10021":"","10022":"","10023":"","10024":""},"is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","is_new_user":0,"new_need_points_num":0,"new_need_points_money":"0.00","video":null,"goods_status":{"text":"上架","value":10},"is_hot":1,"use_code":0,"is_check":1,"share_buy":0,"share_num":0,"view_num":155,"is_baopin":0,"is_ziyin":0,"is_pinpai":0,"brand_id":0,"comment_data_count":0,"goods_stock":6,"goods_image":"http://dijiush.oss-cn-beijing.aliyuncs.com/202009151725453455d7261.jpg","goods_sku":{"goods_sku_id":29175,"goods_id":12014,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.01","line_price":"0.00","real_price":"0.00","stock_num":6,"goods_sales":0,"goods_weight":0,"image":null},"goods_multi_spec":null,"is_user_grade":false,"bought_num":0,"is_like":0,"video_url":"","category":{"category_id":10541,"name":"扶商咨询","parent_id":0,"image_id":0,"sort":100,"type":3,"create_time":"2020-09-15 17:25:16"},"image":[{"id":31258,"goods_id":12014,"image_id":24584,"file_path":"http://dijiush.oss-cn-beijing.aliyuncs.com/202009151725453455d7261.jpg","file_name":"202009151725453455d7261.jpg","file_url":"http://dijiush.oss-cn-beijing.aliyuncs.com"}],"sku":[{"goods_sku_id":29175,"goods_id":12014,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.01","line_price":"0.00","real_price":"0.00","stock_num":6,"goods_sales":0,"goods_weight":0,"image":null}],"comment_data":[],"goods_sales":3}
         * specData : null
         * videoList : [{"study_id":1,"goods_id":12014,"title":"测试1","video_id":25820,"sort":10,"free":0,"create_time":1600674149,"update_time":1600675906,"wxapp_id":10001,"is_delete":0,"video_url":"http://dijiush.oss-cn-beijing.aliyuncs.com/20200921154225ffd781956.mp4"},{"study_id":2,"goods_id":12014,"title":"测试222","video_id":32974,"sort":100,"free":1,"create_time":1603676280,"update_time":1603676280,"wxapp_id":10001,"is_delete":0,"video_url":"http://dijiush.oss-cn-beijing.aliyuncs.com/20201026093753c35035864.mp4"}]
         */

        private DetailBean detail;
        private Object specData;
        private List<VideoListBean> videoList;

        public DetailBean getDetail() {
            return detail;
        }

        public void setDetail(DetailBean detail) {
            this.detail = detail;
        }

        public Object getSpecData() {
            return specData;
        }

        public void setSpecData(Object specData) {
            this.specData = specData;
        }

        public List<VideoListBean> getVideoList() {
            return videoList;
        }

        public void setVideoList(List<VideoListBean> videoList) {
            this.videoList = videoList;
        }

        public static class DetailBean {
            /**
             * goods_id : 12014
             * shop_id : 10020
             * supplier_id : 0
             * type : 3
             * goods_name : 测试课程
             * selling_point : 测试课程测试课程测试课程测试课程
             * use_rule : null
             * category_id : 10541
             * spec_type : 10
             * deduct_stock_type : 10
             * content : <p><img src="http://dijiush.oss-cn-beijing.aliyuncs.com/20201022165000794ee0767.png"/></p><p><span style="color: rgb(14, 23, 38); font-family: " pingfang="" helvetica="" hiragino="" sans="" source="" han="" noto="" cjk="" microsoft="" white-space:="" background-color:=""></span><br/></p>
             * content2 :
             * goods_sort : 100
             * buy_limit : 0
             * least_expend_money : 0.00
             * delivery_id : 0
             * delivery_type : 20
             * is_new_user_enjoy : 0
             * is_points_gift : 1
             * is_points_discount : 1
             * is_enable_balance_price : 0
             * is_enable_grade : 1
             * is_alone_grade : 0
             * alone_grade_equity : {"10020":"","10021":"","10022":"","10023":"","10024":""}
             * is_ind_dealer : 0
             * dealer_money_type : 10
             * first_money : 0.00
             * second_money : 0.00
             * third_money : 0.00
             * is_rush : 0
             * is_points_exchange : 0
             * need_points_num : 0
             * need_points_money : 0.00
             * is_new_user : 0
             * new_need_points_num : 0
             * new_need_points_money : 0.00
             * video : null
             * goods_status : {"text":"上架","value":10}
             * is_hot : 1
             * use_code : 0
             * is_check : 1
             * share_buy : 0
             * share_num : 0
             * view_num : 155
             * is_baopin : 0
             * is_ziyin : 0
             * is_pinpai : 0
             * brand_id : 0
             * comment_data_count : 0
             * goods_stock : 6
             * goods_image : http://dijiush.oss-cn-beijing.aliyuncs.com/202009151725453455d7261.jpg
             * goods_sku : {"goods_sku_id":29175,"goods_id":12014,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.01","line_price":"0.00","real_price":"0.00","stock_num":6,"goods_sales":0,"goods_weight":0,"image":null}
             * goods_multi_spec : null
             * is_user_grade : false
             * bought_num : 0
             * is_like : 0
             * video_url :
             * category : {"category_id":10541,"name":"扶商咨询","parent_id":0,"image_id":0,"sort":100,"type":3,"create_time":"2020-09-15 17:25:16"}
             * image : [{"id":31258,"goods_id":12014,"image_id":24584,"file_path":"http://dijiush.oss-cn-beijing.aliyuncs.com/202009151725453455d7261.jpg","file_name":"202009151725453455d7261.jpg","file_url":"http://dijiush.oss-cn-beijing.aliyuncs.com"}]
             * sku : [{"goods_sku_id":29175,"goods_id":12014,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.01","line_price":"0.00","real_price":"0.00","stock_num":6,"goods_sales":0,"goods_weight":0,"image":null}]
             * comment_data : []
             * goods_sales : 3
             */

            private int goods_id;
            private int shop_id;
            private int supplier_id;
            private int type;
            private String goods_name;
            private String selling_point;
            private Object use_rule;
            private int category_id;
            private int spec_type;
            private int deduct_stock_type;
            private String content;
            private String content2;
            private int goods_sort;
            private int buy_limit;
            private String least_expend_money;
            private int delivery_id;
            private int delivery_type;
            private int is_new_user_enjoy;
            private int is_points_gift;
            private int is_points_discount;
            private int is_enable_balance_price;
            private int is_enable_grade;
            private int is_alone_grade;
            private AloneGradeEquityBean alone_grade_equity;
            private int is_ind_dealer;
            private int dealer_money_type;
            private String first_money;
            private String second_money;
            private String third_money;
            private int is_rush;
            private int is_points_exchange;
            private int need_points_num;
            private String need_points_money;
            private int is_new_user;
            private int new_need_points_num;
            private String new_need_points_money;
            private Object video;
            private GoodsStatusBean goods_status;
            private int is_hot;
            private int use_code;
            private int is_check;
            private int share_buy;
            private int share_num;
            private int view_num;
            private int is_baopin;
            private int is_ziyin;
            private int is_pinpai;
            private int brand_id;
            private int comment_data_count;
            private int goods_stock;
            private String goods_image;
            private GoodsSkuBean goods_sku;
            private Object goods_multi_spec;
            private boolean is_user_grade;
            private int bought_num;
            private int is_like;
            private String video_url;
            private CategoryBean category;
            private int goods_sales;
            private List<ImageBean> image;
            private List<SkuBean> sku;
            private List<?> comment_data;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public int getShop_id() {
                return shop_id;
            }

            public void setShop_id(int shop_id) {
                this.shop_id = shop_id;
            }

            public int getSupplier_id() {
                return supplier_id;
            }

            public void setSupplier_id(int supplier_id) {
                this.supplier_id = supplier_id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getSelling_point() {
                return selling_point;
            }

            public void setSelling_point(String selling_point) {
                this.selling_point = selling_point;
            }

            public Object getUse_rule() {
                return use_rule;
            }

            public void setUse_rule(Object use_rule) {
                this.use_rule = use_rule;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public int getSpec_type() {
                return spec_type;
            }

            public void setSpec_type(int spec_type) {
                this.spec_type = spec_type;
            }

            public int getDeduct_stock_type() {
                return deduct_stock_type;
            }

            public void setDeduct_stock_type(int deduct_stock_type) {
                this.deduct_stock_type = deduct_stock_type;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getContent2() {
                return content2;
            }

            public void setContent2(String content2) {
                this.content2 = content2;
            }

            public int getGoods_sort() {
                return goods_sort;
            }

            public void setGoods_sort(int goods_sort) {
                this.goods_sort = goods_sort;
            }

            public int getBuy_limit() {
                return buy_limit;
            }

            public void setBuy_limit(int buy_limit) {
                this.buy_limit = buy_limit;
            }

            public String getLeast_expend_money() {
                return least_expend_money;
            }

            public void setLeast_expend_money(String least_expend_money) {
                this.least_expend_money = least_expend_money;
            }

            public int getDelivery_id() {
                return delivery_id;
            }

            public void setDelivery_id(int delivery_id) {
                this.delivery_id = delivery_id;
            }

            public int getDelivery_type() {
                return delivery_type;
            }

            public void setDelivery_type(int delivery_type) {
                this.delivery_type = delivery_type;
            }

            public int getIs_new_user_enjoy() {
                return is_new_user_enjoy;
            }

            public void setIs_new_user_enjoy(int is_new_user_enjoy) {
                this.is_new_user_enjoy = is_new_user_enjoy;
            }

            public int getIs_points_gift() {
                return is_points_gift;
            }

            public void setIs_points_gift(int is_points_gift) {
                this.is_points_gift = is_points_gift;
            }

            public int getIs_points_discount() {
                return is_points_discount;
            }

            public void setIs_points_discount(int is_points_discount) {
                this.is_points_discount = is_points_discount;
            }

            public int getIs_enable_balance_price() {
                return is_enable_balance_price;
            }

            public void setIs_enable_balance_price(int is_enable_balance_price) {
                this.is_enable_balance_price = is_enable_balance_price;
            }

            public int getIs_enable_grade() {
                return is_enable_grade;
            }

            public void setIs_enable_grade(int is_enable_grade) {
                this.is_enable_grade = is_enable_grade;
            }

            public int getIs_alone_grade() {
                return is_alone_grade;
            }

            public void setIs_alone_grade(int is_alone_grade) {
                this.is_alone_grade = is_alone_grade;
            }

            public AloneGradeEquityBean getAlone_grade_equity() {
                return alone_grade_equity;
            }

            public void setAlone_grade_equity(AloneGradeEquityBean alone_grade_equity) {
                this.alone_grade_equity = alone_grade_equity;
            }

            public int getIs_ind_dealer() {
                return is_ind_dealer;
            }

            public void setIs_ind_dealer(int is_ind_dealer) {
                this.is_ind_dealer = is_ind_dealer;
            }

            public int getDealer_money_type() {
                return dealer_money_type;
            }

            public void setDealer_money_type(int dealer_money_type) {
                this.dealer_money_type = dealer_money_type;
            }

            public String getFirst_money() {
                return first_money;
            }

            public void setFirst_money(String first_money) {
                this.first_money = first_money;
            }

            public String getSecond_money() {
                return second_money;
            }

            public void setSecond_money(String second_money) {
                this.second_money = second_money;
            }

            public String getThird_money() {
                return third_money;
            }

            public void setThird_money(String third_money) {
                this.third_money = third_money;
            }

            public int getIs_rush() {
                return is_rush;
            }

            public void setIs_rush(int is_rush) {
                this.is_rush = is_rush;
            }

            public int getIs_points_exchange() {
                return is_points_exchange;
            }

            public void setIs_points_exchange(int is_points_exchange) {
                this.is_points_exchange = is_points_exchange;
            }

            public int getNeed_points_num() {
                return need_points_num;
            }

            public void setNeed_points_num(int need_points_num) {
                this.need_points_num = need_points_num;
            }

            public String getNeed_points_money() {
                return need_points_money;
            }

            public void setNeed_points_money(String need_points_money) {
                this.need_points_money = need_points_money;
            }

            public int getIs_new_user() {
                return is_new_user;
            }

            public void setIs_new_user(int is_new_user) {
                this.is_new_user = is_new_user;
            }

            public int getNew_need_points_num() {
                return new_need_points_num;
            }

            public void setNew_need_points_num(int new_need_points_num) {
                this.new_need_points_num = new_need_points_num;
            }

            public String getNew_need_points_money() {
                return new_need_points_money;
            }

            public void setNew_need_points_money(String new_need_points_money) {
                this.new_need_points_money = new_need_points_money;
            }

            public Object getVideo() {
                return video;
            }

            public void setVideo(Object video) {
                this.video = video;
            }

            public GoodsStatusBean getGoods_status() {
                return goods_status;
            }

            public void setGoods_status(GoodsStatusBean goods_status) {
                this.goods_status = goods_status;
            }

            public int getIs_hot() {
                return is_hot;
            }

            public void setIs_hot(int is_hot) {
                this.is_hot = is_hot;
            }

            public int getUse_code() {
                return use_code;
            }

            public void setUse_code(int use_code) {
                this.use_code = use_code;
            }

            public int getIs_check() {
                return is_check;
            }

            public void setIs_check(int is_check) {
                this.is_check = is_check;
            }

            public int getShare_buy() {
                return share_buy;
            }

            public void setShare_buy(int share_buy) {
                this.share_buy = share_buy;
            }

            public int getShare_num() {
                return share_num;
            }

            public void setShare_num(int share_num) {
                this.share_num = share_num;
            }

            public int getView_num() {
                return view_num;
            }

            public void setView_num(int view_num) {
                this.view_num = view_num;
            }

            public int getIs_baopin() {
                return is_baopin;
            }

            public void setIs_baopin(int is_baopin) {
                this.is_baopin = is_baopin;
            }

            public int getIs_ziyin() {
                return is_ziyin;
            }

            public void setIs_ziyin(int is_ziyin) {
                this.is_ziyin = is_ziyin;
            }

            public int getIs_pinpai() {
                return is_pinpai;
            }

            public void setIs_pinpai(int is_pinpai) {
                this.is_pinpai = is_pinpai;
            }

            public int getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(int brand_id) {
                this.brand_id = brand_id;
            }

            public int getComment_data_count() {
                return comment_data_count;
            }

            public void setComment_data_count(int comment_data_count) {
                this.comment_data_count = comment_data_count;
            }

            public int getGoods_stock() {
                return goods_stock;
            }

            public void setGoods_stock(int goods_stock) {
                this.goods_stock = goods_stock;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public GoodsSkuBean getGoods_sku() {
                return goods_sku;
            }

            public void setGoods_sku(GoodsSkuBean goods_sku) {
                this.goods_sku = goods_sku;
            }

            public Object getGoods_multi_spec() {
                return goods_multi_spec;
            }

            public void setGoods_multi_spec(Object goods_multi_spec) {
                this.goods_multi_spec = goods_multi_spec;
            }

            public boolean isIs_user_grade() {
                return is_user_grade;
            }

            public void setIs_user_grade(boolean is_user_grade) {
                this.is_user_grade = is_user_grade;
            }

            public int getBought_num() {
                return bought_num;
            }

            public void setBought_num(int bought_num) {
                this.bought_num = bought_num;
            }

            public int getIs_like() {
                return is_like;
            }

            public void setIs_like(int is_like) {
                this.is_like = is_like;
            }

            public String getVideo_url() {
                return video_url;
            }

            public void setVideo_url(String video_url) {
                this.video_url = video_url;
            }

            public CategoryBean getCategory() {
                return category;
            }

            public void setCategory(CategoryBean category) {
                this.category = category;
            }

            public int getGoods_sales() {
                return goods_sales;
            }

            public void setGoods_sales(int goods_sales) {
                this.goods_sales = goods_sales;
            }

            public List<ImageBean> getImage() {
                return image;
            }

            public void setImage(List<ImageBean> image) {
                this.image = image;
            }

            public List<SkuBean> getSku() {
                return sku;
            }

            public void setSku(List<SkuBean> sku) {
                this.sku = sku;
            }

            public List<?> getComment_data() {
                return comment_data;
            }

            public void setComment_data(List<?> comment_data) {
                this.comment_data = comment_data;
            }

            public static class AloneGradeEquityBean {
                /**
                 * 10020 :
                 * 10021 :
                 * 10022 :
                 * 10023 :
                 * 10024 :
                 */

                @SerializedName("10020")
                private String _$10020;
                @SerializedName("10021")
                private String _$10021;
                @SerializedName("10022")
                private String _$10022;
                @SerializedName("10023")
                private String _$10023;
                @SerializedName("10024")
                private String _$10024;

                public String get_$10020() {
                    return _$10020;
                }

                public void set_$10020(String _$10020) {
                    this._$10020 = _$10020;
                }

                public String get_$10021() {
                    return _$10021;
                }

                public void set_$10021(String _$10021) {
                    this._$10021 = _$10021;
                }

                public String get_$10022() {
                    return _$10022;
                }

                public void set_$10022(String _$10022) {
                    this._$10022 = _$10022;
                }

                public String get_$10023() {
                    return _$10023;
                }

                public void set_$10023(String _$10023) {
                    this._$10023 = _$10023;
                }

                public String get_$10024() {
                    return _$10024;
                }

                public void set_$10024(String _$10024) {
                    this._$10024 = _$10024;
                }
            }

            public static class GoodsStatusBean {
                /**
                 * text : 上架
                 * value : 10
                 */

                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class GoodsSkuBean {
                /**
                 * goods_sku_id : 29175
                 * goods_id : 12014
                 * spec_sku_id : 0
                 * image_id : 0
                 * goods_no :
                 * balance_price : 0.00
                 * goods_price : 0.01
                 * line_price : 0.00
                 * real_price : 0.00
                 * stock_num : 6
                 * goods_sales : 0
                 * goods_weight : 0
                 * image : null
                 */

                private int goods_sku_id;
                private int goods_id;
                private String spec_sku_id;
                private int image_id;
                private String goods_no;
                private String balance_price;
                private String goods_price;
                private String line_price;
                private String real_price;
                private int stock_num;
                private int goods_sales;
                private int goods_weight;
                private Object image;

                public int getGoods_sku_id() {
                    return goods_sku_id;
                }

                public void setGoods_sku_id(int goods_sku_id) {
                    this.goods_sku_id = goods_sku_id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getSpec_sku_id() {
                    return spec_sku_id;
                }

                public void setSpec_sku_id(String spec_sku_id) {
                    this.spec_sku_id = spec_sku_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public String getGoods_no() {
                    return goods_no;
                }

                public void setGoods_no(String goods_no) {
                    this.goods_no = goods_no;
                }

                public String getBalance_price() {
                    return balance_price;
                }

                public void setBalance_price(String balance_price) {
                    this.balance_price = balance_price;
                }

                public String getGoods_price() {
                    return goods_price;
                }

                public void setGoods_price(String goods_price) {
                    this.goods_price = goods_price;
                }

                public String getLine_price() {
                    return line_price;
                }

                public void setLine_price(String line_price) {
                    this.line_price = line_price;
                }

                public String getReal_price() {
                    return real_price;
                }

                public void setReal_price(String real_price) {
                    this.real_price = real_price;
                }

                public int getStock_num() {
                    return stock_num;
                }

                public void setStock_num(int stock_num) {
                    this.stock_num = stock_num;
                }

                public int getGoods_sales() {
                    return goods_sales;
                }

                public void setGoods_sales(int goods_sales) {
                    this.goods_sales = goods_sales;
                }

                public int getGoods_weight() {
                    return goods_weight;
                }

                public void setGoods_weight(int goods_weight) {
                    this.goods_weight = goods_weight;
                }

                public Object getImage() {
                    return image;
                }

                public void setImage(Object image) {
                    this.image = image;
                }
            }

            public static class CategoryBean {
                /**
                 * category_id : 10541
                 * name : 扶商咨询
                 * parent_id : 0
                 * image_id : 0
                 * sort : 100
                 * type : 3
                 * create_time : 2020-09-15 17:25:16
                 */

                private int category_id;
                private String name;
                private int parent_id;
                private int image_id;
                private int sort;
                private int type;
                private String create_time;

                public int getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(int category_id) {
                    this.category_id = category_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getParent_id() {
                    return parent_id;
                }

                public void setParent_id(int parent_id) {
                    this.parent_id = parent_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }
            }

            public static class ImageBean {
                /**
                 * id : 31258
                 * goods_id : 12014
                 * image_id : 24584
                 * file_path : http://dijiush.oss-cn-beijing.aliyuncs.com/202009151725453455d7261.jpg
                 * file_name : 202009151725453455d7261.jpg
                 * file_url : http://dijiush.oss-cn-beijing.aliyuncs.com
                 */

                private int id;
                private int goods_id;
                private int image_id;
                private String file_path;
                private String file_name;
                private String file_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public String getFile_path() {
                    return file_path;
                }

                public void setFile_path(String file_path) {
                    this.file_path = file_path;
                }

                public String getFile_name() {
                    return file_name;
                }

                public void setFile_name(String file_name) {
                    this.file_name = file_name;
                }

                public String getFile_url() {
                    return file_url;
                }

                public void setFile_url(String file_url) {
                    this.file_url = file_url;
                }
            }

            public static class SkuBean {
                /**
                 * goods_sku_id : 29175
                 * goods_id : 12014
                 * spec_sku_id : 0
                 * image_id : 0
                 * goods_no :
                 * balance_price : 0.00
                 * goods_price : 0.01
                 * line_price : 0.00
                 * real_price : 0.00
                 * stock_num : 6
                 * goods_sales : 0
                 * goods_weight : 0
                 * image : null
                 */

                private int goods_sku_id;
                private int goods_id;
                private String spec_sku_id;
                private int image_id;
                private String goods_no;
                private String balance_price;
                private String goods_price;
                private String line_price;
                private String real_price;
                private int stock_num;
                private int goods_sales;
                private int goods_weight;
                private Object image;

                public int getGoods_sku_id() {
                    return goods_sku_id;
                }

                public void setGoods_sku_id(int goods_sku_id) {
                    this.goods_sku_id = goods_sku_id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getSpec_sku_id() {
                    return spec_sku_id;
                }

                public void setSpec_sku_id(String spec_sku_id) {
                    this.spec_sku_id = spec_sku_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public String getGoods_no() {
                    return goods_no;
                }

                public void setGoods_no(String goods_no) {
                    this.goods_no = goods_no;
                }

                public String getBalance_price() {
                    return balance_price;
                }

                public void setBalance_price(String balance_price) {
                    this.balance_price = balance_price;
                }

                public String getGoods_price() {
                    return goods_price;
                }

                public void setGoods_price(String goods_price) {
                    this.goods_price = goods_price;
                }

                public String getLine_price() {
                    return line_price;
                }

                public void setLine_price(String line_price) {
                    this.line_price = line_price;
                }

                public String getReal_price() {
                    return real_price;
                }

                public void setReal_price(String real_price) {
                    this.real_price = real_price;
                }

                public int getStock_num() {
                    return stock_num;
                }

                public void setStock_num(int stock_num) {
                    this.stock_num = stock_num;
                }

                public int getGoods_sales() {
                    return goods_sales;
                }

                public void setGoods_sales(int goods_sales) {
                    this.goods_sales = goods_sales;
                }

                public int getGoods_weight() {
                    return goods_weight;
                }

                public void setGoods_weight(int goods_weight) {
                    this.goods_weight = goods_weight;
                }

                public Object getImage() {
                    return image;
                }

                public void setImage(Object image) {
                    this.image = image;
                }
            }
        }

        public static class VideoListBean {
            /**
             * study_id : 1
             * goods_id : 12014
             * title : 测试1
             * video_id : 25820
             * sort : 10
             * free : 0
             * create_time : 1600674149
             * update_time : 1600675906
             * wxapp_id : 10001
             * is_delete : 0
             * video_url : http://dijiush.oss-cn-beijing.aliyuncs.com/20200921154225ffd781956.mp4
             */

            private int study_id;
            private int goods_id;
            private String title;
            private int video_id;
            private int sort;
            private int free;
            private int create_time;
            private int update_time;
            private int wxapp_id;
            private int is_delete;
            private String video_url;

            public int getStudy_id() {
                return study_id;
            }

            public void setStudy_id(int study_id) {
                this.study_id = study_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getVideo_id() {
                return video_id;
            }

            public void setVideo_id(int video_id) {
                this.video_id = video_id;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getFree() {
                return free;
            }

            public void setFree(int free) {
                this.free = free;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public int getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(int update_time) {
                this.update_time = update_time;
            }

            public int getWxapp_id() {
                return wxapp_id;
            }

            public void setWxapp_id(int wxapp_id) {
                this.wxapp_id = wxapp_id;
            }

            public int getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(int is_delete) {
                this.is_delete = is_delete;
            }

            public String getVideo_url() {
                return video_url;
            }

            public void setVideo_url(String video_url) {
                this.video_url = video_url;
            }
        }
    }
}
