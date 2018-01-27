package com.ms.tjgf.mvp.curriculum.outdoor.model;

import com.ms.tjgf.mvp.curriculum.outdoor.HttpApiOutDoor;
import com.ms.tjgf.mvp.curriculum.outdoor.persenter.OutDoorListPresenter;
import com.ms.tjgf.mvp.curriculum.privateschool.HttpApiPE;
import com.ms.tjgf.mvp.curriculum.privateschool.persenter.PEListPresenter;

/**
 * MissSekei 2018-1-22
 */
public interface IOutDoorListInteractor {
    void requestOutDoorList(HttpApiOutDoor object, String reqTag, OutDoorListPresenter callback);
}
