package com.github.jguichallenge.sample.ui;


import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;

public class WeatherImage extends Label {
    private final String[] states;
    private final HashMap<String, ImageView> images;

    public WeatherImage() {
        this.states = new String[] {"Sunny", "Rainy"};
        this.images = new HashMap<>();
        this.initializeImages();
        this.changeState("Empty");
    }

    private void initializeImages() {
        for (String state : this.states) {
            this.images.put(state, new ImageView(new Image("img\\" + state.toLowerCase() + ".jpg")));
        }
        this.images.put("Empty", new ImageView(new Image("img\\empty.jpg")));
    }

    void changeState(String newState) {
        this.setGraphic(this.images.get(newState));
    }
}
