package com.ms.tjgf.retrofit.apiservice;


import com.ms.tjgf.bean.CodeBean;
import com.ms.tjgf.bean.CommentBean;
import com.ms.tjgf.bean.DynamicBean;
import com.ms.tjgf.bean.MasterBean;
import com.ms.tjgf.bean.MatchBean;
import com.ms.tjgf.bean.MsgStatus;
import com.ms.tjgf.bean.OutDoorBean;
import com.ms.tjgf.bean.PrivateSchoolBean;
import com.ms.tjgf.bean.RespBean;
import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.bean.StudyBean;
import com.ms.tjgf.bean.VideoBean;
import com.ms.tjgf.mvp.curriculum.master.HttpApiMaster;
import com.ms.tjgf.mvp.curriculum.outdoor.HttpApiOutDoor;
import com.ms.tjgf.mvp.curriculum.privateschool.HttpApiPE;
import com.ms.tjgf.mvp.register.HttpApiRegister;
import com.ms.tjgf.mvp.tjcircle.dynamicdetails.HttpApiComment;

import org.w3c.dom.Comment;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * api请求管理
 */
public interface ApiService {
    //动态接口
    @POST("blog/home/")
    Observable<RespBean<DynamicBean>> getDynamicService(@Body HttpListBean dynamic);

    //视频列表
    @POST("blog/video/")
    Observable<RespBean<VideoBean>> getVideoService(@Body HttpListBean video);

    //赛事列表
    @POST("blog/competition/")
    Observable<RespBean<MatchBean>> getMatchService(@Body HttpListBean match);

    //获取动态评论
    @POST("blog/comment/{id}")
    Observable<RespBean<CommentBean>> getCommentService(@Path("id") String id, @Body HttpApiComment match);

    //验证码登陆获取
    @FormUrlEncoded
    @POST("passport/loginsms/")
    Observable<RespBean<String>> getCodeService(@Field("phone") String phone);

    //验证码登陆
    @FormUrlEncoded
    @POST("passport/login/")
    Observable<RespBean<String>> getLoginCodeService(@Field("username") String username, @Field("sms") String sms);

    //密码登陆
    @FormUrlEncoded
    @POST("passport/login/")
    Observable<RespBean<String>> getLoginPwdService(@Field("username") String username, @Field("password") String password);

    //注册验证码获取
    @FormUrlEncoded
    @POST("passport/registersms/")
    Observable<RespBean<String>> getRegisterCodeService(@Field("phone") String phone);

    //用户账号注册
    @FormUrlEncoded
    @POST("passport/register/")
    Observable<RespBean<String>> getRegisterService(@Field("phone") String phone, @Field("sms") String sms, @Field("password") String password);

    //忘记密码验证码获取
    @FormUrlEncoded
    @POST("passport/resetpasssms/")
    Observable<RespBean<String>> getResetpasssmsService(@Field("phone") String phone);

    //忘记密码手机号+code验证
    @FormUrlEncoded
    @POST("passport/resetpasssmsverify/")
    Observable<RespBean<String>> getResetpasssmsverifyService(@Field("phone") String phone, @Field("sms") String sms);

    //重置密码
    @FormUrlEncoded
    @POST("passport/resetpassupdate/")
    Observable<RespBean<String>> getResetPwdService(@Field("username") String username, @Field("password") String password);

    //私教课列表
    @FormUrlEncoded
    @POST("course/personal/")
    Observable<RespBean<PrivateSchoolBean>> getPEService(@FieldMap Map<String, String> map);

    //室外课列表
    @POST("course/outdoor/")
    Observable<RespBean<OutDoorBean>> getOutDoorService(@Body HttpApiOutDoor outdoor);

    //大师课列表
    @POST("course/master/")
    Observable<RespBean<MasterBean>> getMasterService(@Body HttpApiMaster outdoor);

    //太极自修课
    @POST(" course/selfstudyindex/")
    Observable<RespBean<StudyBean>> getStudyService();


}
