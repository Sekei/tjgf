package com.ms.tjgf.mvp.my;


import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import com.donkingliang.labels.LabelsView;
import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.login.LoginActivity;
import com.ms.tjgf.mvp.my.adapter.MyGridAdapter;
import com.ms.tjgf.mvp.my.collection.MyCollectionActivity;
import com.ms.tjgf.mvp.my.course.MyCourseActivity;
import com.ms.tjgf.mvp.my.userinfo.UserInfoActivity;
import com.ms.tjgf.mvp.tjcircle.video.adapter.VideoListAdapter;
import com.ms.tjgf.mvp.tjcircle.video.persenter.VideoListPresenter;
import com.ms.tjgf.widget.CustomGridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class MyFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private LabelsView mMyLabels;
    private CustomGridView mGridView;
    private MyGridAdapter mMyGridAdapter;
    private RelativeLayout mRlInfo;//个人信息


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }


    @Override
    protected void initView(View view) {
        super.initView(view);
        view.findViewById(R.id.mlogin_btn).setOnClickListener(this);
        mGridView = view.findViewById(R.id.my_gird);
        mMyGridAdapter = new MyGridAdapter(getActivity(), R.layout.item_my_grid);
        mGridView.setAdapter(mMyGridAdapter);
        mGridView.setOnItemClickListener(this);
        //标签加载
        mMyLabels = view.findViewById(R.id.myuser_labels);
        ArrayList<String> mList = new ArrayList<>();
        mList.add("传");
        mList.add("实");
        mList.add("名");
        mList.add("忠");
        mMyLabels.setLabels(mList);
        //个人信息
        mRlInfo = view.findViewById(R.id.rl_info);
        mRlInfo.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (position == 0) {
            startActivity(MyCourseActivity.class);
        } else if (position == 1) {

        } else if (position == 2) {
            startActivity(MyCollectionActivity.class);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mlogin_btn:
                startActivity(LoginActivity.class);
                break;
            case R.id.rl_info:
                startActivity(UserInfoActivity.class);
                break;
        }
    }
}
