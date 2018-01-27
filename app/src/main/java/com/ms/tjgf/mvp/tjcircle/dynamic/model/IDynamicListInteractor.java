package com.ms.tjgf.mvp.tjcircle.dynamic.model;

import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.mvp.tjcircle.dynamic.persenter.DynamicListPresenter;

/**
 * MissSekei 2018-1-22
 */
public interface IDynamicListInteractor {
    void requestDynamicList(HttpListBean object, String reqTag, DynamicListPresenter callback);
}
