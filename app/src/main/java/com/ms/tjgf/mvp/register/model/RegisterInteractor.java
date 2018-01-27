package com.ms.tjgf.mvp.register.model;

import com.ms.tjgf.mvp.login.presenter.LoginPresenter;
import com.ms.tjgf.mvp.register.HttpApiRegister;
import com.ms.tjgf.mvp.register.presenter.RegisterPresenter;
import com.ms.tjgf.retrofit.manager.NetWorks;

/**
 * Created by MissSekei on 2018/1/24.
 */

public class RegisterInteractor implements IRegisterInteractor {
    @Override
    public void requestRegisterCode(String object, String reqTag, RegisterPresenter callback) {
        NetWorks.getInstance().getRegisterCode(object, reqTag, callback);
    }

    @Override
    public void requestRegister(HttpApiRegister object, String reqTag, RegisterPresenter callback) {
        NetWorks.getInstance().getRegister(object, reqTag, callback);
    }
}
