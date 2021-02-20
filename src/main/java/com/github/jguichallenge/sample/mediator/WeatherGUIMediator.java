package com.github.jguichallenge.sample.mediator;

import com.github.jguichallenge.sample.core.SimpleOpenWeatherApiWrapper;
import com.github.jguichallenge.sample.models.WeatherState;
import com.github.jguichallenge.sample.ui.WeatherRenderArea;

import java.util.ArrayList;

public final class WeatherGUIMediator implements GUIMediator {
    private final SimpleOpenWeatherApiWrapper openWeatherApiWrapper;
    private WeatherRenderArea weatherRenderArea;

    public WeatherGUIMediator() {
        this.openWeatherApiWrapper = new SimpleOpenWeatherApiWrapper();
        this.openWeatherApiWrapper.setMediator(this);
    }

    @Override
    public void cityValueChanged(String cityValue) {
        WeatherState state = this.openWeatherApiWrapper.getWeatherStateForToday(cityValue);
        this.updateCurrentWeatherState(state);
    }

    @Override
    public void updateCurrentWeatherState(WeatherState state) {
        this.weatherRenderArea.setCurrentImage(state.getWeatherImage());
        this.weatherRenderArea.setCurrentTemperatureCelsius(state.getTemperatureCelsius());
    }

    @Override
    public void registerComponents(ArrayList<GUIMediatorComponent> componentList) {
        for (GUIMediatorComponent component : componentList) {
            if (component.getComponentName().endsWith("WeatherContainer")){
                this.weatherRenderArea = (WeatherRenderArea) component;
            }
        }
    }
}
