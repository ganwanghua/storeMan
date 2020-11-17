package com.pinnoocle.storeman.bean;

public class ApplyInfoBean {
    /**
     * data : {"info":{"is_apply":1,"info":{"apply_id":455,"shanglv_id":111,"user_id":14482,"image_id":19907,"shop_name":"app商家名称","name":"法人姓名","number":"组织机构代码","type":"企业类型","reg_time":"注册时间","jingyin_status":"经营状态","real_name":"联系人","mobile":"联系电话","status":0,"result":null,"create_time":1605078728,"update_time":1605078728,"is_delete":0,"wxapp_id":10001,"image":"https://djsh.dijiushenghuo.com/uploads/2020060611493827c270761.jpeg"},"shop_price":"2000","is_pay":0,"is_shanglv":0,"share_shanglv_id":null}}
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
         * info : {"is_apply":1,"info":{"apply_id":455,"shanglv_id":111,"user_id":14482,"image_id":19907,"shop_name":"app商家名称","name":"法人姓名","number":"组织机构代码","type":"企业类型","reg_time":"注册时间","jingyin_status":"经营状态","real_name":"联系人","mobile":"联系电话","status":0,"result":null,"create_time":1605078728,"update_time":1605078728,"is_delete":0,"wxapp_id":10001,"image":"https://djsh.dijiushenghuo.com/uploads/2020060611493827c270761.jpeg"},"shop_price":"2000","is_pay":0,"is_shanglv":0,"share_shanglv_id":null}
         */

        private InfoBeanX info;

        public InfoBeanX getInfo() {
            return info;
        }

        public void setInfo(InfoBeanX info) {
            this.info = info;
        }

        public static class InfoBeanX {
            /**
             * is_apply : 1
             * info : {"apply_id":455,"shanglv_id":111,"user_id":14482,"image_id":19907,"shop_name":"app商家名称","name":"法人姓名","number":"组织机构代码","type":"企业类型","reg_time":"注册时间","jingyin_status":"经营状态","real_name":"联系人","mobile":"联系电话","status":0,"result":null,"create_time":1605078728,"update_time":1605078728,"is_delete":0,"wxapp_id":10001,"image":"https://djsh.dijiushenghuo.com/uploads/2020060611493827c270761.jpeg"}
             * shop_price : 2000
             * is_pay : 0
             * is_shanglv : 0
             * share_shanglv_id : null
             */

            private int is_apply;
            private InfoBean info;
            private String shop_price;
            private int is_pay;
            private int is_shanglv;
            private Object share_shanglv_id;

            public int getIs_apply() {
                return is_apply;
            }

            public void setIs_apply(int is_apply) {
                this.is_apply = is_apply;
            }

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public String getShop_price() {
                return shop_price;
            }

            public void setShop_price(String shop_price) {
                this.shop_price = shop_price;
            }

            public int getIs_pay() {
                return is_pay;
            }

            public void setIs_pay(int is_pay) {
                this.is_pay = is_pay;
            }

            public int getIs_shanglv() {
                return is_shanglv;
            }

            public void setIs_shanglv(int is_shanglv) {
                this.is_shanglv = is_shanglv;
            }

            public Object getShare_shanglv_id() {
                return share_shanglv_id;
            }

            public void setShare_shanglv_id(Object share_shanglv_id) {
                this.share_shanglv_id = share_shanglv_id;
            }

            public static class InfoBean {
                /**
                 * apply_id : 455
                 * shanglv_id : 111
                 * user_id : 14482
                 * image_id : 19907
                 * shop_name : app商家名称
                 * name : 法人姓名
                 * number : 组织机构代码
                 * type : 企业类型
                 * reg_time : 注册时间
                 * jingyin_status : 经营状态
                 * real_name : 联系人
                 * mobile : 联系电话
                 * status : 0
                 * result : null
                 * create_time : 1605078728
                 * update_time : 1605078728
                 * is_delete : 0
                 * wxapp_id : 10001
                 * image : https://djsh.dijiushenghuo.com/uploads/2020060611493827c270761.jpeg
                 */

                private int apply_id;
                private int shanglv_id;
                private int user_id;
                private int image_id;
                private String shop_name;
                private String name;
                private String number;
                private String type;
                private String reg_time;
                private String jingyin_status;
                private String real_name;
                private String mobile;
                private int status;
                private Object result;
                private int create_time;
                private int update_time;
                private int is_delete;
                private int wxapp_id;
                private String image;

                public int getApply_id() {
                    return apply_id;
                }

                public void setApply_id(int apply_id) {
                    this.apply_id = apply_id;
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

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public String getShop_name() {
                    return shop_name;
                }

                public void setShop_name(String shop_name) {
                    this.shop_name = shop_name;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getNumber() {
                    return number;
                }

                public void setNumber(String number) {
                    this.number = number;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getReg_time() {
                    return reg_time;
                }

                public void setReg_time(String reg_time) {
                    this.reg_time = reg_time;
                }

                public String getJingyin_status() {
                    return jingyin_status;
                }

                public void setJingyin_status(String jingyin_status) {
                    this.jingyin_status = jingyin_status;
                }

                public String getReal_name() {
                    return real_name;
                }

                public void setReal_name(String real_name) {
                    this.real_name = real_name;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public Object getResult() {
                    return result;
                }

                public void setResult(Object result) {
                    this.result = result;
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

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }
            }
        }
    }
}
