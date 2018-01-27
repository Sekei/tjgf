package com.ms.tjgf.mvp.tjcircle.dynamic;


import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.bean.DynamicBean;
import com.ms.tjgf.bean.DynamicData;
import com.ms.tjgf.mvp.tjcircle.dynamic.adapter.DynamicAdapter;
import com.ms.tjgf.mvp.tjcircle.dynamic.persenter.DynamicListPresenter;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.mvp.tjcircle.dynamic.view.IDynamicListView;
import com.ms.tjgf.mvp.tjcircle.dynamicdetails.DynamicDetailsActivity;
import com.ms.tjgf.widget.PublishPopWin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class DynamicFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener, IDynamicListView, SwipeRefreshLayout.OnRefreshListener {
    private IBaseListPresenter iDynamicListPresenter;
    private List<DynamicData> newsList = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private DynamicBean mDynamicData;
    private ListView mDynamicList;
    private DynamicAdapter mDynamicAdapter;
    private ImageView mBtnPublish;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dynamic;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mDynamicList = view.findViewById(R.id.dynamic_list);
        mBtnPublish = view.findViewById(R.id.btn_publish);
        mBtnPublish.setOnClickListener(this);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light, android.R.color.holo_blue_light);
        swipeRefreshLayout.setOnRefreshListener(this);
        iDynamicListPresenter = new DynamicListPresenter(this);
        iDynamicListPresenter.requestNewsList(true);
        mDynamicAdapter = new DynamicAdapter(getActivity(), R.layout.item_dynamic_list, newsList);
        mDynamicList.setAdapter(mDynamicAdapter);
        mDynamicList.setOnItemClickListener(this);
    }

    @Override
    public void onRefresh() {
        iDynamicListPresenter.requestNewsList(true);
    }

    @Override
    public void dismissRefreshView() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateNewsList(List<DynamicData> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        mDynamicAdapter.notifyDataSetInvalidated(this.newsList);
        dismissRefreshView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        iDynamicListPresenter.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        DynamicData data = newsList.get(i);
        startActivity(DynamicDetailsActivity.class, data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_publish:
                PublishPopWin takePhotoPopWin = new PublishPopWin(getActivity());
                takePhotoPopWin.showAtLocation(view, Gravity.BOTTOM, 0, 0);
                break;
        }
    }
}
