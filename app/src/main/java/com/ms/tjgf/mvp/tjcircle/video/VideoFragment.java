package com.ms.tjgf.mvp.tjcircle.video;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.tjcircle.video.adapter.VideoListAdapter;
import com.ms.tjgf.mvp.tjcircle.video.bean.VideoListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/15.
 */

public class VideoFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private GridView mGridView;
    private VideoListAdapter mVideoListAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        List<VideoListBean> arr = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            VideoListBean mVideoListBean = new VideoListBean();
            mVideoListBean.setId("11");
            arr.add(mVideoListBean);
        }
        mGridView = view.findViewById(R.id.video_gird);
        mVideoListAdapter = new VideoListAdapter(getActivity(), R.layout.item_video_grid, arr);
        mGridView.setAdapter(mVideoListAdapter);
        mGridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        
    }
}
