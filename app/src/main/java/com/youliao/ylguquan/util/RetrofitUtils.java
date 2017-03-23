package com.youliao.ylguquan.util;

import com.youliao.ylguquan.api.ApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 基本数据请求工具类
 * Created by：hcs on 2016/10/17 15:15
 * e_mail：aaron1539@163.com
 */
public class RetrofitUtils {
    public static final String BASE_URL = ApiService.BASE_URL;
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;
    private ApiService retrofitService;
    private static RetrofitUtils INSTANCE;

    private RetrofitUtils(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        retrofitService = retrofit.create(ApiService.class);
    }

    public static RetrofitUtils getInstance(){
        if(INSTANCE == null){
            synchronized (RetrofitUtils.class){
                if(INSTANCE == null){
                    INSTANCE = new RetrofitUtils();
                }
            }
        }
        return INSTANCE;
    }
    public ApiService getRetrofit() {
        return retrofitService;
    }
}