package com.pinnoocle.storeman.bean;

/**
 * Created by ThinkPad-T430 on 2019/6/11.
 */

public class UploadModel {

    /**
     * code : 1
     * errmsg : 上传成功
     * data : https://www.knjsq.com/Uploads/c6b3f4596518a1105e41adf2f5a76268.png
     */

    private int code;
    private String msg;
    private userData data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String errmsg) {
        this.msg = errmsg;
    }

    public userData getData() {
        return data;
    }

    public void setData(userData data) {
        this.data = data;
    }
    public static class userData{

        private String file_name;
        private String file_path;
        private String file_id;

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }

        public String getFile_path() {
            return file_path;
        }

        public void setFile_path(String file_path) {
            this.file_path = file_path;
        }

        public String getFile_id() {
            return file_id;
        }

        public void setFile_id(String file_id) {
            this.file_id = file_id;
        }
    }
}
