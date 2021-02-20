package com.github.jguichallenge.sample.core;

import org.json.JSONObject;

public interface OpenWeather {
    // minimal implementation
     JSONObject getWeather(String cityValue);
}
