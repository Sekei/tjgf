package com.ms.tjgf.mvp.curriculum.privateschool.persenter;

/**
 * 业务相关
 */
public interface IPEListPresenter {
    void requestNewsList(boolean isRefresh, String type);

    void onDestroy();
}
