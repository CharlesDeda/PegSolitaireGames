package com.example.pegsolitairegames;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

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



    @FXML
    void clickedPeg0(MouseEvent event) {
        Circle clicked = (Circle)event.getSource();
        String id = clicked.getId();
        clickedOnPeg(id);


        // Peg0.idProperty()
    }

    @FXML
    void moveablePeg1(MouseEvent event) {
        Circle clicked = (Circle)event.getSource();
        String id = clicked.getId();
        clickedOnPeg(id);
    }

    @FXML
    void moveablePeg10(MouseEvent event) {

    }

    @FXML
    void moveablePeg11(MouseEvent event) {

    }

    @FXML
    void moveablePeg12(MouseEvent event) {

    }

    @FXML
    void moveablePeg13(MouseEvent event) {

    }

    @FXML
    void moveablePeg14(MouseEvent event) {

    }

    @FXML
    void moveablePeg2(MouseEvent event) {

    }

    @FXML
    void moveablePeg3(MouseEvent event) {

    }

    @FXML
    void moveablePeg4(MouseEvent event) {

    }

    @FXML
    void moveablePeg5(MouseEvent event) {

    }

    @FXML
    void moveablePeg6(MouseEvent event) {

    }

    @FXML
    void moveablePeg7(MouseEvent event) {

    }

    @FXML
    void moveablePeg8(MouseEvent event) {

    }

    @FXML
    void moveablePeg9(MouseEvent event) {

    }

    @FXML
    void peg0Drag(MouseEvent event) {

    }

    @FXML
    void peg10Drag(MouseEvent event) {

    }

    @FXML
    void peg11Drag(MouseEvent event) {

    }

    @FXML
    void peg12Drag(MouseEvent event) {

    }

    @FXML
    void peg13Drag(MouseEvent event) {

    }

    @FXML
    void peg14Drag(MouseEvent event) {

    }

    @FXML
    void peg1Drag(MouseEvent event) {

    }

    @FXML
    void peg2Drag(MouseEvent event) {

    }

    @FXML
    void peg3Drag(MouseEvent event) {

    }

    @FXML
    void peg4Drag(MouseEvent event) {

    }

    @FXML
    void peg5Drag(MouseEvent event) {

    }

    @FXML
    void peg6Drag(MouseEvent event) {

    }

    @FXML
    void peg7Drag(MouseEvent event) {

    }

    @FXML
    void peg8Drag(MouseEvent event) {

    }

    @FXML
    void peg9Drag(MouseEvent event) {

    }

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
    ArrayList<Circle> pegs = new ArrayList<Circle>();

    void clickedOnPeg(String id) {
        System.out.print("id: " + id);
        // find the peg at this id
        Optional<Circle> selected = pegs.stream().filter(peg -> {
            return peg.idProperty().getValue().equals(id);
        }).findFirst();

        selected.ifPresent(circle -> {
            circle.setFill(Color.RED);
        });

        // if it's on, turn it off
        // if off turn it on
        // then figure the color based on the toggle
        // thePeg[index].toggle()
        // thePeg[index].setFillColor(isToggle ? Color.RED : Color.BLUE)
        // Peg0.setFill(Color.RED);
    }

    void pegClicked(MouseEvent event) {
        Circle clicked = (Circle)event.getSource();
        String id = clicked.getId();
        clickedOnPeg(id);
    }
    void didStart() {
        // create the state
        pegs.addAll(Arrays.asList(Peg0, Peg1, Peg2, Peg3, Peg4, Peg5, Peg6, Peg7, Peg8, Peg9, Peg10, Peg11, Peg12, Peg13, Peg14));
        pegs.forEach(peg -> {
            peg.setOnMouseClicked( event -> {
                pegClicked(event);
            });
        });
    }
}
