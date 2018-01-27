package com.ms.tjgf.mvp.tjcircle.dynamic.view;

import com.ms.tjgf.base.IBaseView;
import com.ms.tjgf.bean.DynamicBean;
import com.ms.tjgf.bean.DynamicData;

import java.util.List;

/**
 * 管理相关提示loading等
 */
public interface IDynamicListView extends IBaseView {
    void dismissRefreshView();

    void updateNewsList(List<DynamicData> newsList);
}
