package com.ms.tjgf.mvp.curriculum.map;

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
 * Created by MissSekei on 2018/1/15.
 */

public class  MapActivity extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener, BDLocationListener, BaiduMap.OnMapLoadedCallback {

    private RadioGroup mRadioGroup;
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;


    //marker多添加
    private List<OverlayOptions> options = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_map;
    }

    @Override
    protected void initView() {
        super.initView();
        mMapView = findViewById(R.id.bmapview);
        mRadioGroup = findViewById(R.id.map_radio_group);
        mRadioGroup.setOnCheckedChangeListener(this);
        initMapStatus();
    }

    private void initMapStatus() {
        mBaiduMap = mMapView.getMap();
        //普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        // 设置可改变地图位置
        mBaiduMap.setMyLocationEnabled(true);
        //监听地图是否加载完成
        mBaiduMap.setOnMapLoadedCallback(this);
        // 不显示地图上比例尺
        mMapView.showScaleControl(false);
        // 不显示地图缩放控件（按钮控制栏）
        mMapView.showZoomControls(false);
        // 隐藏百度的LOGO
        View child = mMapView.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)) {
            child.setVisibility(View.INVISIBLE);
        }
        //默认首次位置加载，优化使用
        //MapStatus.Builder builder = new MapStatus.Builder();
        //builder.target(new LatLng(40.048424, 116.313513)).zoom(15);
        //mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
        mLocationClient = new LocationClient(getApplicationContext());//声明LocationClient类
        //配置定位SDK参数
        initLocation();
        //注册监听函数
        mLocationClient.registerLocationListener(this);
        //开启定位
        mLocationClient.start();
        //图片点击事件，回到定位点
        mLocationClient.requestLocation();
    }

    //选择位置
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.map_radio_pe:
                mBaiduMap.clear();
                markerMap();
                break;
            case R.id.map_radio_square:
                mBaiduMap.clear();
                markerMap();
                break;
            case R.id.map_radio_master:
                mBaiduMap.clear();
                markerMap();
                break;
        }
    }

    private void markerMap() {
        View view = LayoutInflater.from(this).inflate(R.layout.marker_view, null);
        TextView tv_num_price = view.findViewById(R.id.marker_name);
        tv_num_price.setText("张三丰");
        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromView(view);
        //定义Maker坐标点
        LatLng point1 = new LatLng(31.240766, 121.545113);
        LatLng point2 = new LatLng(31.240411, 121.541789);
        LatLng point3 = new LatLng(31.239562, 121.544214);
        LatLng point4 = new LatLng(31.237648, 121.542723);
        //构建MarkerOption，用于在地图上添加Marker,(效果：none无效果,drop下降,grow增长,jump跳跃)
        OverlayOptions option1 = new MarkerOptions().position(point1).icon(bitmap).perspective(true).animateType(MarkerOptions.MarkerAnimateType.jump);
        OverlayOptions option2 = new MarkerOptions().position(point2).icon(bitmap).perspective(true).animateType(MarkerOptions.MarkerAnimateType.jump);
        OverlayOptions option3 = new MarkerOptions().position(point3).icon(bitmap).perspective(true).animateType(MarkerOptions.MarkerAnimateType.jump);
        OverlayOptions option4 = new MarkerOptions().position(point4).icon(bitmap).perspective(true).animateType(MarkerOptions.MarkerAnimateType.jump);
        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);
        //在地图上批量添加
        mBaiduMap.addOverlays(options);
        //在地图上添加Marker，并显示
        //mBaiduMap.addOverlay(options);
    }

    //地图加载完成回调函数
    @Override
    public void onMapLoaded() {
        markerMap(); //marker标记
    }

    @Override
    public void onReceiveLocation(BDLocation location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        // 构造定位数据
        MyLocationData locData = new MyLocationData.Builder()
                .accuracy(location.getRadius())
                // 此处设置开发者获取到的方向信息，顺时针0-360
                .direction(100).latitude(location.getLatitude())
                .longitude(location.getLongitude()).build();
        // 设置定位数据
        mBaiduMap.setMyLocationData(locData);
        //把定位点再次显现出来
        MapStatus.Builder builder = new MapStatus.Builder();
        builder.target(latLng).zoom(17);
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(builder.build());
        mBaiduMap.animateMapStatus(mapStatusUpdate);
        // 当不需要定位图层时关闭定位图层
        //mBaiduMap.setMyLocationEnabled(false);
        StringBuffer sb = new StringBuffer(256);
        sb.append("time : ");
        sb.append(location.getTime());
        sb.append("\nerror code : ");
        sb.append(location.getLocType());
        sb.append("\nlatitude : ");
        sb.append(location.getLatitude());
        sb.append("\nlontitude : ");
        sb.append(location.getLongitude());
        sb.append("\nradius : ");
        sb.append(location.getRadius());
        if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
            sb.append("\nspeed : ");
            sb.append(location.getSpeed());// 单位：公里每小时
            sb.append("\nsatellite : ");
            sb.append(location.getSatelliteNumber());
            sb.append("\nheight : ");
            sb.append(location.getAltitude());// 单位：米
            sb.append("\ndirection : ");
            sb.append(location.getDirection());// 单位度
            sb.append("\naddr : ");
            sb.append(location.getAddrStr());
            sb.append("\ndescribe : ");
            sb.append("gps定位成功");
        } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
            sb.append("\naddr : ");
            sb.append(location.getAddrStr());
            //运营商信息
            sb.append("\noperationers : ");
            sb.append(location.getOperators());
            sb.append("\ndescribe : ");
            sb.append("网络定位成功");
        } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
            sb.append("\ndescribe : ");
            sb.append("离线定位成功，离线定位结果也是有效的");
        } else if (location.getLocType() == BDLocation.TypeServerError) {
            sb.append("\ndescribe : ");
            sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
        } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
            sb.append("\ndescribe : ");
            sb.append("网络不同导致定位失败，请检查网络是否通畅");
        } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
            sb.append("\ndescribe : ");
            sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
        }
        sb.append("\nlocationdescribe : ");
        sb.append(location.getLocationDescribe());// 位置语义化信息
        List<Poi> list = location.getPoiList();// POI数据
        if (list != null) {
            sb.append("\npoilist size = : ");
            sb.append(list.size());
            for (Poi p : list) {
                sb.append("\npoi= : ");
                sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
            }
        }
        Log.i("BaiduLocationApiDem", sb.toString());
    }

    //配置定位SDK参数
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation
        // .getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);
        option.setOpenGps(true); // 打开gps
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

}
