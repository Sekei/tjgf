package com.ms.tjgf.mvp.register.presenter;

import android.text.TextUtils;
import android.widget.Button;

import com.ms.tjgf.base.BasePresenter;
import com.ms.tjgf.bean.RespBean;
import com.ms.tjgf.mvp.login.model.LoginInteractor;
import com.ms.tjgf.mvp.login.view.ILoginView;
import com.ms.tjgf.mvp.register.HttpApiRegister;
import com.ms.tjgf.mvp.register.model.RegisterInteractor;
import com.ms.tjgf.mvp.register.view.IRegisterView;
import com.ms.tjgf.utils.Base64Utils;
import com.ms.tjgf.utils.CountTimer;
import com.ms.tjgf.utils.ToastUtils;


public class RegisterPresenter extends BasePresenter<IRegisterView, RespBean> implements IRegisterPresenter {

    private RegisterInteractor iRegisterInteractor;
    private CountTimer countTimer;
    private Button mBtnCode;

    public RegisterPresenter(IRegisterView mView, Button mBtnCode) {
        super(mView);
        iRegisterInteractor = new RegisterInteractor();
        this.mBtnCode = mBtnCode;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (countTimer != null)
            countTimer.cancel();
    }

    @Override
    public void doRegister(String userName, String pwd1, String pwd2, String code) {
        if (TextUtils.isEmpty(userName)) {
            mView.showToast("手机号码不能未空");
            return;
        }
        if (TextUtils.isEmpty(pwd1) || TextUtils.isEmpty(pwd2)) {
            mView.showToast("请输入账号密码");
            return;
        }
        if (!pwd1.equals(pwd2)) {
            mView.showToast("两次密码输入不一致");
            return;
        }
        if (TextUtils.isEmpty(code)) {
            mView.showToast("手机验证码不能未空");
            return;
        }
        HttpApiRegister mApiRg = new HttpApiRegister(userName, code, Base64Utils.getBase64("taiji" + pwd2 + "2018"));
        iRegisterInteractor.requestRegister(mApiRg, "register", this);
    }

    @Override
    public void doRegisterCode(String phone) {
        if (TextUtils.isEmpty(phone)) {
            mView.showToast("请输入手机号码");
            return;
        }
        countTimer = new CountTimer(60000, 1000, mBtnCode);
        countTimer.start();//开启倒计时
        iRegisterInteractor.requestRegisterCode(phone, "code", this);
    }

    @Override
    public void onSuccess(RespBean data, String reqTag) {
        super.onSuccess(data, reqTag);
        ToastUtils.show(data.getMsg());
        if (reqTag.equals("register")) {
            mView.RegisterOK();
        }
    }
}
