package com.ms.tjgf.mvp.my.collection.fragment;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.my.adapter.MyCourseAdapter;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class TeacherFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private ListView mCourseList;
    private MyCourseAdapter mMyCourseAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_course;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mCourseList = view.findViewById(R.id.my_course_list);
        mMyCourseAdapter = new MyCourseAdapter(getActivity(), R.layout.item_mycourse_list);
        mCourseList.setAdapter(mMyCourseAdapter);
        mCourseList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
