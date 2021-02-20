package com.github.jguichallenge.sample.core;

import org.json.JSONObject;

import java.util.HashMap;

public class OpenWeatherProxy implements OpenWeather {
    private final OpenWeather getter;
    private final HashMap<String, String> cityToCodeMapper;

    public OpenWeatherProxy() {
        this.getter = new OpenWeatherGetter();
        this.cityToCodeMapper = new HashMap<>();
        this.cityToCodeMapper.put("Барнаул", "Barnaul");
        this.cityToCodeMapper.put("Москва", "Moscow");
        this.cityToCodeMapper.put("Санкт-Петербург", "Saint Petersburg, RU");
        this.cityToCodeMapper.put("Калининград", "Kaliningrad");
    }

    @Override
    public JSONObject getWeather(String cityValue) {
        return this.getter.getWeather(this.cityToCodeMapper.get(cityValue));
    }
}
