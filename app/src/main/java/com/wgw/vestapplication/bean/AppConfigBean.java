package com.wgw.vestapplication.bean;

public class AppConfigBean {
    private boolean success;
    private String ShowWeb;
    private String PushKey;
    private String Url;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getShowWeb() {
        return ShowWeb;
    }

    public void setShowWeb(String showWeb) {
        ShowWeb = showWeb;
    }

    public String getPushKey() {
        return PushKey;
    }

    public void setPushKey(String pushKey) {
        PushKey = pushKey;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
