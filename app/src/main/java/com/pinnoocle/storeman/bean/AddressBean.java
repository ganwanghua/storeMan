package com.pinnoocle.storeman.bean;

import java.util.List;

public class AddressBean {
    /**
     * data : {"list":[{"address_id":12159,"name":"测试","phone":"18312341234","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"测试","longitude":"","latitude":"","user_id":14784,"region":{"province":"北京市","city":"北京市","region":"东城区"}}],"default_id":12159}
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
         * list : [{"address_id":12159,"name":"测试","phone":"18312341234","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"测试","longitude":"","latitude":"","user_id":14784,"region":{"province":"北京市","city":"北京市","region":"东城区"}}]
         * default_id : 12159
         */

        private int default_id;
        private List<ListBean> list;

        public int getDefault_id() {
            return default_id;
        }

        public void setDefault_id(int default_id) {
            this.default_id = default_id;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
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
    }
}
