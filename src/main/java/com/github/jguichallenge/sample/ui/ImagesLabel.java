package com.github.jguichallenge.sample.ui;


import com.github.jguichallenge.sample.mediator.Mediator;
import com.github.jguichallenge.sample.mediator.MediatorComponent;
import javafx.scene.control.Label;

public class WeatherImages extends Label implements MediatorComponent{

    @Override
    public void setMediator(Mediator mediator) {

    }

    @Override
    public String getName() {
        return "Image";
    }
}
