package com.ms.tjgf.mvp.login.presenter;

import android.text.TextUtils;
import android.widget.Button;

import com.ms.tjgf.R;
import com.ms.tjgf.MyApp;
import com.ms.tjgf.base.BasePresenter;
import com.ms.tjgf.bean.RespBean;
import com.ms.tjgf.mvp.login.HttpApiLogin;
import com.ms.tjgf.mvp.login.model.LoginInteractor;
import com.ms.tjgf.mvp.login.view.ILoginView;
import com.ms.tjgf.utils.CountTimer;


public class LoginPresenter extends BasePresenter<ILoginView, RespBean> implements ILoginPresenter {
    private CountTimer countTimer;
    private LoginInteractor iLoginInteractor;
    private Button mBtnCode;

    public LoginPresenter(ILoginView mView, Button mBtnCode) {
        super(mView);
        iLoginInteractor = new LoginInteractor();
        this.mBtnCode = mBtnCode;
    }

    /**
     * 验证码--密码登陆
     *
     * @param userName
     * @param code
     * @param password
     * @param type     登陆方式判断
     */
    @Override
    public void doLogin(String userName, String code, String password, String type) {
        if (type.equals(MyApp.getInstance().getResources().getString(R.string.login_code))) {
            if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
                mView.showToast("请输入用户名和密码");
                return;
            }
            iLoginInteractor.requestLoginPwd(new HttpApiLogin(userName, code, password), "login_pwd", this);
        } else {
            if (TextUtils.isEmpty(code)) {
                mView.showToast("请输入登陆验证码");
                return;
            }
            iLoginInteractor.requestLoginCode(new HttpApiLogin(userName, code, password), "login_code", this);
        }
    }

    /**
     * 获取登陆验证码
     *
     * @param phone
     */
    @Override
    public void doCode(String phone) {
        if (TextUtils.isEmpty(phone)) {
            mView.showToast("请输入手机号码");
            return;
        }
        countTimer = new CountTimer(60000, 1000, mBtnCode);
        countTimer.start();//开启倒计时
        iLoginInteractor.requestCode(phone, "code", this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (countTimer != null)
            countTimer.cancel();
    }

    @Override
    public void onSuccess(RespBean data, String reqTag) {
        super.onSuccess(data, reqTag);
    }

}
