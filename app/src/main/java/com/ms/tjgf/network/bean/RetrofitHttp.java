package com.ms.tjgf.network.bean;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ms.tjgf.application.MyApplication;
import com.ms.tjgf.network.HttpConstants;
import com.ms.tjgf.network.IHttp;
import com.ms.tjgf.utils.SHA;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ms.tjgf.network.HttpConstants.CLIENT_KEY;
import static com.ms.tjgf.network.HttpConstants.CLIENT_SALT;

/**
 * Created by fangt on 2018/1/18.
 */

public class RetrofitHttp {
    private static IHttp mHttp;
    private static RetrofitHttp mRetrofit;
    Retrofit.Builder mRetrofitBulder = new Retrofit.Builder();
    OkHttpClient.Builder mOkhttpClient = new OkHttpClient.Builder()
            .readTimeout(HttpConstants.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
            .connectTimeout(HttpConstants.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
            .addInterceptor(new HeaderInterceptor())
            .addInterceptor(new OkHttpLogInterceptor());

    private RetrofitHttp(){
        mHttp = mRetrofitBulder.baseUrl(HttpConstants.TEST_URL)
                .client(mOkhttpClient.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IHttp.class);
    }

    public static IHttp getInstance(){
        if (mHttp == null){
            mRetrofit = new RetrofitHttp();
        }
        return mHttp;
    }

    class HeaderInterceptor implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            String timestamp = Long.toString(System.currentTimeMillis() / 1000);
            Request newRequest = request.newBuilder()
                    .addHeader("timestamp",timestamp)
                    .addHeader("clientkey",CLIENT_KEY)
                    .addHeader("sign", SHA.encodeByMD5(CLIENT_KEY+timestamp+CLIENT_SALT))
                    .build();
            HttpUrl.Builder httpBuilder = newRequest.url().newBuilder();
            httpBuilder.addQueryParameter("access_token", MyApplication.getUser() == null ? "":MyApplication.getUser().getToken());
            Request.Builder newBuilder = newRequest.newBuilder();
            newBuilder.url(httpBuilder.build());
            request = newBuilder.build();
            return chain.proceed(request);
        }
    }

    class OkHttpLogInterceptor implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response response = chain.proceed(chain.request());
            MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            System.out.println("--------------------request--------------------");
            System.out.println(response.request().url());
            System.out.println("--------------------response--------------------");
            System.out.println(content.toString());
            System.out.println("--------------------response--------------------");

            if (response.body() != null) {
                // 深坑！
                // 打印body后原ResponseBody会被清空，需要重新设置body
                ResponseBody body = ResponseBody.create(mediaType, content);
                return response.newBuilder().body(body).build();
            } else {
                return response;
            }
        }
    }
}
