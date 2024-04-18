package com.example.pegsolitairegames.app;

import com.example.pegsolitairegames.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class GameManager {
    Game game;
    Stage stage;
    @FXML
     Button resetButton;

    public GameManager(Stage stage) {
        this.stage = stage;
        setupGame();
    }
    void setupGame()  {
        try {
            URL url = Main.class.getResource("pegSolitaire.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            Scene scene = new Scene(fxmlLoader.load(),600,400);
            game = (Game)fxmlLoader.getController();
            game.didStart();
            stage.setTitle("Peg Solitaire Game");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void resetButtonTapped() {

            resetButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.out.println("I got here!");
                }
            });
        setupGame();
    }
}
