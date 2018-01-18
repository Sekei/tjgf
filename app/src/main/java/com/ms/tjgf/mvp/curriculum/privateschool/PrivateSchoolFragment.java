package com.ms.tjgf.mvp.curriculum.privateschool;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.curriculum.privateschool.adapter.PrivateSchoolAdapter;
import com.ms.tjgf.mvp.curriculum.privateschool.bean.PrivateSchoolBean;
import com.ms.tjgf.mvp.curriculumdetails.SignUpActivity;
import com.ms.tjgf.mvp.tjcircle.dynamic.bean.DynamicBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class PrivateSchoolFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private PrivateSchoolAdapter mPrivateSchoolAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_privateschool;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mListView = view.findViewById(R.id.privateschool_list);
        List<PrivateSchoolBean> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            PrivateSchoolBean arr = new PrivateSchoolBean();
            arr.setId("11");
            data.add(arr);
        }
        mPrivateSchoolAdapter = new PrivateSchoolAdapter(getActivity(), R.layout.item_privateschool_list, data);
        mListView.setAdapter(mPrivateSchoolAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(SignUpActivity.class);
    }
}
