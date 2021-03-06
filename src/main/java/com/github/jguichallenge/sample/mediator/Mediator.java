package com.github.jguichallenge.sample.mediator;

public interface Mediator {
    void changeTemperatureLabel(String currentTemperature);
    void changeImage(String currentImage);
    void sendCurrentCity(String currentCity);
    void registerComponents(MediatorComponent[] toRegistration);
}
