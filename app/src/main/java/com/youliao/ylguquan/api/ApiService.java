package com.youliao.ylguquan.api;

import com.youliao.ylguquan.modle.MainModule;
import com.youliao.ylguquan.modle.Recommends;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by admin on 2017/3/21.
 */

public interface ApiService {
    String BASE_URL = "http://passport.youliao.com.cn/";
    String tag="ApiService...";
    //无参数
    @GET("users/stven0king/repos")
    Call<List<MainModule>> listRepos();
    //少数参数
    @GET("users/stven0king/repos")
    Call<List<MainModule>> listRepos(@Query("time") long time);
    //参数较多
    @GET("users/stven0king/repos")
    Call<List<MainModule>> listRepos(@QueryMap Map<String, String> params);

    //无参数
    @POST("users/stven0king/repos")
    Call<List<MainModule>> listReposPost();
    //少数参数
    @FormUrlEncoded
    @POST("users/stven0king/repos")
    Call<List<MainModule>> listReposPost(@Field("time") long time);
    //参数较多
    @FormUrlEncoded
    @POST("users/stven0king/repos")
    Call<List<MainModule>> listReposPost(@FieldMap Map<String, String> params);


    @POST("api.php/index/get_goods_recommend_v1")
    Observable<Recommends> getString();
}
