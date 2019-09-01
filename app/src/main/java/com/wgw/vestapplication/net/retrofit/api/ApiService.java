package com.wgw.vestapplication.net.retrofit.api;

import com.wgw.vestapplication.bean.AppConfigBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    @GET("getAppConfig.php")
    Observable<AppConfigBean> getAppConfig(@Query("appid") String appId);
}
