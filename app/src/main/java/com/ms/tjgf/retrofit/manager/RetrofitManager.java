package com.ms.tjgf.retrofit.manager;


import com.ms.tjgf.retrofit.utlis.OkHttp3Utils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public abstract class RetrofitManager {
    // 获取Retrofit对象
    protected Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HostManager.getHost())//指定host
                .client(OkHttp3Utils.getOkHttpClient())//指定OKHttpClient
                .addConverterFactory(GsonConverterFactory.create())//指定转换器，不同的网络请求API规范可自定义转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return retrofit;
    }
}
