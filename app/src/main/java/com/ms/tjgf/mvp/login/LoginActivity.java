package com.ms.tjgf.mvp.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.ActionBarActivity;
import com.ms.tjgf.network.RfResultHandler;
import com.ms.tjgf.network.bean.RetrofitHttp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class LoginActivity extends ActionBarActivity {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.userpwd)
    EditText userpwd;
    @BindView(R.id.authcode)
    TextView authcode;
    @BindView(R.id.pwd_ll)
    LinearLayout pwdLl;
    @BindView(R.id.forgetpwd)
    TextView forgetpwd;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.register)
    Button register;
    @BindView(R.id.logo)
    ImageView logo;
    Unbinder butterBinder;
    String name;
    String pwd;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        butterBinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.username, R.id.userpwd, R.id.authcode, R.id.forgetpwd, R.id.login, R.id.register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.username:
                break;
            case R.id.userpwd:
                break;
            case R.id.authcode:
                break;
            case R.id.forgetpwd:
                break;
            case R.id.login:
                name = username.getText().toString().trim();
                pwd = userpwd.getText().toString().trim();
                getAreaProvinces();
                break;
            case R.id.register:
                break;
        }
    }

    public void login(){
        RetrofitHttp.getInstance().login(name,pwd)
                .compose(RfResultHandler.handleRespResult())
                .compose(RfResultHandler.transformer)
                .subscribe(login ->{
                    System.out.println(login);
                },throwable -> {
                    System.out.println(throwable.toString());
                });
    }

    public void getAreaProvinces(){
        RetrofitHttp.getInstance().getAreaProvince()
                .compose(RfResultHandler.handleRespResult())
                .compose(RfResultHandler.transformer)
                .subscribe(provinces ->{
                    System.out.println(provinces);
                },throwable -> {
                    System.out.println(throwable.toString());
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        butterBinder.unbind();
    }
}
