package com.ms.tjgf.mvp.tjcircle.video.adapter;

import android.content.Context;

import com.donkingliang.labels.LabelsView;
import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.bean.VideoListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class VideoListAdapter extends QuickAdapter<VideoListBean> {

    public VideoListAdapter(Context context, int layoutResId, List<VideoListBean> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final VideoListBean item) {
        helper.setImageUrl(R.id.video_img, item.getPics());
        helper.setText(R.id.video_title, item.getTitle());
        helper.setText(R.id.video_nickname, item.getNickname());
        helper.setText(R.id.video_favorite, item.getNum_favorite());
    }

}
