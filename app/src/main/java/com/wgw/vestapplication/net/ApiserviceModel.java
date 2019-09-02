package com.wgw.vestapplication.net;

import android.util.Log;
import com.wgw.vestapplication.bean.AppConfigBean;
import com.wgw.vestapplication.net.retrofit.RetrofitUtils;
import com.wgw.vestapplication.net.retrofit.api.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:Admin
 * Time:2019/9/2 15:15
 * 描述：
 */
public class ApiserviceModel {
    ApiService mApiService;
    public ApiserviceModel(){
        mApiService = RetrofitUtils.getInstance().createService(ApiService.class);
    }
    public void getAppConfig(String appId, final ApiCallBack apiCallBack){
        mApiService.getAppConfig(appId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AppConfigBean>() {
                    @Override
                    public void accept(AppConfigBean appConfigBean) throws Exception {
                        Log.d("wgw_getAppConfig", "===" + appConfigBean.getSuccess());
                        apiCallBack.onHttpSuccess(appConfigBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        apiCallBack.onHttpFail(throwable.getMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                });
    }

}
