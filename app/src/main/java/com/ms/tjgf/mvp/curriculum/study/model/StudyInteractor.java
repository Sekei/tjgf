package com.ms.tjgf.mvp.curriculum.study.model;

import com.ms.tjgf.mvp.curriculum.study.persenter.StudyPresenter;
import com.ms.tjgf.retrofit.manager.NetWorks;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/26.
 */

public class StudyInteractor implements IStudyInteractor {
    @Override
    public void requestStudyList(String reqTag, StudyPresenter callback) {
        NetWorks.getInstance().getStudy(reqTag, callback);
    }
}
