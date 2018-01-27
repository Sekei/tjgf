package com.ms.tjgf.mvp.login.model;

import com.ms.tjgf.mvp.login.HttpApiLogin;
import com.ms.tjgf.mvp.login.presenter.LoginPresenter;
import com.ms.tjgf.retrofit.manager.NetWorks;

/**
 * Created by MissSekei on 2018/1/24.
 */

public class LoginInteractor implements ILoginInteractor {

    //获取验证码
    @Override
    public void requestCode(String object, String reqTag, LoginPresenter callback) {
        NetWorks.getInstance().getCode(object, reqTag, callback);
    }

    //验证码登陆
    @Override
    public void requestLoginCode(HttpApiLogin object, String reqTag, LoginPresenter callback) {
        NetWorks.getInstance().getLoginCode(object, reqTag, callback);
    }

    //密码登陆
    @Override
    public void requestLoginPwd(HttpApiLogin object, String reqTag, LoginPresenter callback) {
        NetWorks.getInstance().getLoginPwd(object, reqTag, callback);
    }
}
