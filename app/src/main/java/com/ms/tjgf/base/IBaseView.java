package com.ms.tjgf.base;

import android.app.Activity;

/**
 * 控制Toast、progress
 * MissSekei 2018-1-22
 */
public interface IBaseView {
    void showProgress();

    void hideProgress();

    void showToast(String content);

}
