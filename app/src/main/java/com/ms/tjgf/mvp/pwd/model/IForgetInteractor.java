package com.ms.tjgf.mvp.pwd.model;

import com.ms.tjgf.mvp.pwd.HttpApiForget;
import com.ms.tjgf.mvp.pwd.HttpApiReset;
import com.ms.tjgf.mvp.pwd.presenter.ForgetPresenter;
import com.ms.tjgf.mvp.register.HttpApiRegister;
import com.ms.tjgf.mvp.register.presenter.RegisterPresenter;


public interface IForgetInteractor {
    /**
     * 忘记密码验证码
     *
     * @param object
     * @param reqTag
     * @param callback
     */
    void requestForgetCode(String object, String reqTag, ForgetPresenter callback);

    /**
     * 忘记密码
     *
     * @param object
     * @param reqTag
     * @param callback
     */
    void requestForget(HttpApiForget object, String reqTag, ForgetPresenter callback);

    /**
     * 重置密码
     *
     * @param object
     * @param reqTag
     * @param callback
     */
    void requestRese(HttpApiReset object, String reqTag, ForgetPresenter callback);

}
