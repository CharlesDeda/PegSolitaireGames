package com.example.pegsolitairegames;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Game {
    @FXML
    private Button resetButton;

    void resetButtonClicked() {
        resetButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Hello world I really made it man hey guys whats up bro haha yeah brother");
            }
        });
    }
}
