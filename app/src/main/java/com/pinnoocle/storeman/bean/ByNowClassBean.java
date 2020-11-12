package com.pinnoocle.storeman.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ByNowClassBean {

    /**
     * data : {"orderInfo":{"type":3,"goods_list":[{"goods_id":12014,"shop_id":10020,"supplier_id":0,"type":3,"goods_name":"测试课程","selling_point":"测试课程测试课程测试课程测试课程","use_rule":null,"category_id":10541,"spec_type":10,"deduct_stock_type":10,"content2":"","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":0,"delivery_type":20,"is_new_user_enjoy":0,"is_points_gift":1,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"10024":"","10023":"","10022":"","10020":"","10021":""},"is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","is_new_user":0,"new_need_points_num":0,"new_need_points_money":"0.00","video":null,"goods_status":{"text":"上架","value":10},"is_hot":1,"use_code":0,"is_check":1,"share_buy":0,"share_num":0,"view_num":239,"is_baopin":0,"is_ziyin":0,"is_pinpai":0,"brand_id":0,"goods_stock":100,"goods_image":"http://dijiush.oss-cn-beijing.aliyuncs.com/202009151725453455d7261.jpg","goods_sku":{"goods_sku_id":30589,"goods_id":12014,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.01","line_price":"0.00","real_price":"0.00","stock_num":100,"goods_sales":0,"goods_weight":0,"goods_attr":"","image":null},"goods_multi_spec":null,"goods_price":"0.01","total_num":"1","total_price":"0.01","total_need_points_num":"0","total_need_points_money":"0.00","is_user_grade":false,"grade_ratio":0,"grade_goods_price":0,"grade_total_money":0,"points_money":0,"points_num":"0","coupon_money":0,"virtual_code_money":0,"total_pay_price":"0.01","express_price":"0.00","points_bonus":"0","goods_sales":3}],"order_total_num":1,"coupon_list":[],"has_error":false,"error_msg":null,"delivery":"10","address":{"address_id":12159,"name":"测试","phone":"18312341234","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"测试","longitude":"","latitude":"","user_id":14784,"region":{"province":"北京市","city":"北京市","region":"东城区"}},"exist_address":true,"express_price":"0.00","intra_region":true,"extract_shop":[],"is_allow_points":false,"is_use_points":0,"points_money":0,"points_bonus":0,"pay_type":20,"setting":{"delivery":["10","20"],"points_name":"红包值","points_describe":"a) 积分不可兑现、不可转让,仅可在本平台使用;\nb) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;\nc) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)\nd) 买家在完成该笔交易(订单状态为\u201c已签收\u201d)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;","tplSetting":{"payment":{"is_enable":"0","template_id":"","template_params":""},"delivery":{"is_enable":"0","template_id":"","template_params":""},"refund":{"is_enable":"0","template_id":"","template_params":""}}},"last_extract":{"linkman":"","phone":"17356921108"},"deliverySetting":["10","20"],"send_payment_msg":0,"send_delivery_msg":0,"send_refund_msg":0,"order_total_price":"0.01","coupon_id":0,"coupon_money":0,"virtual_code":"","virtual_code_money":0,"order_price":"0.01","order_pay_price":"0.01","userInfo":{"nickName":"","phone":"17356921108"},"shop_name":"第玖生活自营商家"}}
     * code : 0
     * msg : null
     */

    private DataBean data;
    private int code;
    private Object msg;

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

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * orderInfo : {"type":3,"goods_list":[{"goods_id":12014,"shop_id":10020,"supplier_id":0,"type":3,"goods_name":"测试课程","selling_point":"测试课程测试课程测试课程测试课程","use_rule":null,"category_id":10541,"spec_type":10,"deduct_stock_type":10,"content2":"","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":0,"delivery_type":20,"is_new_user_enjoy":0,"is_points_gift":1,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"10024":"","10023":"","10022":"","10020":"","10021":""},"is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","is_new_user":0,"new_need_points_num":0,"new_need_points_money":"0.00","video":null,"goods_status":{"text":"上架","value":10},"is_hot":1,"use_code":0,"is_check":1,"share_buy":0,"share_num":0,"view_num":239,"is_baopin":0,"is_ziyin":0,"is_pinpai":0,"brand_id":0,"goods_stock":100,"goods_image":"http://dijiush.oss-cn-beijing.aliyuncs.com/202009151725453455d7261.jpg","goods_sku":{"goods_sku_id":30589,"goods_id":12014,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.01","line_price":"0.00","real_price":"0.00","stock_num":100,"goods_sales":0,"goods_weight":0,"goods_attr":"","image":null},"goods_multi_spec":null,"goods_price":"0.01","total_num":"1","total_price":"0.01","total_need_points_num":"0","total_need_points_money":"0.00","is_user_grade":false,"grade_ratio":0,"grade_goods_price":0,"grade_total_money":0,"points_money":0,"points_num":"0","coupon_money":0,"virtual_code_money":0,"total_pay_price":"0.01","express_price":"0.00","points_bonus":"0","goods_sales":3}],"order_total_num":1,"coupon_list":[],"has_error":false,"error_msg":null,"delivery":"10","address":{"address_id":12159,"name":"测试","phone":"18312341234","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"测试","longitude":"","latitude":"","user_id":14784,"region":{"province":"北京市","city":"北京市","region":"东城区"}},"exist_address":true,"express_price":"0.00","intra_region":true,"extract_shop":[],"is_allow_points":false,"is_use_points":0,"points_money":0,"points_bonus":0,"pay_type":20,"setting":{"delivery":["10","20"],"points_name":"红包值","points_describe":"a) 积分不可兑现、不可转让,仅可在本平台使用;\nb) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;\nc) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)\nd) 买家在完成该笔交易(订单状态为\u201c已签收\u201d)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;","tplSetting":{"payment":{"is_enable":"0","template_id":"","template_params":""},"delivery":{"is_enable":"0","template_id":"","template_params":""},"refund":{"is_enable":"0","template_id":"","template_params":""}}},"last_extract":{"linkman":"","phone":"17356921108"},"deliverySetting":["10","20"],"send_payment_msg":0,"send_delivery_msg":0,"send_refund_msg":0,"order_total_price":"0.01","coupon_id":0,"coupon_money":0,"virtual_code":"","virtual_code_money":0,"order_price":"0.01","order_pay_price":"0.01","userInfo":{"nickName":"","phone":"17356921108"},"shop_name":"第玖生活自营商家"}
         */

        private OrderInfoBean orderInfo;

        public OrderInfoBean getOrderInfo() {
            return orderInfo;
        }

        public void setOrderInfo(OrderInfoBean orderInfo) {
            this.orderInfo = orderInfo;
        }

        public static class OrderInfoBean {
            /**
             * type : 3
             * goods_list : [{"goods_id":12014,"shop_id":10020,"supplier_id":0,"type":3,"goods_name":"测试课程","selling_point":"测试课程测试课程测试课程测试课程","use_rule":null,"category_id":10541,"spec_type":10,"deduct_stock_type":10,"content2":"","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":0,"delivery_type":20,"is_new_user_enjoy":0,"is_points_gift":1,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"10024":"","10023":"","10022":"","10020":"","10021":""},"is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","is_new_user":0,"new_need_points_num":0,"new_need_points_money":"0.00","video":null,"goods_status":{"text":"上架","value":10},"is_hot":1,"use_code":0,"is_check":1,"share_buy":0,"share_num":0,"view_num":239,"is_baopin":0,"is_ziyin":0,"is_pinpai":0,"brand_id":0,"goods_stock":100,"goods_image":"http://dijiush.oss-cn-beijing.aliyuncs.com/202009151725453455d7261.jpg","goods_sku":{"goods_sku_id":30589,"goods_id":12014,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.01","line_price":"0.00","real_price":"0.00","stock_num":100,"goods_sales":0,"goods_weight":0,"goods_attr":"","image":null},"goods_multi_spec":null,"goods_price":"0.01","total_num":"1","total_price":"0.01","total_need_points_num":"0","total_need_points_money":"0.00","is_user_grade":false,"grade_ratio":0,"grade_goods_price":0,"grade_total_money":0,"points_money":0,"points_num":"0","coupon_money":0,"virtual_code_money":0,"total_pay_price":"0.01","express_price":"0.00","points_bonus":"0","goods_sales":3}]
             * order_total_num : 1
             * coupon_list : []
             * has_error : false
             * error_msg : null
             * delivery : 10
             * address : {"address_id":12159,"name":"测试","phone":"18312341234","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"测试","longitude":"","latitude":"","user_id":14784,"region":{"province":"北京市","city":"北京市","region":"东城区"}}
             * exist_address : true
             * express_price : 0.00
             * intra_region : true
             * extract_shop : []
             * is_allow_points : false
             * is_use_points : 0
             * points_money : 0
             * points_bonus : 0
             * pay_type : 20
             * setting : {"delivery":["10","20"],"points_name":"红包值","points_describe":"a) 积分不可兑现、不可转让,仅可在本平台使用;\nb) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;\nc) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)\nd) 买家在完成该笔交易(订单状态为\u201c已签收\u201d)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;","tplSetting":{"payment":{"is_enable":"0","template_id":"","template_params":""},"delivery":{"is_enable":"0","template_id":"","template_params":""},"refund":{"is_enable":"0","template_id":"","template_params":""}}}
             * last_extract : {"linkman":"","phone":"17356921108"}
             * deliverySetting : ["10","20"]
             * send_payment_msg : 0
             * send_delivery_msg : 0
             * send_refund_msg : 0
             * order_total_price : 0.01
             * coupon_id : 0
             * coupon_money : 0
             * virtual_code :
             * virtual_code_money : 0
             * order_price : 0.01
             * order_pay_price : 0.01
             * userInfo : {"nickName":"","phone":"17356921108"}
             * shop_name : 第玖生活自营商家
             */

            private int type;
            private int order_total_num;
            private boolean has_error;
            private Object error_msg;
            private String delivery;
            private AddressBean address;
            private boolean exist_address;
            private String express_price;
            private boolean intra_region;
            private boolean is_allow_points;
            private int is_use_points;
            private int points_money;
            private int points_bonus;
            private int pay_type;
            private SettingBean setting;
            private LastExtractBean last_extract;
            private int send_payment_msg;
            private int send_delivery_msg;
            private int send_refund_msg;
            private String order_total_price;
            private int coupon_id;
            private int coupon_money;
            private String virtual_code;
            private int virtual_code_money;
            private String order_price;
            private String order_pay_price;
            private UserInfoBean userInfo;
            private String shop_name;
            private List<GoodsListBean> goods_list;
            private List<?> coupon_list;
            private List<?> extract_shop;
            private List<String> deliverySetting;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getOrder_total_num() {
                return order_total_num;
            }

            public void setOrder_total_num(int order_total_num) {
                this.order_total_num = order_total_num;
            }

            public boolean isHas_error() {
                return has_error;
            }

            public void setHas_error(boolean has_error) {
                this.has_error = has_error;
            }

            public Object getError_msg() {
                return error_msg;
            }

            public void setError_msg(Object error_msg) {
                this.error_msg = error_msg;
            }

            public String getDelivery() {
                return delivery;
            }

            public void setDelivery(String delivery) {
                this.delivery = delivery;
            }

            public AddressBean getAddress() {
                return address;
            }

            public void setAddress(AddressBean address) {
                this.address = address;
            }

            public boolean isExist_address() {
                return exist_address;
            }

            public void setExist_address(boolean exist_address) {
                this.exist_address = exist_address;
            }

            public String getExpress_price() {
                return express_price;
            }

            public void setExpress_price(String express_price) {
                this.express_price = express_price;
            }

            public boolean isIntra_region() {
                return intra_region;
            }

            public void setIntra_region(boolean intra_region) {
                this.intra_region = intra_region;
            }

            public boolean isIs_allow_points() {
                return is_allow_points;
            }

            public void setIs_allow_points(boolean is_allow_points) {
                this.is_allow_points = is_allow_points;
            }

            public int getIs_use_points() {
                return is_use_points;
            }

            public void setIs_use_points(int is_use_points) {
                this.is_use_points = is_use_points;
            }

            public int getPoints_money() {
                return points_money;
            }

            public void setPoints_money(int points_money) {
                this.points_money = points_money;
            }

            public int getPoints_bonus() {
                return points_bonus;
            }

            public void setPoints_bonus(int points_bonus) {
                this.points_bonus = points_bonus;
            }

            public int getPay_type() {
                return pay_type;
            }

            public void setPay_type(int pay_type) {
                this.pay_type = pay_type;
            }

            public SettingBean getSetting() {
                return setting;
            }

            public void setSetting(SettingBean setting) {
                this.setting = setting;
            }

            public LastExtractBean getLast_extract() {
                return last_extract;
            }

            public void setLast_extract(LastExtractBean last_extract) {
                this.last_extract = last_extract;
            }

            public int getSend_payment_msg() {
                return send_payment_msg;
            }

            public void setSend_payment_msg(int send_payment_msg) {
                this.send_payment_msg = send_payment_msg;
            }

            public int getSend_delivery_msg() {
                return send_delivery_msg;
            }

            public void setSend_delivery_msg(int send_delivery_msg) {
                this.send_delivery_msg = send_delivery_msg;
            }

            public int getSend_refund_msg() {
                return send_refund_msg;
            }

            public void setSend_refund_msg(int send_refund_msg) {
                this.send_refund_msg = send_refund_msg;
            }

            public String getOrder_total_price() {
                return order_total_price;
            }

            public void setOrder_total_price(String order_total_price) {
                this.order_total_price = order_total_price;
            }

            public int getCoupon_id() {
                return coupon_id;
            }

            public void setCoupon_id(int coupon_id) {
                this.coupon_id = coupon_id;
            }

            public int getCoupon_money() {
                return coupon_money;
            }

            public void setCoupon_money(int coupon_money) {
                this.coupon_money = coupon_money;
            }

            public String getVirtual_code() {
                return virtual_code;
            }

            public void setVirtual_code(String virtual_code) {
                this.virtual_code = virtual_code;
            }

            public int getVirtual_code_money() {
                return virtual_code_money;
            }

            public void setVirtual_code_money(int virtual_code_money) {
                this.virtual_code_money = virtual_code_money;
            }

            public String getOrder_price() {
                return order_price;
            }

            public void setOrder_price(String order_price) {
                this.order_price = order_price;
            }

            public String getOrder_pay_price() {
                return order_pay_price;
            }

            public void setOrder_pay_price(String order_pay_price) {
                this.order_pay_price = order_pay_price;
            }

            public UserInfoBean getUserInfo() {
                return userInfo;
            }

            public void setUserInfo(UserInfoBean userInfo) {
                this.userInfo = userInfo;
            }

            public String getShop_name() {
                return shop_name;
            }

            public void setShop_name(String shop_name) {
                this.shop_name = shop_name;
            }

            public List<GoodsListBean> getGoods_list() {
                return goods_list;
            }

            public void setGoods_list(List<GoodsListBean> goods_list) {
                this.goods_list = goods_list;
            }

            public List<?> getCoupon_list() {
                return coupon_list;
            }

            public void setCoupon_list(List<?> coupon_list) {
                this.coupon_list = coupon_list;
            }

            public List<?> getExtract_shop() {
                return extract_shop;
            }

            public void setExtract_shop(List<?> extract_shop) {
                this.extract_shop = extract_shop;
            }

            public List<String> getDeliverySetting() {
                return deliverySetting;
            }

            public void setDeliverySetting(List<String> deliverySetting) {
                this.deliverySetting = deliverySetting;
            }

            public static class AddressBean {
                /**
                 * address_id : 12159
                 * name : 测试
                 * phone : 18312341234
                 * province_id : 1
                 * city_id : 2
                 * region_id : 3
                 * district :
                 * detail : 测试
                 * longitude :
                 * latitude :
                 * user_id : 14784
                 * region : {"province":"北京市","city":"北京市","region":"东城区"}
                 */

                private int address_id;
                private String name;
                private String phone;
                private int province_id;
                private int city_id;
                private int region_id;
                private String district;
                private String detail;
                private String longitude;
                private String latitude;
                private int user_id;
                private RegionBean region;

                public int getAddress_id() {
                    return address_id;
                }

                public void setAddress_id(int address_id) {
                    this.address_id = address_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public int getProvince_id() {
                    return province_id;
                }

                public void setProvince_id(int province_id) {
                    this.province_id = province_id;
                }

                public int getCity_id() {
                    return city_id;
                }

                public void setCity_id(int city_id) {
                    this.city_id = city_id;
                }

                public int getRegion_id() {
                    return region_id;
                }

                public void setRegion_id(int region_id) {
                    this.region_id = region_id;
                }

                public String getDistrict() {
                    return district;
                }

                public void setDistrict(String district) {
                    this.district = district;
                }

                public String getDetail() {
                    return detail;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public RegionBean getRegion() {
                    return region;
                }

                public void setRegion(RegionBean region) {
                    this.region = region;
                }

                public static class RegionBean {
                    /**
                     * province : 北京市
                     * city : 北京市
                     * region : 东城区
                     */

                    private String province;
                    private String city;
                    private String region;

                    public String getProvince() {
                        return province;
                    }

                    public void setProvince(String province) {
                        this.province = province;
                    }

                    public String getCity() {
                        return city;
                    }

                    public void setCity(String city) {
                        this.city = city;
                    }

                    public String getRegion() {
                        return region;
                    }

                    public void setRegion(String region) {
                        this.region = region;
                    }
                }
            }

            public static class SettingBean {
                /**
                 * delivery : ["10","20"]
                 * points_name : 红包值
                 * points_describe : a) 积分不可兑现、不可转让,仅可在本平台使用;
                 b) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;
                 c) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)
                 d) 买家在完成该笔交易(订单状态为“已签收”)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;
                 * tplSetting : {"payment":{"is_enable":"0","template_id":"","template_params":""},"delivery":{"is_enable":"0","template_id":"","template_params":""},"refund":{"is_enable":"0","template_id":"","template_params":""}}
                 */

                private String points_name;
                private String points_describe;
                private TplSettingBean tplSetting;
                private List<String> delivery;

                public String getPoints_name() {
                    return points_name;
                }

                public void setPoints_name(String points_name) {
                    this.points_name = points_name;
                }

                public String getPoints_describe() {
                    return points_describe;
                }

                public void setPoints_describe(String points_describe) {
                    this.points_describe = points_describe;
                }

                public TplSettingBean getTplSetting() {
                    return tplSetting;
                }

                public void setTplSetting(TplSettingBean tplSetting) {
                    this.tplSetting = tplSetting;
                }

                public List<String> getDelivery() {
                    return delivery;
                }

                public void setDelivery(List<String> delivery) {
                    this.delivery = delivery;
                }

                public static class TplSettingBean {
                    /**
                     * payment : {"is_enable":"0","template_id":"","template_params":""}
                     * delivery : {"is_enable":"0","template_id":"","template_params":""}
                     * refund : {"is_enable":"0","template_id":"","template_params":""}
                     */

                    private PaymentBean payment;
                    private DeliveryBean delivery;
                    private RefundBean refund;

                    public PaymentBean getPayment() {
                        return payment;
                    }

                    public void setPayment(PaymentBean payment) {
                        this.payment = payment;
                    }

                    public DeliveryBean getDelivery() {
                        return delivery;
                    }

                    public void setDelivery(DeliveryBean delivery) {
                        this.delivery = delivery;
                    }

                    public RefundBean getRefund() {
                        return refund;
                    }

                    public void setRefund(RefundBean refund) {
                        this.refund = refund;
                    }

                    public static class PaymentBean {
                        /**
                         * is_enable : 0
                         * template_id :
                         * template_params :
                         */

                        private String is_enable;
                        private String template_id;
                        private String template_params;

                        public String getIs_enable() {
                            return is_enable;
                        }

                        public void setIs_enable(String is_enable) {
                            this.is_enable = is_enable;
                        }

                        public String getTemplate_id() {
                            return template_id;
                        }

                        public void setTemplate_id(String template_id) {
                            this.template_id = template_id;
                        }

                        public String getTemplate_params() {
                            return template_params;
                        }

                        public void setTemplate_params(String template_params) {
                            this.template_params = template_params;
                        }
                    }

                    public static class DeliveryBean {
                        /**
                         * is_enable : 0
                         * template_id :
                         * template_params :
                         */

                        private String is_enable;
                        private String template_id;
                        private String template_params;

                        public String getIs_enable() {
                            return is_enable;
                        }

                        public void setIs_enable(String is_enable) {
                            this.is_enable = is_enable;
                        }

                        public String getTemplate_id() {
                            return template_id;
                        }

                        public void setTemplate_id(String template_id) {
                            this.template_id = template_id;
                        }

                        public String getTemplate_params() {
                            return template_params;
                        }

                        public void setTemplate_params(String template_params) {
                            this.template_params = template_params;
                        }
                    }

                    public static class RefundBean {
                        /**
                         * is_enable : 0
                         * template_id :
                         * template_params :
                         */

                        private String is_enable;
                        private String template_id;
                        private String template_params;

                        public String getIs_enable() {
                            return is_enable;
                        }

                        public void setIs_enable(String is_enable) {
                            this.is_enable = is_enable;
                        }

                        public String getTemplate_id() {
                            return template_id;
                        }

                        public void setTemplate_id(String template_id) {
                            this.template_id = template_id;
                        }

                        public String getTemplate_params() {
                            return template_params;
                        }

                        public void setTemplate_params(String template_params) {
                            this.template_params = template_params;
                        }
                    }
                }
            }

            public static class LastExtractBean {
                /**
                 * linkman : 
                 * phone : 17356921108
                 */

                private String linkman;
                private String phone;

                public String getLinkman() {
                    return linkman;
                }

                public void setLinkman(String linkman) {
                    this.linkman = linkman;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }
            }

            public static class UserInfoBean {
                /**
                 * nickName : 
                 * phone : 17356921108
                 */

                private String nickName;
                private String phone;

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }
            }

            public static class GoodsListBean {
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
                 * alone_grade_equity : {"10024":"","10023":"","10022":"","10020":"","10021":""}
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
                 * view_num : 239
                 * is_baopin : 0
                 * is_ziyin : 0
                 * is_pinpai : 0
                 * brand_id : 0
                 * goods_stock : 100
                 * goods_image : http://dijiush.oss-cn-beijing.aliyuncs.com/202009151725453455d7261.jpg
                 * goods_sku : {"goods_sku_id":30589,"goods_id":12014,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.01","line_price":"0.00","real_price":"0.00","stock_num":100,"goods_sales":0,"goods_weight":0,"goods_attr":"","image":null}
                 * goods_multi_spec : null
                 * goods_price : 0.01
                 * total_num : 1
                 * total_price : 0.01
                 * total_need_points_num : 0
                 * total_need_points_money : 0.00
                 * is_user_grade : false
                 * grade_ratio : 0
                 * grade_goods_price : 0
                 * grade_total_money : 0
                 * points_money : 0
                 * points_num : 0
                 * coupon_money : 0
                 * virtual_code_money : 0
                 * total_pay_price : 0.01
                 * express_price : 0.00
                 * points_bonus : 0
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
                private int goods_stock;
                private String goods_image;
                private GoodsSkuBean goods_sku;
                private Object goods_multi_spec;
                private String goods_price;
                private String total_num;
                private String total_price;
                private String total_need_points_num;
                private String total_need_points_money;
                private boolean is_user_grade;
                private int grade_ratio;
                private int grade_goods_price;
                private int grade_total_money;
                private int points_money;
                private String points_num;
                private int coupon_money;
                private int virtual_code_money;
                private String total_pay_price;
                private String express_price;
                private String points_bonus;
                private int goods_sales;

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

                public String getGoods_price() {
                    return goods_price;
                }

                public void setGoods_price(String goods_price) {
                    this.goods_price = goods_price;
                }

                public String getTotal_num() {
                    return total_num;
                }

                public void setTotal_num(String total_num) {
                    this.total_num = total_num;
                }

                public String getTotal_price() {
                    return total_price;
                }

                public void setTotal_price(String total_price) {
                    this.total_price = total_price;
                }

                public String getTotal_need_points_num() {
                    return total_need_points_num;
                }

                public void setTotal_need_points_num(String total_need_points_num) {
                    this.total_need_points_num = total_need_points_num;
                }

                public String getTotal_need_points_money() {
                    return total_need_points_money;
                }

                public void setTotal_need_points_money(String total_need_points_money) {
                    this.total_need_points_money = total_need_points_money;
                }

                public boolean isIs_user_grade() {
                    return is_user_grade;
                }

                public void setIs_user_grade(boolean is_user_grade) {
                    this.is_user_grade = is_user_grade;
                }

                public int getGrade_ratio() {
                    return grade_ratio;
                }

                public void setGrade_ratio(int grade_ratio) {
                    this.grade_ratio = grade_ratio;
                }

                public int getGrade_goods_price() {
                    return grade_goods_price;
                }

                public void setGrade_goods_price(int grade_goods_price) {
                    this.grade_goods_price = grade_goods_price;
                }

                public int getGrade_total_money() {
                    return grade_total_money;
                }

                public void setGrade_total_money(int grade_total_money) {
                    this.grade_total_money = grade_total_money;
                }

                public int getPoints_money() {
                    return points_money;
                }

                public void setPoints_money(int points_money) {
                    this.points_money = points_money;
                }

                public String getPoints_num() {
                    return points_num;
                }

                public void setPoints_num(String points_num) {
                    this.points_num = points_num;
                }

                public int getCoupon_money() {
                    return coupon_money;
                }

                public void setCoupon_money(int coupon_money) {
                    this.coupon_money = coupon_money;
                }

                public int getVirtual_code_money() {
                    return virtual_code_money;
                }

                public void setVirtual_code_money(int virtual_code_money) {
                    this.virtual_code_money = virtual_code_money;
                }

                public String getTotal_pay_price() {
                    return total_pay_price;
                }

                public void setTotal_pay_price(String total_pay_price) {
                    this.total_pay_price = total_pay_price;
                }

                public String getExpress_price() {
                    return express_price;
                }

                public void setExpress_price(String express_price) {
                    this.express_price = express_price;
                }

                public String getPoints_bonus() {
                    return points_bonus;
                }

                public void setPoints_bonus(String points_bonus) {
                    this.points_bonus = points_bonus;
                }

                public int getGoods_sales() {
                    return goods_sales;
                }

                public void setGoods_sales(int goods_sales) {
                    this.goods_sales = goods_sales;
                }

                public static class AloneGradeEquityBean {
                    /**
                     * 10024 :
                     * 10023 :
                     * 10022 :
                     * 10020 :
                     * 10021 :
                     */

                    @SerializedName("10024")
                    private String _$10024;
                    @SerializedName("10023")
                    private String _$10023;
                    @SerializedName("10022")
                    private String _$10022;
                    @SerializedName("10020")
                    private String _$10020;
                    @SerializedName("10021")
                    private String _$10021;

                    public String get_$10024() {
                        return _$10024;
                    }

                    public void set_$10024(String _$10024) {
                        this._$10024 = _$10024;
                    }

                    public String get_$10023() {
                        return _$10023;
                    }

                    public void set_$10023(String _$10023) {
                        this._$10023 = _$10023;
                    }

                    public String get_$10022() {
                        return _$10022;
                    }

                    public void set_$10022(String _$10022) {
                        this._$10022 = _$10022;
                    }

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
                     * goods_sku_id : 30589
                     * goods_id : 12014
                     * spec_sku_id : 0
                     * image_id : 0
                     * goods_no :
                     * balance_price : 0.00
                     * goods_price : 0.01
                     * line_price : 0.00
                     * real_price : 0.00
                     * stock_num : 100
                     * goods_sales : 0
                     * goods_weight : 0
                     * goods_attr :
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
                    private String goods_attr;
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

                    public String getGoods_attr() {
                        return goods_attr;
                    }

                    public void setGoods_attr(String goods_attr) {
                        this.goods_attr = goods_attr;
                    }

                    public Object getImage() {
                        return image;
                    }

                    public void setImage(Object image) {
                        this.image = image;
                    }
                }
            }
        }
    }
}
