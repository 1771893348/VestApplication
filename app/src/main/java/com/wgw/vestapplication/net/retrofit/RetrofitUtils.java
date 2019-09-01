package com.wgw.vestapplication.net.retrofit;

import android.util.Log;
import com.wgw.vestapplication.net.NetConstant;
import com.wgw.vestapplication.net.retrofit.api.ApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

public class RetrofitUtils {
    private static RetrofitUtils utils;
    private final long CONNECT_TIME = 10;
    private final long READ_TIME = 10;
    private OkHttpClient mClient;
    private Retrofit mRetrofit;
    private RetrofitUtils(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                try{
                    String text = URLDecoder.decode(message,"utf-8");
                    Log.d("wgw_interceptor_log",text);
                }catch (UnsupportedEncodingException e){
                    e.printStackTrace();
                    Log.e("wgw_interceptor_log",e.getMessage());
                }
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME, TimeUnit.SECONDS)
                .readTimeout(READ_TIME, TimeUnit.SECONDS)
//                .addInterceptor(new HttpHeaderInterceptor())
                .addInterceptor(interceptor)
//                .addNetworkInterceptor(new HeadInterceptor) //加入head头
//                .cache() 设置缓存
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(NetConstant.BaseUrl)
                .client(mClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }
    private static class SingletonHolder{
        private static final RetrofitUtils INSTANCE = new RetrofitUtils();
    }
    public static RetrofitUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public <T> T createService(Class<T> clazz){
        return mRetrofit.create(clazz);
    }
}
