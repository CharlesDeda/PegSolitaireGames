package com.example.pegsolitairegames;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PegSolitaireApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        URL url = new File("src/main/java/resources/com/example/pegsolitairegame/pegSolitaire").toURI().toURL();
//        Parent root = FXMLLoader.load(url);
//        Parent root = FXMLLoader.load(getClass().getResource("pegSolitaire.fmxl"));
        FXMLLoader fxmlLoader = new FXMLLoader(PegSolitaireApplication.class.getResource("pegSolitaire.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,490);
        stage.setTitle("Peg Solitaire Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}