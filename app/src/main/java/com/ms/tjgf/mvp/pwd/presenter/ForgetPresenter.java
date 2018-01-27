package com.ms.tjgf.mvp.pwd.presenter;

import android.text.TextUtils;
import android.widget.Button;

import com.ms.tjgf.base.BasePresenter;
import com.ms.tjgf.bean.RespBean;
import com.ms.tjgf.mvp.pwd.HttpApiForget;
import com.ms.tjgf.mvp.pwd.HttpApiReset;
import com.ms.tjgf.mvp.pwd.model.ForgetInteractor;
import com.ms.tjgf.mvp.pwd.view.IForgetView;
import com.ms.tjgf.mvp.register.HttpApiRegister;
import com.ms.tjgf.mvp.register.model.RegisterInteractor;
import com.ms.tjgf.mvp.register.view.IRegisterView;
import com.ms.tjgf.utils.Base64Utils;
import com.ms.tjgf.utils.CountTimer;
import com.ms.tjgf.utils.ToastUtils;


public class ForgetPresenter extends BasePresenter<IForgetView, RespBean> implements IForgetPresenter {

    private ForgetInteractor iForgetInteractor;
    private CountTimer countTimer;
    private Button mBtnCode;

    //用于重置密码
    public ForgetPresenter(IForgetView mView) {
        super(mView);
        iForgetInteractor = new ForgetInteractor();
    }

    //忘记密码验证码
    public ForgetPresenter(IForgetView mView, Button mBtnCode) {
        super(mView);
        iForgetInteractor = new ForgetInteractor();
        this.mBtnCode = mBtnCode;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (countTimer != null)
            countTimer.cancel();
    }

    @Override
    public void doForget(String userName, String code) {
        if (TextUtils.isEmpty(userName)) {
            mView.showToast("手机号码不能未空");
            return;
        }
        if (TextUtils.isEmpty(code)) {
            mView.showToast("手机验证码不能未空");
            return;
        }
        HttpApiForget mApiRg = new HttpApiForget(userName, code);
        iForgetInteractor.requestForget(mApiRg, "forget", this);
    }

    @Override
    public void doForgetCode(String phone) {
        if (TextUtils.isEmpty(phone)) {
            mView.showToast("请输入手机号码");
            return;
        }
        countTimer = new CountTimer(60000, 1000, mBtnCode);
        countTimer.start();//开启倒计时
        iForgetInteractor.requestForgetCode(phone, "code", this);
    }

    @Override
    public void doReset(String username, String password1, String password2) {
        if (TextUtils.isEmpty(username)) {
            mView.showToast("手机号码不能未空");
            return;
        }
        if (TextUtils.isEmpty(password1) || TextUtils.isEmpty(password1)) {
            mView.showToast("密码不能未空");
            return;
        }
        if (!password2.equals(password1)) {
            mView.showToast("两次输入密码不一致");
            return;
        }
        HttpApiReset mApiData = new HttpApiReset(username, password2);
        iForgetInteractor.requestRese(mApiData, "reset", this);
    }


    @Override
    public void onSuccess(RespBean data, String reqTag) {
        super.onSuccess(data, reqTag);
        ToastUtils.show(data.getMsg());
        if (reqTag.equals("reset")||reqTag.equals("forget")) {
            mView.onNextStep();
        }
    }
}
