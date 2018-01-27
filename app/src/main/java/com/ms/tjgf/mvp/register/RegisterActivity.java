package com.ms.tjgf.mvp.register;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.ActionBarActivity;
import com.ms.tjgf.mvp.login.presenter.ILoginPresenter;
import com.ms.tjgf.mvp.login.presenter.LoginPresenter;
import com.ms.tjgf.mvp.login.view.ILoginView;
import com.ms.tjgf.mvp.register.presenter.IRegisterPresenter;
import com.ms.tjgf.mvp.register.presenter.RegisterPresenter;
import com.ms.tjgf.mvp.register.view.IRegisterView;
import com.ms.tjgf.utils.CountTimer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by MissSekei on 2018/1/12.
 */

public class RegisterActivity extends ActionBarActivity implements IRegisterView {
    private TextView mRegiserCode;
    private IRegisterPresenter iRegisterPresenter;
    private EditText mPhone, mInputCode, mPwd1, mPwd2;
    private Button mBtnCode, mRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        super.initView();
        mRegiserCode = findViewById(R.id.register_code);
        mRegiserCode.setOnClickListener(this);
        mPhone = findViewById(R.id.username);
        mBtnCode = findViewById(R.id.register_code);//验证码
        mRegister = findViewById(R.id.register);//注册
        mRegister.setOnClickListener(this);
        mInputCode = findViewById(R.id.input_code);
        mPwd1 = findViewById(R.id.pwd1);
        mPwd2 = findViewById(R.id.pwd2);
        //先实例化控件再进行数据请求
        iRegisterPresenter = new RegisterPresenter(this, mBtnCode);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.register_code:
                iRegisterPresenter.doRegisterCode(mPhone.getText().toString().trim());
                break;
            case R.id.register:
                String PhoneStr = mPhone.getText().toString().trim();
                String CodeStr = mInputCode.getText().toString().trim();
                String PwdStr = mPwd1.getText().toString().trim();
                String Pwd2Str = mPwd2.getText().toString().trim();
                iRegisterPresenter.doRegister(PhoneStr, PwdStr, Pwd2Str, CodeStr);
                break;
        }
    }

    //注册成功
    @Override
    public void RegisterOK() {
       //直接开始调用账号登陆

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iRegisterPresenter.onDestroy();
    }
}
