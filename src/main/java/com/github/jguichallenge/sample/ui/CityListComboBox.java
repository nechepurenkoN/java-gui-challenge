package com.github.jguichallenge.sample.ui;

import com.github.jguichallenge.sample.mediator.Mediator;
import com.github.jguichallenge.sample.mediator.MediatorComponent;
import javafx.scene.control.ComboBox;

public class CityListComboBox extends ComboBox implements MediatorComponent {
    private Mediator mediator;
    private String[] cityList;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "ComboBox";
    }

    public CityListComboBox() {
        super();
        this.setValue("Выбери свой город:");
        cityList = new String[] {"Barnaul","Moscow","Киев"};
        this.getItems().addAll(cityList);
        this.setOnAction(e -> {
            this.actionHandler();
        });
    }

    private void actionHandler(){
        mediator.sendCurrentCity((String) this.getValue());
        mediator.changeTemperatureLabel((String) this.getValue());
        mediator.changeImage((String) this.getValue());
    }
}
