package com.ms.tjgf.network;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by fangt on 2018/1/18.
 */

public interface IHttp {
    @POST("/v1/login")
    @FormUrlEncoded
    rx.Observable<RespBean> login(@Field("username") String username,@Field("password")String pwd);

    @POST("/v1/area/provinces")
    rx.Observable<RespBean> getAreaProvince();
}
