package com.github.jguichallenge.sample.mediator;

import javafx.scene.control.Label;

public class TemperatureLabel extends Label implements MediatorComponent{
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "Temperature";
    }

    public TemperatureLabel() {
        super();
    }

    public void setTemperature(String value){
        this.setText(value);
    }
}

