package com.wgw.vestapplication.net;

/**
 * Author:Admin
 * Time:2019/9/2 14:35
 * 描述：
 */
public interface ApiCallBack {
    void onHttpSuccess(Object data);
    void onHttpFail(Object failMsg);
}
