package com.pinnoocle.storeman.bean;

public class SearchBean {
    /**
     * data : {"user":{"user_id":14752,"open_id":"oFFMt5Aoz3_9zlKJIP24-_oc4ImM","alipay_user_id":"","nickName":"辛福","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEL5LIwQrmeJmricxK6qCKzgxpC53QaESFDDRjVMgRGkkRaXaR0gKoL5NQrDBA0l8WVgpiaGicNMpazKA/132","gender":2,"country":"China","province":"Anhui","city":"Xuancheng","address_id":0,"balance":"0.00","points":"0.00","pay_money":"0.00","commission":"0.00","expend_money":"0.00","grade_id":0,"is_new_user":1,"is_delete":0,"wxapp_id":10001,"create_time":1597031020,"update_time":1604309049,"phone":"","password":null,"fid":0,"mid":1,"role":0,"smile":0,"weixin":null,"job":null,"email":null,"source_name":null,"source_text":null,"source_cardid":null,"lasttime":null,"group_tags":null,"company":null,"position":null,"source_type":1,"scene":null,"source_id":null,"phonemodel":null,"address":null,"username":null,"is_mix":0,"share_shop_id":0,"contract_id":"0","shop_contract_id":null}}
     * code : 0
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
         * user : {"user_id":14752,"open_id":"oFFMt5Aoz3_9zlKJIP24-_oc4ImM","alipay_user_id":"","nickName":"辛福","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEL5LIwQrmeJmricxK6qCKzgxpC53QaESFDDRjVMgRGkkRaXaR0gKoL5NQrDBA0l8WVgpiaGicNMpazKA/132","gender":2,"country":"China","province":"Anhui","city":"Xuancheng","address_id":0,"balance":"0.00","points":"0.00","pay_money":"0.00","commission":"0.00","expend_money":"0.00","grade_id":0,"is_new_user":1,"is_delete":0,"wxapp_id":10001,"create_time":1597031020,"update_time":1604309049,"phone":"","password":null,"fid":0,"mid":1,"role":0,"smile":0,"weixin":null,"job":null,"email":null,"source_name":null,"source_text":null,"source_cardid":null,"lasttime":null,"group_tags":null,"company":null,"position":null,"source_type":1,"scene":null,"source_id":null,"phonemodel":null,"address":null,"username":null,"is_mix":0,"share_shop_id":0,"contract_id":"0","shop_contract_id":null}
         */

        private UserBean user;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * user_id : 14752
             * open_id : oFFMt5Aoz3_9zlKJIP24-_oc4ImM
             * alipay_user_id :
             * nickName : 辛福
             * avatarUrl : https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEL5LIwQrmeJmricxK6qCKzgxpC53QaESFDDRjVMgRGkkRaXaR0gKoL5NQrDBA0l8WVgpiaGicNMpazKA/132
             * gender : 2
             * country : China
             * province : Anhui
             * city : Xuancheng
             * address_id : 0
             * balance : 0.00
             * points : 0.00
             * pay_money : 0.00
             * commission : 0.00
             * expend_money : 0.00
             * grade_id : 0
             * is_new_user : 1
             * is_delete : 0
             * wxapp_id : 10001
             * create_time : 1597031020
             * update_time : 1604309049
             * phone :
             * password : null
             * fid : 0
             * mid : 1
             * role : 0
             * smile : 0
             * weixin : null
             * job : null
             * email : null
             * source_name : null
             * source_text : null
             * source_cardid : null
             * lasttime : null
             * group_tags : null
             * company : null
             * position : null
             * source_type : 1
             * scene : null
             * source_id : null
             * phonemodel : null
             * address : null
             * username : null
             * is_mix : 0
             * share_shop_id : 0
             * contract_id : 0
             * shop_contract_id : null
             */

            private int user_id;
            private String open_id;
            private String alipay_user_id;
            private String nickName;
            private String avatarUrl;
            private int gender;
            private String country;
            private String province;
            private String city;
            private int address_id;
            private String balance;
            private String points;
            private String pay_money;
            private String commission;
            private String expend_money;
            private int grade_id;
            private int is_new_user;
            private int is_delete;
            private int wxapp_id;
            private int create_time;
            private int update_time;
            private String phone;
            private Object password;
            private int fid;
            private int mid;
            private int role;
            private int smile;
            private Object weixin;
            private Object job;
            private Object email;
            private Object source_name;
            private Object source_text;
            private Object source_cardid;
            private Object lasttime;
            private Object group_tags;
            private Object company;
            private Object position;
            private int source_type;
            private Object scene;
            private Object source_id;
            private Object phonemodel;
            private Object address;
            private Object username;
            private int is_mix;
            private int share_shop_id;
            private String contract_id;
            private Object shop_contract_id;

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getOpen_id() {
                return open_id;
            }

            public void setOpen_id(String open_id) {
                this.open_id = open_id;
            }

            public String getAlipay_user_id() {
                return alipay_user_id;
            }

            public void setAlipay_user_id(String alipay_user_id) {
                this.alipay_user_id = alipay_user_id;
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

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

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

            public int getAddress_id() {
                return address_id;
            }

            public void setAddress_id(int address_id) {
                this.address_id = address_id;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
            }

            public String getPay_money() {
                return pay_money;
            }

            public void setPay_money(String pay_money) {
                this.pay_money = pay_money;
            }

            public String getCommission() {
                return commission;
            }

            public void setCommission(String commission) {
                this.commission = commission;
            }

            public String getExpend_money() {
                return expend_money;
            }

            public void setExpend_money(String expend_money) {
                this.expend_money = expend_money;
            }

            public int getGrade_id() {
                return grade_id;
            }

            public void setGrade_id(int grade_id) {
                this.grade_id = grade_id;
            }

            public int getIs_new_user() {
                return is_new_user;
            }

            public void setIs_new_user(int is_new_user) {
                this.is_new_user = is_new_user;
            }

            public int getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(int is_delete) {
                this.is_delete = is_delete;
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

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
                this.password = password;
            }

            public int getFid() {
                return fid;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public int getRole() {
                return role;
            }

            public void setRole(int role) {
                this.role = role;
            }

            public int getSmile() {
                return smile;
            }

            public void setSmile(int smile) {
                this.smile = smile;
            }

            public Object getWeixin() {
                return weixin;
            }

            public void setWeixin(Object weixin) {
                this.weixin = weixin;
            }

            public Object getJob() {
                return job;
            }

            public void setJob(Object job) {
                this.job = job;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public Object getSource_name() {
                return source_name;
            }

            public void setSource_name(Object source_name) {
                this.source_name = source_name;
            }

            public Object getSource_text() {
                return source_text;
            }

            public void setSource_text(Object source_text) {
                this.source_text = source_text;
            }

            public Object getSource_cardid() {
                return source_cardid;
            }

            public void setSource_cardid(Object source_cardid) {
                this.source_cardid = source_cardid;
            }

            public Object getLasttime() {
                return lasttime;
            }

            public void setLasttime(Object lasttime) {
                this.lasttime = lasttime;
            }

            public Object getGroup_tags() {
                return group_tags;
            }

            public void setGroup_tags(Object group_tags) {
                this.group_tags = group_tags;
            }

            public Object getCompany() {
                return company;
            }

            public void setCompany(Object company) {
                this.company = company;
            }

            public Object getPosition() {
                return position;
            }

            public void setPosition(Object position) {
                this.position = position;
            }

            public int getSource_type() {
                return source_type;
            }

            public void setSource_type(int source_type) {
                this.source_type = source_type;
            }

            public Object getScene() {
                return scene;
            }

            public void setScene(Object scene) {
                this.scene = scene;
            }

            public Object getSource_id() {
                return source_id;
            }

            public void setSource_id(Object source_id) {
                this.source_id = source_id;
            }

            public Object getPhonemodel() {
                return phonemodel;
            }

            public void setPhonemodel(Object phonemodel) {
                this.phonemodel = phonemodel;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
                this.username = username;
            }

            public int getIs_mix() {
                return is_mix;
            }

            public void setIs_mix(int is_mix) {
                this.is_mix = is_mix;
            }

            public int getShare_shop_id() {
                return share_shop_id;
            }

            public void setShare_shop_id(int share_shop_id) {
                this.share_shop_id = share_shop_id;
            }

            public String getContract_id() {
                return contract_id;
            }

            public void setContract_id(String contract_id) {
                this.contract_id = contract_id;
            }

            public Object getShop_contract_id() {
                return shop_contract_id;
            }

            public void setShop_contract_id(Object shop_contract_id) {
                this.shop_contract_id = shop_contract_id;
            }
        }
    }
}
