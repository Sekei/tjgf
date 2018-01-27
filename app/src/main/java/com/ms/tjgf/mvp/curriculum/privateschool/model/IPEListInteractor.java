package com.ms.tjgf.mvp.curriculum.privateschool.model;

import com.ms.tjgf.bean.HttpListBean;
import com.ms.tjgf.mvp.curriculum.privateschool.HttpApiPE;
import com.ms.tjgf.mvp.curriculum.privateschool.persenter.PEListPresenter;
import com.ms.tjgf.mvp.tjcircle.dynamic.persenter.DynamicListPresenter;

/**
 * MissSekei 2018-1-22
 */
public interface IPEListInteractor {
    void requestPEList(HttpApiPE object, String reqTag, PEListPresenter callback);
}
