package com.example.pegsolitairegames;

import com.example.pegsolitairegames.app.GameManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        GameManager gameManager = new GameManager(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}