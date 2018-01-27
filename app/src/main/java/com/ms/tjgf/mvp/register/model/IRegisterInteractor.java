package com.ms.tjgf.mvp.register.model;

import com.ms.tjgf.mvp.login.presenter.LoginPresenter;
import com.ms.tjgf.mvp.register.HttpApiRegister;
import com.ms.tjgf.mvp.register.presenter.RegisterPresenter;


public interface IRegisterInteractor {
    /**
     * 获取注册验证码
     *
     * @param object
     * @param reqTag
     * @param callback
     */
    void requestRegisterCode(String object, String reqTag, RegisterPresenter callback);

    /**
     * 注册账号
     *
     * @param object
     * @param reqTag
     * @param callback
     */
    void requestRegister(HttpApiRegister object, String reqTag, RegisterPresenter callback);
}
