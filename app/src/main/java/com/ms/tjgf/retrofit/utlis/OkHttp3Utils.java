package com.ms.tjgf.retrofit.utlis;

import android.util.Log;


import com.ms.tjgf.MyApp;
import com.ms.tjgf.retrofit.manager.HostManager;
import com.ms.tjgf.utils.SHA;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


import static com.ms.tjgf.retrofit.manager.HostManager.CLIENT_KEY;
import static com.ms.tjgf.retrofit.manager.HostManager.CLIENT_SALT;

/**
 * 类名称：OkHttp3Utils
 * 类描述：封装一个OkHttp3的获取类
 */
public class OkHttp3Utils {
    private static OkHttpClient mOkHttpClient;
    //设置缓存目录
    private static File cacheDirectory = new File(MyApp.getInstance().getApplicationContext().getCacheDir().getAbsolutePath(), "MyCache");
    private static Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            //打印retrofit日志
            Log.d("zcb", "OkHttp====Message:" + message);
        }
    });

    //获取OkHttpClient对象
    public static OkHttpClient getOkHttpClient() {
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (null == mOkHttpClient) {
            //同样okhttp3后也使用build设计模式
            mOkHttpClient = new OkHttpClient.Builder()
                    //设置一个自动管理cookies的管理器
                    //.cookieJar(new CookiesManager())
                    //添加拦截器(new MyIntercepter())
                    .addInterceptor(loggingInterceptor)
                    //添加网络连接器
                    //.addNetworkInterceptor(new CookiesInterceptor(MyApp.getInstance().getApplicationContext()))
                    //设置请求读写的超时时间
                    .readTimeout(HostManager.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                    .connectTimeout(HostManager.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                    .writeTimeout(HostManager.HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .addInterceptor(new HeaderInterceptor())
                    .cache(cache)
                    .build();
        }
        return mOkHttpClient;
    }

    static class HeaderInterceptor implements Interceptor {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            String timestamp = Long.toString(System.currentTimeMillis() / 1000);
            Request newRequest = request.newBuilder()
                    .addHeader("timestamp", timestamp)
                    .addHeader("clientkey", CLIENT_KEY)
                    .addHeader("sign", SHA.encodeByMD5(CLIENT_KEY + timestamp + CLIENT_SALT))
                    .build();
            HttpUrl.Builder httpBuilder = newRequest.url().newBuilder();
            //httpBuilder.addQueryParameter("access_token", MyApp.getInstance().getToken());
            Request.Builder newBuilder = newRequest.newBuilder();
            newBuilder.url(httpBuilder.build());
            request = newBuilder.build();
            return chain.proceed(request);
        }
    }
}
