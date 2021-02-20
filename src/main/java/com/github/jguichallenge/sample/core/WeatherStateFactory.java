package com.github.jguichallenge.sample.core;

import com.github.jguichallenge.sample.models.WeatherState;
import org.json.JSONObject;

public class WeatherStateFactory {
    public WeatherState create(JSONObject apiResponse) {
        System.out.println(apiResponse);
        String city = apiResponse.getString("name");
        Integer temperatureCelsius = this.convert(apiResponse.getJSONObject("main").getDouble("temp"));
        return new WeatherState(city, temperatureCelsius, "Sunny");
    }

    private Integer convert(Double value) {
        return Math.toIntExact(Math.round(value - 273.15));
    }
}
