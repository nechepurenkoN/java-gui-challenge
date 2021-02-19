package com.github.jguichallenge.sample.ui;

import com.github.jguichallenge.sample.mediator.GUIMediator;
import com.github.jguichallenge.sample.mediator.GUIMediatorComponent;
import com.github.jguichallenge.sample.mediator.WeatherGUIMediator;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class MainWindow {
    protected final Stage mainStage;
    protected TilePane mainLayout;
    protected Scene mainScene;
    protected ArrayList<GUIMediatorComponent> mediatorComponentsToRegister;
    protected Label headerLabel;
    protected ArrayList<Node> innerComponents;
    protected CityComboBox cityComboBox;
    protected WeatherContainer weatherContainer;

    public MainWindow(Stage stage) {
        this.mainStage = stage;
        this.innerComponents = new ArrayList<>();
        this.mediatorComponentsToRegister = new ArrayList<>();
        this.initializeCore();
        this.initializeComponents();
        this.registerComponents();
        this.addComponentsToLayout();
    }

    protected void addComponentsToLayout() {
        this.mainLayout.getChildren().addAll(this.innerComponents);
    }

    protected void registerComponents() {
        GUIMediator mediator = new WeatherGUIMediator();
        for (GUIMediatorComponent component : this.mediatorComponentsToRegister) {
            component.setMediator(mediator);
        }
        mediator.registerComponents(mediatorComponentsToRegister);
    }

    protected void initializeComponents() {
        this.headerLabel = new Label("Прогноз погоды");
        this.cityComboBox = new CityComboBox();
        this.weatherContainer = new WeatherContainer();
        this.innerComponents.addAll(Arrays.asList(this.headerLabel, this.cityComboBox, this.weatherContainer));
        this.mediatorComponentsToRegister.addAll(Arrays.asList(this.weatherContainer));
    }

    protected void initializeCore() {
        this.mainLayout = new TilePane();
        this.mainScene = new Scene(this.mainLayout);
        this.mainStage.setScene(this.mainScene);
        this.mainStage.setWidth(450);
        this.mainStage.setHeight(600);
        this.mainStage.setTitle("Hello to JavaFX");
    }

    public void show() {
        this.mainStage.show();
    }
}
