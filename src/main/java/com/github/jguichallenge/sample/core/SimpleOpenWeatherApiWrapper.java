package com.github.jguichallenge.sample.core;

import com.github.jguichallenge.sample.mediator.GUIMediator;
import com.github.jguichallenge.sample.mediator.GUIMediatorComponent;
import com.github.jguichallenge.sample.models.WeatherState;

public final class SimpleOpenWeatherApiWrapper implements OpenWeatherApiWrapper, GUIMediatorComponent {
    private GUIMediator mediator;
    private final OpenWeather apiHandler;
    private final WeatherStateFactory weatherStateFactory;

    public SimpleOpenWeatherApiWrapper() {
        this.apiHandler = new OpenWeatherProxy();
        this.weatherStateFactory = new WeatherStateFactory();
    }

    @Override
    public String getComponentName() {
        return this.getClass().getName();
    }

    @Override
    public void setMediator(GUIMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public WeatherState getWeatherStateForToday(String cityValue) {
        return this.weatherStateFactory.create(this.apiHandler.getWeather(cityValue));
    }
}
