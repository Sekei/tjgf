package com.ms.tjgf.mvp.login.model;

import com.ms.tjgf.mvp.login.HttpApiLogin;
import com.ms.tjgf.mvp.login.presenter.LoginPresenter;


public interface ILoginInteractor {
    /**
     * 获取登陆验证码
     *
     * @param object
     * @param reqTag
     * @param callback
     */
    void requestCode(String object, String reqTag, LoginPresenter callback);

    /**
     * 验证码登陆
     *
     * @param object
     * @param reqTag
     * @param callback
     */
    void requestLoginCode(HttpApiLogin object, String reqTag, LoginPresenter callback);

    /**
     * 密码登陆
     *
     * @param object
     * @param reqTag
     * @param callback
     */
    void requestLoginPwd(HttpApiLogin object, String reqTag, LoginPresenter callback);
}
