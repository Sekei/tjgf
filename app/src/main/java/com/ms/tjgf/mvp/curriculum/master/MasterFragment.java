package com.ms.tjgf.mvp.curriculum.master;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.curriculum.master.activity.MasterCurriculumActivity;
import com.ms.tjgf.mvp.curriculum.master.adapter.MasterAdapter;
import com.ms.tjgf.mvp.curriculum.master.bean.MasterBean;
import com.ms.tjgf.mvp.curriculum.outdoor.adapter.OutdoorAdapter;
import com.ms.tjgf.mvp.curriculum.privateschool.bean.PrivateSchoolBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 大师课程
 * Created by MissSekei on 2018/1/12.
 */

public class MasterFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private MasterAdapter mMasterAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_master;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mListView = view.findViewById(R.id.master_list);
        List<MasterBean> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new MasterBean("10"));
        }
        mMasterAdapter = new MasterAdapter(getActivity(), R.layout.item_master_list, data);
        mListView.setAdapter(mMasterAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(MasterCurriculumActivity.class);
    }
}
