package com.github.jguichallenge.sample.ui;

import com.github.jguichallenge.sample.mediator.GUIMediator;
import com.github.jguichallenge.sample.mediator.GUIMediatorComponent;
import javafx.scene.control.ComboBox;

public class CityComboBox extends ComboBox<String> implements GUIMediatorComponent {

    private GUIMediator mediator;
    private final String[] cities;
    private final String defaultValue;

    public CityComboBox() {
        super();
        this.cities = new String[] {"Москва", "Санкт-Петербург", "Барнаул", "Калининград"};
        this.defaultValue = "Выберите город";
        this.setValue(this.defaultValue);
        this.getItems().addAll(cities);
        this.setHandlers();
    }

    private void setHandlers() {
        this.setOnAction(event -> {
            if (!defaultValue.equals(this.getValue()))
                this.mediator.cityValueChanged(this.getValue());
        });
    }

    @Override
    public String getComponentName() {
        return this.getClass().getName();
    }

    @Override
    public void setMediator(GUIMediator mediator) {
        this.mediator = mediator;
    }
}
