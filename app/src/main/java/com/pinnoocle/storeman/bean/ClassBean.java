package com.pinnoocle.storeman.bean;

import java.util.List;

public class ClassBean {
    /**
     * data : {"goods_category":[{"category_id":10541,"name":"扶商咨询","parent_id":0,"image_id":0,"sort":100,"type":3,"create_time":"2020-09-15 17:25:16","image":null}]}
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
        private List<GoodsCategoryBean> goods_category;

        public List<GoodsCategoryBean> getGoods_category() {
            return goods_category;
        }

        public void setGoods_category(List<GoodsCategoryBean> goods_category) {
            this.goods_category = goods_category;
        }

        public static class GoodsCategoryBean {
            /**
             * category_id : 10541
             * name : 扶商咨询
             * parent_id : 0
             * image_id : 0
             * sort : 100
             * type : 3
             * create_time : 2020-09-15 17:25:16
             * image : null
             */

            private int category_id;
            private String name;
            private int parent_id;
            private int image_id;
            private int sort;
            private int type;
            private String create_time;
            private Object image;

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

            public Object getImage() {
                return image;
            }

            public void setImage(Object image) {
                this.image = image;
            }
        }
    }
}
