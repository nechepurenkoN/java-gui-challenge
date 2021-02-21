package com.github.jguichallenge.sample.mediator;

public interface Mediator {
    void changeComboBox(String currentCity);
    void registerComponents(MediatorComponent[] toRegistration);
}
