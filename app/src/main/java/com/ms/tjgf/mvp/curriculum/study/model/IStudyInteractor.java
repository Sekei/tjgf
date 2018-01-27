package com.ms.tjgf.mvp.curriculum.study.model;

import com.ms.tjgf.mvp.curriculum.outdoor.HttpApiOutDoor;
import com.ms.tjgf.mvp.curriculum.outdoor.persenter.OutDoorListPresenter;
import com.ms.tjgf.mvp.curriculum.study.persenter.StudyPresenter;

/**
 * MissSekei 2018-1-22
 */
public interface IStudyInteractor {
    void requestStudyList(String reqTag, StudyPresenter callback);
}
