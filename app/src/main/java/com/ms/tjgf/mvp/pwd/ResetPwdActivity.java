package com.ms.tjgf.mvp.pwd;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ms.tjgf.R;
import com.ms.tjgf.base.ActionBarActivity;
import com.ms.tjgf.mvp.pwd.presenter.ForgetPresenter;
import com.ms.tjgf.mvp.pwd.presenter.IForgetPresenter;
import com.ms.tjgf.mvp.pwd.view.IForgetView;


/**
 * Created by MissSekei on 2018/1/12.
 */

public class ResetPwdActivity extends ActionBarActivity implements IForgetView {
    private EditText mPhone, mInputCode;
    private Button mCommit;
    private IForgetPresenter iForgetPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_resetpwd;
    }

    @Override
    protected void initView() {
        super.initView();
        mPhone = findViewById(R.id.username);
        mCommit = findViewById(R.id.commit);//注册
        mCommit.setOnClickListener(this);
        mInputCode = findViewById(R.id.input_code);
        //先实例化控件再进行数据请求
        iForgetPresenter = new ForgetPresenter(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.commit:
                String PhoneStr = mPhone.getText().toString().trim();
                String CodeStr = mInputCode.getText().toString().trim();
                iForgetPresenter.doReset(getIntentObject(String.class), PhoneStr, CodeStr);
                break;
        }
    }

    //重置成功，直接登陆
    @Override
    public void onNextStep() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iForgetPresenter.onDestroy();
    }
}
