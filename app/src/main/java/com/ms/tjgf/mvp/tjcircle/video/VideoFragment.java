package com.ms.tjgf.mvp.tjcircle.video;

import android.view.View;
import android.widget.AdapterView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.VideoListBean;
import com.ms.tjgf.mvp.tjcircle.video.adapter.VideoListAdapter;
import com.ms.tjgf.mvp.tjcircle.video.persenter.VideoListPresenter;
import com.ms.tjgf.mvp.tjcircle.video.view.IVideoListView;
import com.ms.tjgf.widget.CustomGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/15.
 */

public class VideoFragment extends BaseFragment implements AdapterView.OnItemClickListener, IVideoListView {
    private List<VideoListBean> newsList = new ArrayList<>();
    private CustomGridView mGridView;
    private VideoListAdapter mVideoListAdapter;
    private IBaseListPresenter iVideoListPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mGridView = view.findViewById(R.id.video_gird);
        iVideoListPresenter = new VideoListPresenter(this);
        iVideoListPresenter.requestNewsList(true);
        mVideoListAdapter = new VideoListAdapter(getActivity(), R.layout.item_video_grid, newsList);
        mGridView.setAdapter(mVideoListAdapter);
        mGridView.setOnItemClickListener(this);
    }

    @Override
    public void dismissRefreshView() {
        //swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateNewsList(List<VideoListBean> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        mVideoListAdapter.notifyDataSetInvalidated(this.newsList);
        dismissRefreshView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        iVideoListPresenter.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
