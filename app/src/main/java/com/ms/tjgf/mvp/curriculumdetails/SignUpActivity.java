package com.ms.tjgf.mvp.curriculumdetails;

import android.support.annotation.IdRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ZoomControls;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.ms.tjgf.R;
import com.ms.tjgf.base.ActionBarActivity;
import com.ms.tjgf.widget.PileLayout;
import com.ms.tjgf.widget.roundimage.CircleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/15.
 */

public class SignUpActivity extends ActionBarActivity {
    private PileLayout mPileLayout;
    private Button mSignUpBtn;

    String[] urls = {"http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg"
    };


    //修改顶部颜色值
    @Override
    protected int getStatusBarTintResource() {
        return R.color.color_0000;
    }

    @Override
    protected int getActionBarType() {
        return ACTIONBAR_DARK;//透明top
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_signup;
    }

    @Override
    protected void initView() {
        super.initView();
        mPileLayout = findViewById(R.id.pile_layout);
        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < urls.length; i++) {
            CircleImageView imageView = (CircleImageView) inflater.inflate(R.layout.item_praise, mPileLayout, false);
            Glide.with(this).load(urls[i]).into(imageView);
            mPileLayout.addView(imageView);
        }
        mSignUpBtn = findViewById(R.id.signup_btn);
        mSignUpBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.signup_btn:
                startActivity(CurriculumDetailsActivity.class);
                break;
        }
    }
}
