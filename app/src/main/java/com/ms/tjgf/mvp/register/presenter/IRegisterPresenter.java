package com.ms.tjgf.mvp.register.presenter;


public interface IRegisterPresenter {
    void doRegister(String userName, String pwd1, String pwd2, String code);

    void doRegisterCode(String phone);

    void onDestroy();

}
