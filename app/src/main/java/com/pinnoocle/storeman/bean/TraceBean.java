package com.pinnoocle.storeman.bean;

import java.util.List;

public class TraceBean {
    /**
     * data : {"express":{"express_name":"百世快递","express_no":"557031649526755","list":[{"time":"2020-11-12 20:36:12","context":"合肥市|已签收，签收人凭取货码签收。","ftime":"2020-11-12 20:36:12","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"签收"},{"time":"2020-11-12 16:52:41","context":"合肥市|快件已暂存至合肥翡翠蓝湾畅园A106号店菜鸟驿站，如有疑问请联系18297938132","ftime":"2020-11-12 16:52:41","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"派件"},{"time":"2020-11-12 13:50:04","context":"合肥市|【苏维长/13856584434】正在派件，【新肥西县/网点电话15695695812 15656908189 】","ftime":"2020-11-12 13:50:04","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"派件"},{"time":"2020-11-12 11:55:39","context":"合肥市|到【新肥西县】","ftime":"2020-11-12 11:55:39","areaCode":null,"areaName":null,"status":"在途"},{"time":"2020-11-12 02:23:21","context":"合肥市|【合肥转运中心】，正发往【新肥西县】","ftime":"2020-11-12 02:23:21","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"在途"},{"time":"2020-11-12 02:11:35","context":"合肥市|到【合肥转运中心】","ftime":"2020-11-12 02:11:35","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"在途"},{"time":"2020-11-11 09:53:25","context":"蚌埠市|【蚌埠转运中心】，正发往【合肥转运中心】","ftime":"2020-11-11 09:53:25","areaCode":"CN340300000000","areaName":"安徽,蚌埠市","status":"在途"},{"time":"2020-11-11 09:51:20","context":"蚌埠市|到【蚌埠转运中心】","ftime":"2020-11-11 09:51:20","areaCode":"CN340300000000","areaName":"安徽,蚌埠市","status":"在途"},{"time":"2020-11-10 21:16:14","context":"潍坊市|【潍坊转运中心】，正发往【蚌埠转运中心】","ftime":"2020-11-10 21:16:14","areaCode":"CN370700000000","areaName":"山东,潍坊市","status":"在途"},{"time":"2020-11-10 21:13:03","context":"潍坊市|到【潍坊转运中心】","ftime":"2020-11-10 21:13:03","areaCode":"CN370700000000","areaName":"山东,潍坊市","status":"在途"},{"time":"2020-11-10 20:31:48","context":"潍坊市|到【潍坊分拨集货点】","ftime":"2020-11-10 20:31:48","areaCode":null,"areaName":null,"status":"在途"},{"time":"2020-11-10 17:15:36","context":"潍坊市|【潍坊高新区一部】，【张瑞平/15318902566】已揽收","ftime":"2020-11-10 17:15:36","areaCode":null,"areaName":null,"status":"揽收"}]}}
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
         * express : {"express_name":"百世快递","express_no":"557031649526755","list":[{"time":"2020-11-12 20:36:12","context":"合肥市|已签收，签收人凭取货码签收。","ftime":"2020-11-12 20:36:12","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"签收"},{"time":"2020-11-12 16:52:41","context":"合肥市|快件已暂存至合肥翡翠蓝湾畅园A106号店菜鸟驿站，如有疑问请联系18297938132","ftime":"2020-11-12 16:52:41","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"派件"},{"time":"2020-11-12 13:50:04","context":"合肥市|【苏维长/13856584434】正在派件，【新肥西县/网点电话15695695812 15656908189 】","ftime":"2020-11-12 13:50:04","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"派件"},{"time":"2020-11-12 11:55:39","context":"合肥市|到【新肥西县】","ftime":"2020-11-12 11:55:39","areaCode":null,"areaName":null,"status":"在途"},{"time":"2020-11-12 02:23:21","context":"合肥市|【合肥转运中心】，正发往【新肥西县】","ftime":"2020-11-12 02:23:21","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"在途"},{"time":"2020-11-12 02:11:35","context":"合肥市|到【合肥转运中心】","ftime":"2020-11-12 02:11:35","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"在途"},{"time":"2020-11-11 09:53:25","context":"蚌埠市|【蚌埠转运中心】，正发往【合肥转运中心】","ftime":"2020-11-11 09:53:25","areaCode":"CN340300000000","areaName":"安徽,蚌埠市","status":"在途"},{"time":"2020-11-11 09:51:20","context":"蚌埠市|到【蚌埠转运中心】","ftime":"2020-11-11 09:51:20","areaCode":"CN340300000000","areaName":"安徽,蚌埠市","status":"在途"},{"time":"2020-11-10 21:16:14","context":"潍坊市|【潍坊转运中心】，正发往【蚌埠转运中心】","ftime":"2020-11-10 21:16:14","areaCode":"CN370700000000","areaName":"山东,潍坊市","status":"在途"},{"time":"2020-11-10 21:13:03","context":"潍坊市|到【潍坊转运中心】","ftime":"2020-11-10 21:13:03","areaCode":"CN370700000000","areaName":"山东,潍坊市","status":"在途"},{"time":"2020-11-10 20:31:48","context":"潍坊市|到【潍坊分拨集货点】","ftime":"2020-11-10 20:31:48","areaCode":null,"areaName":null,"status":"在途"},{"time":"2020-11-10 17:15:36","context":"潍坊市|【潍坊高新区一部】，【张瑞平/15318902566】已揽收","ftime":"2020-11-10 17:15:36","areaCode":null,"areaName":null,"status":"揽收"}]}
         */

        private ExpressBean express;

        public ExpressBean getExpress() {
            return express;
        }

        public void setExpress(ExpressBean express) {
            this.express = express;
        }

        public static class ExpressBean {
            /**
             * express_name : 百世快递
             * express_no : 557031649526755
             * list : [{"time":"2020-11-12 20:36:12","context":"合肥市|已签收，签收人凭取货码签收。","ftime":"2020-11-12 20:36:12","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"签收"},{"time":"2020-11-12 16:52:41","context":"合肥市|快件已暂存至合肥翡翠蓝湾畅园A106号店菜鸟驿站，如有疑问请联系18297938132","ftime":"2020-11-12 16:52:41","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"派件"},{"time":"2020-11-12 13:50:04","context":"合肥市|【苏维长/13856584434】正在派件，【新肥西县/网点电话15695695812 15656908189 】","ftime":"2020-11-12 13:50:04","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"派件"},{"time":"2020-11-12 11:55:39","context":"合肥市|到【新肥西县】","ftime":"2020-11-12 11:55:39","areaCode":null,"areaName":null,"status":"在途"},{"time":"2020-11-12 02:23:21","context":"合肥市|【合肥转运中心】，正发往【新肥西县】","ftime":"2020-11-12 02:23:21","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"在途"},{"time":"2020-11-12 02:11:35","context":"合肥市|到【合肥转运中心】","ftime":"2020-11-12 02:11:35","areaCode":"CN340100000000","areaName":"安徽,合肥市","status":"在途"},{"time":"2020-11-11 09:53:25","context":"蚌埠市|【蚌埠转运中心】，正发往【合肥转运中心】","ftime":"2020-11-11 09:53:25","areaCode":"CN340300000000","areaName":"安徽,蚌埠市","status":"在途"},{"time":"2020-11-11 09:51:20","context":"蚌埠市|到【蚌埠转运中心】","ftime":"2020-11-11 09:51:20","areaCode":"CN340300000000","areaName":"安徽,蚌埠市","status":"在途"},{"time":"2020-11-10 21:16:14","context":"潍坊市|【潍坊转运中心】，正发往【蚌埠转运中心】","ftime":"2020-11-10 21:16:14","areaCode":"CN370700000000","areaName":"山东,潍坊市","status":"在途"},{"time":"2020-11-10 21:13:03","context":"潍坊市|到【潍坊转运中心】","ftime":"2020-11-10 21:13:03","areaCode":"CN370700000000","areaName":"山东,潍坊市","status":"在途"},{"time":"2020-11-10 20:31:48","context":"潍坊市|到【潍坊分拨集货点】","ftime":"2020-11-10 20:31:48","areaCode":null,"areaName":null,"status":"在途"},{"time":"2020-11-10 17:15:36","context":"潍坊市|【潍坊高新区一部】，【张瑞平/15318902566】已揽收","ftime":"2020-11-10 17:15:36","areaCode":null,"areaName":null,"status":"揽收"}]
             */

            private String express_name;
            private String express_no;
            private List<ListBean> list;

            public String getExpress_name() {
                return express_name;
            }

            public void setExpress_name(String express_name) {
                this.express_name = express_name;
            }

            public String getExpress_no() {
                return express_no;
            }

            public void setExpress_no(String express_no) {
                this.express_no = express_no;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * time : 2020-11-12 20:36:12
                 * context : 合肥市|已签收，签收人凭取货码签收。
                 * ftime : 2020-11-12 20:36:12
                 * areaCode : CN340100000000
                 * areaName : 安徽,合肥市
                 * status : 签收
                 */

                private String time;
                private String context;
                private String ftime;
                private String areaCode;
                private String areaName;
                private String status;

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public String getContext() {
                    return context;
                }

                public void setContext(String context) {
                    this.context = context;
                }

                public String getFtime() {
                    return ftime;
                }

                public void setFtime(String ftime) {
                    this.ftime = ftime;
                }

                public String getAreaCode() {
                    return areaCode;
                }

                public void setAreaCode(String areaCode) {
                    this.areaCode = areaCode;
                }

                public String getAreaName() {
                    return areaName;
                }

                public void setAreaName(String areaName) {
                    this.areaName = areaName;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }
            }
        }
    }
}
