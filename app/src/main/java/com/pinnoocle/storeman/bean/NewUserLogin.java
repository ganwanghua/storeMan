package com.pinnoocle.storeman.bean;

public class NewUserLogin {

    /**
     * code : 1
     * data : {"shop":{"shop_id":10018,"shanglv_id":0,"user_id":14759,"apply_id":2,"shop_name":"测试店铺（不要删）","money":"0.00","commission":"0.00","logo_image_id":20257,"image_id":20245,"area_id":10435,"category_id":10436,"tips":"","linkman":"晓晓","phone":"18312341234","password":"96e79218965eb72c92a549dd5a330112","shop_hours":"8-12","price":"0.00","province_id":1046,"city_id":1,"region_id":1048,"address":"芙蓉路东海花园","longitude":"0","latitude":"0","geohash":"7zzzzzzzzzz","summary":"0","sort":100,"is_hot":0,"is_check":1,"percent":"0.00","status":1,"is_delete":0,"can_goods":1,"can_foods":1,"wxapp_id":10001,"create_time":1595313606,"update_time":1597028364,"can_notice":0}}
     * msg : 登录成功
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * shop : {"shop_id":10018,"shanglv_id":0,"user_id":14759,"apply_id":2,"shop_name":"测试店铺（不要删）","money":"0.00","commission":"0.00","logo_image_id":20257,"image_id":20245,"area_id":10435,"category_id":10436,"tips":"","linkman":"晓晓","phone":"18312341234","password":"96e79218965eb72c92a549dd5a330112","shop_hours":"8-12","price":"0.00","province_id":1046,"city_id":1,"region_id":1048,"address":"芙蓉路东海花园","longitude":"0","latitude":"0","geohash":"7zzzzzzzzzz","summary":"0","sort":100,"is_hot":0,"is_check":1,"percent":"0.00","status":1,"is_delete":0,"can_goods":1,"can_foods":1,"wxapp_id":10001,"create_time":1595313606,"update_time":1597028364,"can_notice":0}
         */

        private ShopBean shop;

        public ShopBean getShop() {
            return shop;
        }

        public void setShop(ShopBean shop) {
            this.shop = shop;
        }

        public static class ShopBean {
            /**
             * shop_id : 10018
             * shanglv_id : 0
             * user_id : 14759
             * apply_id : 2
             * shop_name : 测试店铺（不要删）
             * money : 0.00
             * commission : 0.00
             * logo_image_id : 20257
             * image_id : 20245
             * area_id : 10435
             * category_id : 10436
             * tips :
             * linkman : 晓晓
             * phone : 18312341234
             * password : 96e79218965eb72c92a549dd5a330112
             * shop_hours : 8-12
             * price : 0.00
             * province_id : 1046
             * city_id : 1
             * region_id : 1048
             * address : 芙蓉路东海花园
             * longitude : 0
             * latitude : 0
             * geohash : 7zzzzzzzzzz
             * summary : 0
             * sort : 100
             * is_hot : 0
             * is_check : 1
             * percent : 0.00
             * status : 1
             * is_delete : 0
             * can_goods : 1
             * can_foods : 1
             * wxapp_id : 10001
             * create_time : 1595313606
             * update_time : 1597028364
             * can_notice : 0
             */

            private int shop_id;
            private int shanglv_id;
            private int user_id;
            private int apply_id;
            private String shop_name;
            private String money;
            private String commission;
            private int logo_image_id;
            private int image_id;
            private int area_id;
            private int category_id;
            private String tips;
            private String linkman;
            private String phone;
            private String password;
            private String shop_hours;
            private String price;
            private int province_id;
            private int city_id;
            private int region_id;
            private String address;
            private String longitude;
            private String latitude;
            private String geohash;
            private String summary;
            private int sort;
            private int is_hot;
            private int is_check;
            private String percent;
            private int status;
            private int is_delete;
            private int can_goods;
            private int can_foods;
            private int wxapp_id;
            private int create_time;
            private int update_time;
            private int can_notice;

            public int getShop_id() {
                return shop_id;
            }

            public void setShop_id(int shop_id) {
                this.shop_id = shop_id;
            }

            public int getShanglv_id() {
                return shanglv_id;
            }

            public void setShanglv_id(int shanglv_id) {
                this.shanglv_id = shanglv_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getApply_id() {
                return apply_id;
            }

            public void setApply_id(int apply_id) {
                this.apply_id = apply_id;
            }

            public String getShop_name() {
                return shop_name;
            }

            public void setShop_name(String shop_name) {
                this.shop_name = shop_name;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getCommission() {
                return commission;
            }

            public void setCommission(String commission) {
                this.commission = commission;
            }

            public int getLogo_image_id() {
                return logo_image_id;
            }

            public void setLogo_image_id(int logo_image_id) {
                this.logo_image_id = logo_image_id;
            }

            public int getImage_id() {
                return image_id;
            }

            public void setImage_id(int image_id) {
                this.image_id = image_id;
            }

            public int getArea_id() {
                return area_id;
            }

            public void setArea_id(int area_id) {
                this.area_id = area_id;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getTips() {
                return tips;
            }

            public void setTips(String tips) {
                this.tips = tips;
            }

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

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getShop_hours() {
                return shop_hours;
            }

            public void setShop_hours(String shop_hours) {
                this.shop_hours = shop_hours;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
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

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
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

            public String getGeohash() {
                return geohash;
            }

            public void setGeohash(String geohash) {
                this.geohash = geohash;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getIs_hot() {
                return is_hot;
            }

            public void setIs_hot(int is_hot) {
                this.is_hot = is_hot;
            }

            public int getIs_check() {
                return is_check;
            }

            public void setIs_check(int is_check) {
                this.is_check = is_check;
            }

            public String getPercent() {
                return percent;
            }

            public void setPercent(String percent) {
                this.percent = percent;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(int is_delete) {
                this.is_delete = is_delete;
            }

            public int getCan_goods() {
                return can_goods;
            }

            public void setCan_goods(int can_goods) {
                this.can_goods = can_goods;
            }

            public int getCan_foods() {
                return can_foods;
            }

            public void setCan_foods(int can_foods) {
                this.can_foods = can_foods;
            }

            public int getWxapp_id() {
                return wxapp_id;
            }

            public void setWxapp_id(int wxapp_id) {
                this.wxapp_id = wxapp_id;
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

            public int getCan_notice() {
                return can_notice;
            }

            public void setCan_notice(int can_notice) {
                this.can_notice = can_notice;
            }
        }
    }
}
