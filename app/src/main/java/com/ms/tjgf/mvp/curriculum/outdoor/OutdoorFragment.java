package com.ms.tjgf.mvp.curriculum.outdoor;


import android.view.View;
import android.widget.ListView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.OutDoorData;
import com.ms.tjgf.bean.PrivateSchoolData;
import com.ms.tjgf.mvp.curriculum.outdoor.adapter.OutdoorAdapter;
import com.ms.tjgf.bean.PrivateSchoolBean;
import com.ms.tjgf.mvp.curriculum.outdoor.persenter.OutDoorListPresenter;
import com.ms.tjgf.mvp.curriculum.outdoor.view.IOutDoorView;

import java.util.ArrayList;
import java.util.List;

/**
 * 室外课程
 * Created by MissSekei on 2018/1/12.
 */

public class OutdoorFragment extends BaseFragment implements IOutDoorView {
    private ListView mListView;
    private OutdoorAdapter mOutdoorAdapter;
    private List<OutDoorData> newsList = new ArrayList<>();
    private IBaseListPresenter iOutDoorListPresenter;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_outdoor;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mListView = view.findViewById(R.id.outdoor_list);
        iOutDoorListPresenter = new OutDoorListPresenter(this);
        //默认首次请求招式
        iOutDoorListPresenter.requestNewsList(true);
        mOutdoorAdapter = new OutdoorAdapter(getActivity(), R.layout.item_outdoor_list, newsList);
        mListView.setAdapter(mOutdoorAdapter);
    }

    @Override
    public void dismissRefreshView() {
        //swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateNewsList(List<OutDoorData> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        mOutdoorAdapter.notifyDataSetInvalidated(this.newsList);
        dismissRefreshView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        iOutDoorListPresenter.onDestroy();
    }
}
