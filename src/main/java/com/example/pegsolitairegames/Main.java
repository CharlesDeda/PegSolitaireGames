package com.example.pegsolitairegames;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        URL url = Main.class.getResource("pegSolitaire.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);

        Scene scene = new Scene(fxmlLoader.load(),600,400);

        PegSolitaireController controller = (PegSolitaireController)fxmlLoader.getController();

        controller.didStart();
        stage.setTitle("Peg Solitaire Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}