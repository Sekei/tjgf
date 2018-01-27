package com.ms.tjgf.mvp.pwd;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.ActionBarActivity;
import com.ms.tjgf.mvp.pwd.presenter.ForgetPresenter;
import com.ms.tjgf.mvp.pwd.presenter.IForgetPresenter;
import com.ms.tjgf.mvp.pwd.view.IForgetView;
import com.ms.tjgf.mvp.register.presenter.IRegisterPresenter;
import com.ms.tjgf.mvp.register.presenter.RegisterPresenter;
import com.ms.tjgf.mvp.register.view.IRegisterView;


/**
 * Created by MissSekei on 2018/1/12.
 */

public class ForgetPwdActivity extends ActionBarActivity implements IForgetView {

    private IForgetPresenter iForgetPresenter;
    private EditText mPhone, mInputCode;
    private Button mBtnCode, mRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forgetpwd;
    }

    @Override
    protected void initView() {
        super.initView();
        mPhone = findViewById(R.id.username);
        mBtnCode = findViewById(R.id.btncode);//验证码
        mBtnCode.setOnClickListener(this);
        mRegister = findViewById(R.id.register);//注册
        mRegister.setOnClickListener(this);
        mInputCode = findViewById(R.id.input_code);
        //先实例化控件再进行数据请求
        iForgetPresenter = new ForgetPresenter(this, mBtnCode);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.btncode:
                iForgetPresenter.doForgetCode(mPhone.getText().toString().trim());
                break;
            case R.id.register:
                String PhoneStr = mPhone.getText().toString().trim();
                String CodeStr = mInputCode.getText().toString().trim();
                iForgetPresenter.doForget(PhoneStr, CodeStr);
                break;
        }
    }

    @Override
    public void onNextStep() {
        startActivity(ResetPwdActivity.class, mPhone.getText().toString().trim());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iForgetPresenter.onDestroy();
    }
}
