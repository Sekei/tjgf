package com.ms.tjgf.utils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;

/**
 * Created by MissSekei on 2018/1/24.
 */

public class CountTimer extends CountDownTimer {
    private Button btnCaptcha;

    public CountTimer(long millisInFuture, long countDownInterval, Button btnCaptcha) {
        super(millisInFuture, countDownInterval);
        this.btnCaptcha = btnCaptcha;
    }

    /**
     * 倒计时过程中调用
     *
     * @param millisUntilFinished
     */
    @Override
    public void onTick(long millisUntilFinished) {
        btnCaptcha.setText(millisUntilFinished / 1000 + "s");
        //设置倒计时中的按钮外观
        btnCaptcha.setClickable(false);//倒计时过程中将按钮设置为不可点击
    }

    /**
     * 倒计时完成后调用
     */
    @Override
    public void onFinish() {
        //设置倒计时结束之后的按钮样式
        btnCaptcha.setText("获取验证码");
        btnCaptcha.setClickable(true);
    }

}
