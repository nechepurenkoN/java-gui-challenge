package com.github.jguichallenge.sample.ui;


import com.github.jguichallenge.sample.mediator.Mediator;
import com.github.jguichallenge.sample.mediator.MediatorComponent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagesLabel extends Label implements MediatorComponent{
private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "Image";
    }

    public void setImagesURL(String value){
       setCurrentImage(value);
    }

    public ImagesLabel() {
        super();
        //setCurrentImage("01d");
    }
    private void setCurrentImage(String imageURL){
        Image img = new Image("img\\"+imageURL+"@2x.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(80);
        view.setPreserveRatio(true);
        this.setGraphic(view);
    }
}
