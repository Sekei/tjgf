package com.ms.tjgf.mvp.curriculum.study.view;

import com.ms.tjgf.base.IBaseView;
import com.ms.tjgf.bean.OutDoorData;
import com.ms.tjgf.bean.StudyBean;
import com.ms.tjgf.bean.StudyFactionBean;

import java.util.List;


public interface IStudyView extends IBaseView {
    void dismissRefreshView();

    void updateNewsList(List<StudyFactionBean> newsList);
}
