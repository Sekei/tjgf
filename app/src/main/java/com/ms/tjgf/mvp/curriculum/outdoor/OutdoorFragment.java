package com.ms.tjgf.mvp.curriculum.outdoor;


import android.view.View;
import android.widget.ListView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.curriculum.outdoor.adapter.OutdoorAdapter;
import com.ms.tjgf.mvp.curriculum.privateschool.adapter.PrivateSchoolAdapter;
import com.ms.tjgf.mvp.curriculum.privateschool.bean.PrivateSchoolBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 室外课程
 * Created by MissSekei on 2018/1/12.
 */

public class OutdoorFragment extends BaseFragment {
    private ListView mListView;
    private OutdoorAdapter mOutdoorAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_outdoor;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mListView = view.findViewById(R.id.outdoor_list);
        List<PrivateSchoolBean> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            PrivateSchoolBean arr = new PrivateSchoolBean();
            arr.setId("11");
            data.add(arr);
        }
        mOutdoorAdapter = new OutdoorAdapter(getActivity(), R.layout.item_outdoor_list, data);
        mListView.setAdapter(mOutdoorAdapter);
    }
}
