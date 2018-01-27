package com.ms.tjgf.mvp.tjcircle.dynamicdetails.adapter;

import android.content.Context;
import android.view.View;

import com.donkingliang.labels.LabelsView;
import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.bean.CommentBean;
import com.ms.tjgf.bean.CommentListBean;
import com.ms.tjgf.bean.DynamicData;
import com.ms.tjgf.widget.NineGridTestLayout;

import java.util.Arrays;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class CommentListAdapter extends QuickAdapter<CommentListBean> {

    public CommentListAdapter(Context context, int layoutResId, List<CommentListBean> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final CommentListBean item) {
        helper.setImageUrl(R.id.user_img,item.getAvatar());
        helper.setText(R.id.nickname,item.getNickname());
        helper.setText(R.id.created_at,item.getCreated_at());
        helper.setText(R.id.body,item.getBody());
    }

}
