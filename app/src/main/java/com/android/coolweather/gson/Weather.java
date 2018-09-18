package com.android.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;
//处理服务器返回的Json数据，在总的实体类引用各个实体类
public class Weather {
    public String status;//成功返回ok，失败返回具体原因

    public Basic basic;

    public AQI aqi;

    public Now now;

    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;//daily_forecast包含的是一个数组，这里使用List集合引用Forecast类
}
