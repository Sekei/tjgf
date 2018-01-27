package com.ms.tjgf.mvp.pwd.presenter;


public interface IForgetPresenter {
    void doForget(String userName, String code);

    void doForgetCode(String phone);

    void doReset(String username, String password1, String password2);

    void onDestroy();

}
