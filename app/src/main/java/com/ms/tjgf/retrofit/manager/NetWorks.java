package com.ms.tjgf.retrofit.manager;

import com.ms.tjgf.bean.MsgStatus;
import com.ms.tjgf.bean.RespBean;
import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.mvp.curriculum.master.HttpApiMaster;
import com.ms.tjgf.mvp.curriculum.outdoor.HttpApiOutDoor;
import com.ms.tjgf.mvp.curriculum.privateschool.HttpApiPE;
import com.ms.tjgf.mvp.login.HttpApiLogin;
import com.ms.tjgf.mvp.pwd.HttpApiForget;
import com.ms.tjgf.mvp.pwd.HttpApiReset;
import com.ms.tjgf.mvp.register.HttpApiRegister;
import com.ms.tjgf.mvp.tjcircle.dynamicdetails.HttpApiComment;
import com.ms.tjgf.retrofit.apiservice.ApiService;
import com.ms.tjgf.retrofit.callback.RequestCallback;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by MissSekei on 2018/1/22.
 * 类描述：网络请求的操作类
 */
public class NetWorks extends RetrofitManager {
    protected static NetWorks mNetWorks = null;
    protected ApiService service = getRetrofit().create(ApiService.class);

    public static NetWorks getInstance() {
        if (mNetWorks == null) {
            synchronized (RetrofitManager.class) {
                if (mNetWorks == null) {
                    mNetWorks = new NetWorks();
                }
            }
        }
        return mNetWorks;
    }

    /**
     * 获取动态列表
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getDynamic(HttpListBean object, String reqTag, RequestCallback callBack) {
        setSubscribe(service.getDynamicService(object), reqTag, callBack);
    }

    /**
     * 获取视频列表
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getVideo(HttpListBean object, String reqTag, RequestCallback callBack) {
        setSubscribe(service.getVideoService(object), reqTag, callBack);
    }

    /**
     * 获取动态评论列表
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getComment(String id, HttpApiComment object, String reqTag, RequestCallback callBack) {
        setSubscribe(service.getCommentService(id, object), reqTag, callBack);
    }

    /**
     * 获取赛事列表
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getMatch(HttpListBean object, String reqTag, RequestCallback callBack) {
        setSubscribe(service.getMatchService(object), reqTag, callBack);
    }

    /**
     * 获取验证码
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getCode(String object, String reqTag, RequestCallback callBack) {
        setSubscribe(service.getCodeService(object), reqTag, callBack);
    }

    /**
     * 验证码登陆
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getLoginCode(HttpApiLogin object, String reqTag, RequestCallback callBack) {
        HttpApiLogin mLogin = object;
        setSubscribe(service.getLoginCodeService(mLogin.getUsername(), mLogin.getSms()), reqTag, callBack);
    }

    /**
     * 密码登陆
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getLoginPwd(HttpApiLogin object, String reqTag, RequestCallback callBack) {
        HttpApiLogin mLogin = object;
        setSubscribe(service.getLoginPwdService(mLogin.getUsername(), mLogin.getPassword()), reqTag, callBack);
    }


    /**
     * 注册获取验证码
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getRegisterCode(String object, String reqTag, RequestCallback callBack) {
        setSubscribe(service.getRegisterCodeService(object), reqTag, callBack);
    }

    /**
     * 忘记密码验证码
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getForgetCode(String object, String reqTag, RequestCallback callBack) {
        setSubscribe(service.getResetpasssmsService(object), reqTag, callBack);
    }

    /**
     * 用户账号注册
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getRegister(HttpApiRegister object, String reqTag, RequestCallback callBack) {
        HttpApiRegister httpApi = object;
        setSubscribe(service.getRegisterService(httpApi.getPhone(), httpApi.getSms(), httpApi.getPassword()), reqTag, callBack);
    }

    /**
     * 手机号码+code验证（重置密码）
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getForget(HttpApiForget object, String reqTag, RequestCallback callBack) {
        HttpApiForget httpApi = object;
        setSubscribe(service.getResetpasssmsverifyService(httpApi.getPhone(), httpApi.getSms()), reqTag, callBack);
    }

    /**
     * 重置密码
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getReset(HttpApiReset object, String reqTag, RequestCallback callBack) {
        HttpApiReset httpApi = object;
        setSubscribe(service.getResetPwdService(httpApi.getUsername(), httpApi.getPassword()), reqTag, callBack);
    }

    /**
     * 私教课列表
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getPE(HttpApiPE object, String reqTag, RequestCallback callBack) {
        //把参数封装到map中
        HashMap map = new HashMap<String, String>();
        map.put("page", object.getPage());
        map.put("type", object.getType());
        setSubscribe(service.getPEService(map), reqTag, callBack);
    }

    /**
     * 室外课列表
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getOutDoor(HttpApiOutDoor object, String reqTag, RequestCallback callBack) {
        setSubscribe(service.getOutDoorService(object), reqTag, callBack);
    }

    /**
     * 大师课列表
     *
     * @param object
     * @param reqTag
     * @param callBack
     */
    public void getMaster(HttpApiMaster object, String reqTag, RequestCallback callBack) {
        setSubscribe(service.getMasterService(object), reqTag, callBack);
    }

    /**
     * 获取自修课
     *
     * @param reqTag
     * @param callBack
     */
    public void getStudy(String reqTag, RequestCallback callBack) {
        setSubscribe(service.getStudyService(), reqTag, callBack);
    }


    /**
     * 插入观察者
     *
     * @param observable
     * @param reqTag
     * @param callBack
     * @param <T>
     */
    public <T> void setSubscribe(Observable<RespBean<T>> observable, String reqTag, RequestCallback callBack) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(new Observer<RespBean<T>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RespBean<T> t) {
                        if (t.getStatus() == 1) {//表示请求成功
                            callBack.onSuccess(t, reqTag);
                        } else {//表示请求失败

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
//                        //获取对应statusCode和Message
//                        ExceptionHandle.ResponeThrowable throwable = ExceptionHandle.handleException(e);
//                        callBack.onError(reqTag, throwable.code, throwable.message);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
