package com.ms.tjgf.mvp;


import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ms.tjgf.R;
import com.ms.tjgf.base.ActionBarActivity;
import com.ms.tjgf.base.AppActionBarActivity;
import com.ms.tjgf.mvp.curriculum.CurriculumFragment;
import com.ms.tjgf.mvp.my.fragment.MyFragment;
import com.ms.tjgf.mvp.news.NewsFragment;
import com.ms.tjgf.mvp.tjcircle.TJCircleFragment;


public class HomeActivity extends AppActionBarActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mRadioGroup;
    private Fragment[] mFragmensts = new Fragment[4];
    private RadioButton mRadioButtonHome;
    private Fragment mFragment = null;
    //标记那个是否被选中，修改状态栏色彩
    private int mPosition = 0;

    @Override
    protected int getStatusBarTintResource() {
        if (mPosition == 0 || mPosition == 2) {
            return R.drawable.app_theme_bg;
        }
        return R.color.color_171717;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    protected void initView() {
        mFragmensts[0] = new CurriculumFragment();//课程
        mFragmensts[1] = new TJCircleFragment();//太极圈
        mFragmensts[2] = new NewsFragment();//消息
        mFragmensts[3] = new MyFragment();//我的
        mRadioGroup = findViewById(R.id.radio_group_button);
        mRadioButtonHome = findViewById(R.id.radio_button_home);
        mRadioGroup.setOnCheckedChangeListener(this);
        // 保证第一次会回调OnCheckedChangeListener
        mRadioButtonHome.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.radio_button_home:
                mPosition = 0;
                mFragment = mFragmensts[0];
                break;
            case R.id.radio_button_discovery:
                mPosition = 1;
                mFragment = mFragmensts[1];
                break;
            case R.id.radio_button_attention:
                mPosition = 2;
                mFragment = mFragmensts[2];
                break;
            case R.id.radio_button_profile:
                mPosition = 3;
                mFragment = mFragmensts[3];
                break;
        }
        if (mFragmensts != null) {
            //重新修改状态栏颜色
            applyKitKatTranslucency();
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, mFragment).commit();
        }
    }
}
