package com.github.jguichallenge.sample.ui;

import com.github.jguichallenge.sample.mediator.MediatorComponent;
import com.github.jguichallenge.sample.mediator.MediatorGui;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class MainWindow extends Stage{
    public MainWindow(Stage stage) {

        TilePane MainTilePane = new TilePane();
        Scene scene = new Scene(MainTilePane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Прогноз погоды");

        Label headerLabel = new Label("Прогноз погоды на сегодня:");
        CityListComboBox list = new CityListComboBox();
        MediatorGui medGui = new MediatorGui();
        TemperatureLabel temperatureLabel = new TemperatureLabel();
        ImagesLabel imagesLabel = new ImagesLabel();

        temperatureLabel.setMediator(medGui);
        imagesLabel.setMediator(medGui);
        list.setMediator(medGui);

        medGui.registerComponents(new MediatorComponent[]{list, temperatureLabel, imagesLabel});

        MainTilePane.getChildren().add(headerLabel);
        MainTilePane.getChildren().add(list);
        MainTilePane.getChildren().add(temperatureLabel);
        MainTilePane.getChildren().add(imagesLabel);
        stage.show();
    }
}
