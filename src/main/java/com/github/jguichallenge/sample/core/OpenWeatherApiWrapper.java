package com.github.jguichallenge.sample.core;

import com.github.jguichallenge.sample.models.WeatherState;

public interface OpenWeatherApiWrapper {
    WeatherState getWeatherStateForToday(String cityValue);
}
