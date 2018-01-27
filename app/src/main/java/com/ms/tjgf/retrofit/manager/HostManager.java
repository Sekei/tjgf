package com.ms.tjgf.retrofit.manager;


import com.ms.tjgf.retrofit.utlis.AppConfig;

/**
 * api服务器地址请求
 * MissSekei 2018-1-22
 */
public class HostManager {
    private static boolean isDebugHost = AppConfig.isDebug();
    //正式环境host
    private static String hostRelease = "http://10.0.0.186/v1/";
    //测试环境host
    private static String hostDebug = "http://10.0.0.186/v1/";
    public static final int HTTP_CONNECT_TIMEOUT = 10000;
    public static final String CLIENT_KEY = "21bdf6b01c449951";
    public static final String CLIENT_SALT = "menshen_2018";
    //public static final String TEST_URL = "http://api.taiji.com/v1";
    public static final String TEST_URL = "http://10.0.0.186";

    public static String getHost() {
        return isDebugHost ? hostDebug : hostRelease;
    }
}
