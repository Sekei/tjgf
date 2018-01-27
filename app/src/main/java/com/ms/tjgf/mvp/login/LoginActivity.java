package com.ms.tjgf.mvp.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.ActionBarActivity;
import com.ms.tjgf.mvp.login.presenter.ILoginPresenter;
import com.ms.tjgf.mvp.login.presenter.LoginPresenter;
import com.ms.tjgf.mvp.login.view.ILoginView;
import com.ms.tjgf.mvp.pwd.ForgetPwdActivity;
import com.ms.tjgf.mvp.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by MissSekei on 2018/1/12.
 */

public class LoginActivity extends ActionBarActivity implements ILoginView {
    private ILoginPresenter iLoginPresenter;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.login_code)
    EditText userCode;
    @BindView(R.id.authcode)
    Button authcode;
    @BindView(R.id.forgetpwd)
    TextView forgetpwd;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.login_code_pwd)
    TextView mBtnLoginCodePwd;
    @BindView(R.id.login_pwd)
    EditText mLoginPwd;
    @BindView(R.id.code_ll)
    LinearLayout mCodell;

    Unbinder butterBinder;


    //修改顶部颜色值
    @Override
    protected int getStatusBarTintResource() {
        return R.color.color_0000;
    }

    @Override
    protected int getActionBarType() {
        return ACTIONBAR_DARK;//表示无顶部栏
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        butterBinder = ButterKnife.bind(this);
        iLoginPresenter = new LoginPresenter(this, authcode);
    }

    @OnClick({R.id.username, R.id.authcode, R.id.forgetpwd, R.id.login, R.id.register, R.id.login_code_pwd})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.authcode:
                iLoginPresenter.doCode(username.getText().toString().trim());
                break;
            case R.id.forgetpwd:
                startActivity(ForgetPwdActivity.class);
                break;
            case R.id.login:
                String name = username.getText().toString().trim();
                String pwd = mLoginPwd.getText().toString().trim();
                String code = userCode.getText().toString().trim();
                String btnCode = mBtnLoginCodePwd.getText().toString().trim();
                iLoginPresenter.doLogin(name, code, pwd, btnCode);
                break;
            case R.id.register:
                startActivity(RegisterActivity.class);
                break;
            case R.id.login_code_pwd:
                String msg = mBtnLoginCodePwd.getText().toString().trim();
                if (msg.equals(getResources().getString(R.string.login_pwd))) {
                    mBtnLoginCodePwd.setText(getResources().getString(R.string.login_code));
                    mCodell.setVisibility(View.GONE);
                    mLoginPwd.setVisibility(View.VISIBLE);
                } else {
                    mBtnLoginCodePwd.setText(getResources().getString(R.string.login_pwd));
                    mCodell.setVisibility(View.VISIBLE);
                    mLoginPwd.setVisibility(View.GONE);
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        butterBinder.unbind();
        iLoginPresenter.onDestroy();
    }
}
