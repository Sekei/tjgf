package com.ms.tjgf.mvp.curriculum.master;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.MasterData;
import com.ms.tjgf.mvp.curriculum.master.activity.MasterCurriculumActivity;
import com.ms.tjgf.mvp.curriculum.master.adapter.MasterAdapter;
import com.ms.tjgf.mvp.curriculum.master.persenter.MasterListPresenter;
import com.ms.tjgf.mvp.curriculum.master.view.IMasterView;

import java.util.ArrayList;
import java.util.List;

/**
 * 大师课程
 * Created by MissSekei on 2018/1/12.
 */

public class MasterFragment extends BaseFragment implements AdapterView.OnItemClickListener, IMasterView {
    private ListView mListView;
    private MasterAdapter mMasterAdapter;
    private List<MasterData> newsList = new ArrayList<>();
    private IBaseListPresenter iMasterListPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_master;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mListView = view.findViewById(R.id.master_list);
        iMasterListPresenter = new MasterListPresenter(this);
        //默认首次请求招式
        iMasterListPresenter.requestNewsList(true);
        mMasterAdapter = new MasterAdapter(getActivity(), R.layout.item_master_list, newsList);
        mListView.setAdapter(mMasterAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void dismissRefreshView() {
        //swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateNewsList(List<MasterData> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        mMasterAdapter.notifyDataSetInvalidated(this.newsList);
        dismissRefreshView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        iMasterListPresenter.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(MasterCurriculumActivity.class);
    }
}
