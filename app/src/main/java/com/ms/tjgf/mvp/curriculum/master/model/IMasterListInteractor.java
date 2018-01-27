package com.ms.tjgf.mvp.curriculum.master.model;

import com.ms.tjgf.mvp.curriculum.master.HttpApiMaster;
import com.ms.tjgf.mvp.curriculum.master.persenter.MasterListPresenter;
import com.ms.tjgf.mvp.curriculum.outdoor.HttpApiOutDoor;
import com.ms.tjgf.mvp.curriculum.outdoor.persenter.OutDoorListPresenter;

/**
 * MissSekei 2018-1-22
 */
public interface IMasterListInteractor {
    void requestMasterList(HttpApiMaster object, String reqTag, MasterListPresenter callback);
}
