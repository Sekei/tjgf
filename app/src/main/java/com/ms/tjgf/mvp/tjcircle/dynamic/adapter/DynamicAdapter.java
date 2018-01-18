package com.ms.tjgf.mvp.tjcircle.dynamic.adapter;

import android.content.Context;

import com.donkingliang.labels.LabelsView;
import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.mvp.tjcircle.dynamic.bean.DynamicBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class DynamicAdapter extends QuickAdapter<DynamicBean> {

    public DynamicAdapter(Context context, int layoutResId, List<DynamicBean> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final DynamicBean item) {
//        helper.setText(R.id.userName, item.getUserName());
//        helper.setText(R.id.prizeTime, item.getPrizeTime());
//        ImageView userImg = helper.getView(R.id.user_img);
//        GlideImageUtils.with(context, AppPublicUtil.getUserUrl(item.getUserId()), userImg, true);
        //标签加载
        LabelsView labelsView=helper.getView(R.id.dynamic_labels);
        ArrayList<String> label = new ArrayList<>();
        label.add("前端");
        label.add("后台");
        label.add("微信开发");
        label.add("游戏开发");
        labelsView.setLabels(label);
    }

}
