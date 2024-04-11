package com.example.pegsolitairegames;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.*;

public class PegSolitaireController{

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Pane Box1;

    @FXML
    private Pane Box10;

    @FXML
    private Pane Box11;

    @FXML
    private Pane Box12;

    @FXML
    private Pane Box13;

    @FXML
    private Pane Box14;

    @FXML
    private Pane Box15;

    @FXML
    private Pane Box2;

    @FXML
    private Pane Box3;

    @FXML
    private Pane Box4;

    @FXML
    private Pane Box5;

    @FXML
    private Pane Box6;

    @FXML
    private Pane Box7;

    @FXML
    private Pane Box8;

    @FXML
    private Pane Box9;

    @FXML
    private Label GameScore;

    @FXML
    private Circle Peg0;

    @FXML
    private Circle Peg1;

    @FXML
    private Circle Peg10;

    @FXML
    private Circle Peg11;

    @FXML
    private Circle Peg12;

    @FXML
    private Circle Peg13;

    @FXML
    private Circle Peg14;

    @FXML
    private Circle Peg3;

    @FXML
    private Circle Peg4;

    @FXML
    private Circle Peg5;

    @FXML
    private Circle Peg6;

    @FXML
    private Circle Peg7;

    @FXML
    private Circle Peg8;

    @FXML
    private Circle Peg9;

    @FXML
    private Circle Peg2;



    // Create list of pegs
    //TODO:
    // after the app starts you need to put all the pegs into an array or list
    //
    // let pegs = [Peg0, Peg1, ...]
    //
    // implement a toggle, each time i click in a peg it turn blue if red and red if blue
    // this is the toggle logic

    // application state
    String initialPegID = "";
    //https://www.baeldung.com/java-hashmap
    HashMap<String, Peg> pegs = new HashMap<String, Peg>();

    // this func is called when a peg is clicked upon
    void pegClicked(String id) {
        System.out.print("id: " + id);
        // find the peg at this id, there should be just one.
        Peg selected = pegs.get(id);

        if (selected != null) {
            // we found it and we know it is a circle
            selected.toggle();
            selected.circle.setFill(selected.getColor());
        }

        // if it's on, turn it off
        // if off turn it on
        // then figure the color based on the toggle
        // thePeg[index].toggle()
        // thePeg[index].setFillColor(isToggle ? Color.RED : Color.BLUE)
        // Peg0.setFill(Color.RED);
    }

    // We have layed out the UI using SceneBuilder
    // The first thing we do is to set up our data structures that will be used in the rest of the time
    // It is all about data structures and further more we have to connect UI elements such as Peg0 with our
    // data structures
    //
    void didStart() {
        // create the state
        List<Circle> circles = Arrays.asList(Peg0, Peg1, Peg2, Peg3, Peg4, Peg5, Peg6, Peg7, Peg8, Peg9, Peg10, Peg11, Peg12, Peg13, Peg14);
        // set up the clicks
        circles.forEach(circle -> {
            Peg newPeg = new Peg();

            newPeg.circle = circle;
            newPeg.isSelected = false;
            pegs.put(newPeg.getId(), newPeg);
            circle.setOnMouseClicked( event -> {
                Circle clicked = (Circle)event.getSource();
                String id = clicked.getId();

                pegClicked(id);
            });
        });
    }
}
