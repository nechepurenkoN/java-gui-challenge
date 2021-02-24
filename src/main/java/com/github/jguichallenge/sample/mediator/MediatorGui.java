package com.github.jguichallenge.sample.mediator;

import com.github.jguichallenge.sample.techcore.RefactorData;
import com.github.jguichallenge.sample.ui.ImagesLabel;
import com.github.jguichallenge.sample.ui.TemperatureLabel;

public class MediatorGui implements Mediator{
    private TemperatureLabel temperatureLabel;
    private ImagesLabel imagesLabel;
    private RefactorData refactorData = new RefactorData();

    @Override
    public void changeTemperatureLabel(String currentTemperature){
        this.temperatureLabel.setTemperature(refactorData.getTemperature());
    }

    @Override
    public void changeImage(String currentImage) {
        this.imagesLabel.setImagesURL(refactorData.getImageId());
    }

    @Override
    public void registerComponents(MediatorComponent[] toRegistration) {
       for(MediatorComponent currentComponent: toRegistration){
           if (currentComponent.getName().equals("Temperature")){
               this.temperatureLabel = (TemperatureLabel) currentComponent;
           }
           if (currentComponent.getName().equals("Image")){
               this.imagesLabel = (ImagesLabel) currentComponent;
           }
       }
    }

}
