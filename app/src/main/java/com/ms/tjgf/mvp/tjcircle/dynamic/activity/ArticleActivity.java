package com.ms.tjgf.mvp.tjcircle.dynamic.activity;

import android.support.annotation.IdRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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
import com.ms.tjgf.R;
import com.ms.tjgf.base.ActionBarActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 发表文章
 * Created by MissSekei on 2018/1/15.
 */

public class ArticleActivity extends ActionBarActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_article;
    }

    @Override
    protected void initView() {
        super.initView();

    }
}
