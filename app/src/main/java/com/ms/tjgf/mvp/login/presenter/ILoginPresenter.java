package com.ms.tjgf.mvp.login.presenter;

/**
 * Created by YCY.
 */
public interface ILoginPresenter {
    void doLogin(String userName, String code, String password, String type);

    void doCode(String phone);

    void onDestroy();
}
