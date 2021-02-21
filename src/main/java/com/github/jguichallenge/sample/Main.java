package com.github.jguichallenge.sample;

import com.github.jguichallenge.sample.mediator.MediatorComponent;
import com.github.jguichallenge.sample.mediator.MediatorGui;
import com.github.jguichallenge.sample.mediator.TemperatureLabel;
import com.github.jguichallenge.sample.ui.CityListComboBox;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage){


        TilePane root = new TilePane();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hello JavaFX");
        stage.setWidth(600);
        stage.setHeight(450);

        ObservableList<String> Langs = FXCollections.observableArrayList("Моксва", "Санкт-Петербург", "Барнаул", "Калининград");
        ComboBox<String> LangsComboBox = new ComboBox<String>(Langs);
        LangsComboBox.setValue("Choose your city:");
        Label headerLabel = new Label("Прогноз погоды");
        root.getChildren().add(headerLabel);
        root.getChildren().add(LangsComboBox);

        CityListComboBox list = new CityListComboBox();
        MediatorGui medGui = new MediatorGui();
        TemperatureLabel temperatureLabel = new TemperatureLabel();
        root.getChildren().add(list);
        root.getChildren().add(temperatureLabel);
        temperatureLabel.setMediator(medGui);
        list.setMediator(medGui);
        medGui.registerComponents(new MediatorComponent[]{list, temperatureLabel});
//        Label weatherTypeImageHolder = new Label("");
//        Image img = new Image("img\\sun.jpg");
//        ImageView view = new ImageView(img);
//        view.setFitHeight(80);
//        view.setPreserveRatio(true);
//        weatherTypeImageHolder.setGraphic(view);
//        root.getChildren().add(weatherTypeImageHolder);

        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
