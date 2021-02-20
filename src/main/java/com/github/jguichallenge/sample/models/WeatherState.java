package com.github.jguichallenge.sample.models;

public class WeatherState {
    private final String city;
    private final Integer temperatureCelsius;
    private final String weatherImage;

    public WeatherState(String city, Integer temperatureCelsius, String weatherImage) {
        this.city = city;
        this.temperatureCelsius = temperatureCelsius;
        this.weatherImage = weatherImage;
    }

    public String getCity() {
        return city;
    }

    public Integer getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public String getWeatherImage() {
        return weatherImage;
    }

}
