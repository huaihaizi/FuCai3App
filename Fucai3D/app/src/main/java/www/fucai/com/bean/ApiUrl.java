package www.fucai.com.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Lenovo on 2017/6/16.
 */

public class ApiUrl extends BmobObject {

    private String httpUrl = "";
    private String app_name = "";

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

}
