package com.ms.tjgf.mvp.tjcircle.dynamic.adapter;

import android.content.Context;
import android.view.View;

import com.donkingliang.labels.LabelsView;
import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.bean.DynamicBean;
import com.ms.tjgf.bean.DynamicData;
import com.ms.tjgf.widget.NineGridTestLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class DynamicAdapter extends QuickAdapter<DynamicData> {

    public DynamicAdapter(Context context, int layoutResId, List<DynamicData> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final DynamicData item) {
        helper.setImageUrl(R.id.user_img, item.getAvatar());
        helper.setText(R.id.body, item.getBody());
        helper.setText(R.id.created_at, item.getCreated_at());
        helper.setText(R.id.nickname, item.getNickname());
        helper.setText(R.id.num_praise, item.getNum_praise());
        helper.setText(R.id.num_favorite, item.getNum_favorite());
        helper.setText(R.id.num_reply, item.getNum_reply());
        //加载图片
        NineGridTestLayout mNine = helper.getView(R.id.layout_nine_grid);
        if (item.getPics().length != 0) {
            mNine.setVisibility(View.VISIBLE);
            mNine.setUrlList(Arrays.asList(item.getPics()));
        } else {
            mNine.setVisibility(View.GONE);
        }
        //标签加载
        LabelsView mLabels = helper.getView(R.id.dynamic_labels);
        if (item.getLabels_str().size() != 0 && item.getLabels_str() != null) {
            mLabels.setVisibility(View.VISIBLE);
            mLabels.setLabels(item.getLabels_str());
        } else {
            mLabels.setVisibility(View.GONE);
        }

    }

}
