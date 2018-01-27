package com.ms.tjgf.base;

import android.view.View;

/**
 * 业务相关
 */
public interface IBaseListPresenter {
    void requestNewsList(boolean isRefresh);
    void onDestroy();
}
