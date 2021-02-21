package com.github.jguichallenge.sample.mediator;

import javafx.scene.control.Label;

public class MediatorGui implements Mediator{
    private TemperatureLabel temperatureLabel;

    @Override
    public void changeComboBox(String currentCity) {
        this.temperatureLabel.setTemperature(currentCity);
    }

    @Override
    public void registerComponents(MediatorComponent[] toRegistration) {
       for(MediatorComponent currentComponent: toRegistration){
           if (currentComponent.getName().equals("Temperature")){
               this.temperatureLabel = (TemperatureLabel) currentComponent;
           }
       }
    }

}
