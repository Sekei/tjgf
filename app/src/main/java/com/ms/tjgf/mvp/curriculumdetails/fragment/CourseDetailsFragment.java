package com.ms.tjgf.mvp.curriculumdetails.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.curriculumdetails.CurriculumPlayActivity;
import com.ms.tjgf.mvp.curriculumdetails.adapter.CourseDetailsAdapter;
import com.ms.tjgf.mvp.curriculumdetails.bean.CourseDetailsBean;
import com.ms.tjgf.widget.CustomListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程详情相关
 * Created by MissSekei on 2018/1/17.
 */

public class CourseDetailsFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private CustomListView mCustomListView;
    private CourseDetailsAdapter mCourseDetailsAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_coursedetails;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mCustomListView = view.findViewById(R.id.coursedetails_list);
        List<CourseDetailsBean> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new CourseDetailsBean("11"));
        }
        mCourseDetailsAdapter = new CourseDetailsAdapter(getActivity(), R.layout.item_coursedetails, data);
        mCustomListView.setAdapter(mCourseDetailsAdapter);
        mCustomListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(CurriculumPlayActivity.class);
    }
}
