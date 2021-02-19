package com.github.jguichallenge.sample;

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


        TilePane mTile = new TilePane();
        Scene scene = new Scene(mTile);
        stage.setScene(scene);
        stage.setTitle("Hello JavaFX");
        stage.setWidth(600);
        stage.setHeight(450);

        ObservableList<String> Langs = FXCollections.observableArrayList("Моксва", "Санкт-Петербург", "Барнаул", "Калининград");
        ComboBox<String> LangsComboBox = new ComboBox<String>(Langs);
        LangsComboBox.setValue("Choose your city:");
        Label label1= new Label("Прогноз погоды");
        mTile.getChildren().add(label1);
        mTile.getChildren().add(LangsComboBox);

        Label label2 = new Label("");
        Image img = new Image("src\\main\\resources\\img\\sun.jpg");
        ImageView view = new ImageView(img);
        view.setFitHeight(80);
        view.setPreserveRatio(true);
        label2.setGraphic(view);

        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
