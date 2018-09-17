package com.android.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        //传入请求地址
        Request request=new Request.Builder().url(address).build();
        //注册一个回调来处理服务器响应
        client.newCall(request).enqueue(callback);
    }
}
