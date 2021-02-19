package com.github.jguichallenge.sample.mediator;

import com.github.jguichallenge.sample.core.OpenWeatherApiWrapper;
import com.github.jguichallenge.sample.core.SimpleOpenWeatherApiWrapper;
import com.github.jguichallenge.sample.models.WeatherState;
import com.github.jguichallenge.sample.ui.WeatherRenderArea;

import java.util.ArrayList;

public final class WeatherGUIMediator implements GUIMediator {
    private final OpenWeatherApiWrapper openWeatherApiWrapper;
    private WeatherRenderArea weatherRenderArea;

    public WeatherGUIMediator() {
        this.openWeatherApiWrapper = new SimpleOpenWeatherApiWrapper();
    }

    @Override
    public void cityValueChanged(String cityValue) {
        System.out.println(cityValue);
    }

    @Override
    public void updateCurrentWeatherState(WeatherState state) {
        this.weatherRenderArea.setCurrentImage(state.getImage());
        this.weatherRenderArea.setCurrentTemperatureCelsius(state.getTemperatureCelsius());
    }

    @Override
    public void registerComponents(ArrayList<GUIMediatorComponent> componentList) {
        for (GUIMediatorComponent component : componentList) {
            if (component.getComponentName().equals("WeatherContainer")){
                this.weatherRenderArea = (WeatherRenderArea) component;
            }
        }
    }
}
