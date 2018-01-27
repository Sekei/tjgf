package com.ms.tjgf.mvp.pwd.model;

import com.ms.tjgf.mvp.pwd.HttpApiForget;
import com.ms.tjgf.mvp.pwd.HttpApiReset;
import com.ms.tjgf.mvp.pwd.presenter.ForgetPresenter;
import com.ms.tjgf.mvp.register.HttpApiRegister;
import com.ms.tjgf.mvp.register.presenter.RegisterPresenter;
import com.ms.tjgf.retrofit.manager.NetWorks;

/**
 * Created by MissSekei on 2018/1/24.
 */

public class ForgetInteractor implements IForgetInteractor {
    @Override
    public void requestForgetCode(String object, String reqTag, ForgetPresenter callback) {
        NetWorks.getInstance().getForgetCode(object, reqTag, callback);
    }

    @Override
    public void requestForget(HttpApiForget object, String reqTag, ForgetPresenter callback) {
        NetWorks.getInstance().getForget(object, reqTag, callback);
    }

    @Override
    public void requestRese(HttpApiReset object, String reqTag, ForgetPresenter callback) {
        NetWorks.getInstance().getReset(object, reqTag, callback);
    }
}
