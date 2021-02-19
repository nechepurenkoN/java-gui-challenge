package com.github.jguichallenge.sample.mediator;

import com.github.jguichallenge.sample.models.WeatherState;

import java.util.ArrayList;

public interface GUIMediator {
    void cityValueChanged(String cityValue);
    void updateCurrentWeatherState(WeatherState state);
    void registerComponents(ArrayList<GUIMediatorComponent> componentList);
}
