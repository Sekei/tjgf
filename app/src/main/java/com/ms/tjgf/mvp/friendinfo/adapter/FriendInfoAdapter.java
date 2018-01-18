package com.ms.tjgf.mvp.friendinfo.adapter;

import android.content.Context;

import com.donkingliang.labels.LabelsView;
import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.mvp.curriculum.privateschool.bean.PrivateSchoolBean;
import com.ms.tjgf.mvp.friendinfo.bean.FriendInfoBean;
import com.ms.tjgf.widget.NineGridTestLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class FriendInfoAdapter extends QuickAdapter<FriendInfoBean> {

    public FriendInfoAdapter(Context context, int layoutResId, List<FriendInfoBean> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final FriendInfoBean item) {
        ArrayList<String> listUrl = new ArrayList<>();
        listUrl.add("http://img2.imgtn.bdimg.com/it/u=1006187901,4223500905&fm=27&gp=0.jpg");
        listUrl.add("http://img1.imgtn.bdimg.com/it/u=695237186,1353057623&fm=27&gp=0.jpg");
        listUrl.add("http://img3.imgtn.bdimg.com/it/u=1023551729,972800410&fm=27&gp=0.jpg");
        listUrl.add("http://img3.imgtn.bdimg.com/it/u=1023551729,972800410&fm=27&gp=0.jpg");
        ((NineGridTestLayout) helper.getView(R.id.layout_nine_grid)).setUrlList(listUrl);
        //标签加载
        LabelsView labelsView = helper.getView(R.id.dynamic_labels);
        ArrayList<String> label = new ArrayList<>();
        label.add("太极拳");
        label.add("上海");
        label.add("冬天");
        labelsView.setLabels(label);
    }

}
