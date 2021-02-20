package com.github.jguichallenge.sample.ui;

import com.github.jguichallenge.sample.mediator.GUIMediator;
import com.github.jguichallenge.sample.mediator.GUIMediatorComponent;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;


public class WeatherContainer extends TilePane implements WeatherRenderArea, GUIMediatorComponent {
    protected GUIMediator mediator;
    protected WeatherImage image;
    protected Label temperatureCelsiusLabel;

    public WeatherContainer() {
        super();
        this.setOrientation(Orientation.VERTICAL);
        this.image = new WeatherImage();
        this.temperatureCelsiusLabel = new Label("213");
        this.getChildren().addAll(this.temperatureCelsiusLabel, this.image);
    }

    @Override
    public void setCurrentImage(String newImageName) {
        this.image.changeState(newImageName);
    }

    @Override
    public void setCurrentTemperatureCelsius(Integer temperatureCelsius) {
        this.temperatureCelsiusLabel.setText("Температура " + temperatureCelsius + " градусов по Цельсию.");
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
