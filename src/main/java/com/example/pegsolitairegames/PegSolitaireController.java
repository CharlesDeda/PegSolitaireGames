package com.example.pegsolitairegames;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

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
    private Text GameScoreLabel;

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
    //To start game, click first peg -> goes white

    // application state
    Peg initialPeg;

    ArrayList<Peg> firstAndSecond = new ArrayList<Peg>();
    //https://www.baeldung.com/java-hashmap
    HashMap<String, Peg> pegs = new HashMap<String, Peg>();

    // we have made 2 selections and we need to run the play
    // if i can play one becomes empty
    // peg two becomes not empty and blue
    // peg in the middle is empty
    // trick here is to find the middle peg
    // if we can find the middle we play
    // if we can't we reset one and 2 to not selected

    // is there another peg selected other than this selected
    // play scenario
    // click once and set the first peg
    // click again and potentially set the first selection
    // click again and potentially set the second selection
    // now you can play

    // option 1, we derive first and second from the pegs array
    // option 2, we can use another variable to contain these
    // option 3, use 2 variables
    // and finally we have 2 we can play and return
    // otherwise we continue
    // play(first, second);

    void play(Peg first, Peg second) {
        // TODO:
        // be default we are not finding the middle
        // so this code will have to be properly implemented

        System.out.println("play first: " + first.getId() + " second: " + second.getId());
        if ((first.getId().equals("0-0") & second.getId().equals("0-2") & pegs.get("0-2").isEmpty) || (first.getId().equals("0-0") & second.getId().equals("2-0") & pegs.get("2-0").isEmpty)){
            first.isEmpty = true;
            first.updateCircle();
            if ((first.getId().equals("0-0") & second.getId().equals("0-2"))){
                pegs.get("0-1").isEmpty = true;
                pegs.get("0-1").updateCircle();
                decrementScore();
            }
            else{
                pegs.get("1-0").isEmpty = true;
                pegs.get("1-0").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }

        if ((first.getId().equals("0-1") & second.getId().equals("0-3") & pegs.get("0-3").isEmpty) || (first.getId().equals("0-1") & second.getId().equals("2-1") & pegs.get("2-1").isEmpty)){
            first.isEmpty = true;
            first.updateCircle();

            if ((first.getId().equals("0-1") & second.getId().equals("0-3"))){
                pegs.get("0-2").isEmpty = true;
                pegs.get("0-2").updateCircle();
            }
            else{
                pegs.get("1-1").isEmpty = true;
                pegs.get("1-1").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }
        if ((first.getId().equals("0-2") & second.getId().equals("2-0") & pegs.get("2-0").isEmpty) || (first.getId().equals("0-2") & second.getId().equals("0-0") & pegs.get("0-0").isEmpty) ||
                (first.getId().equals("0-2") & second.getId().equals("2-2") & pegs.get("2-2").isEmpty) || (first.getId().equals("0-2") & second.getId().equals("0-4") & pegs.get("0-4").isEmpty)){
            first.isEmpty = true;
            first.updateCircle();
            if ((first.getId().equals("0-2") & second.getId().equals("2-0"))) {
                pegs.get("1-1").isEmpty = true;
                pegs.get("1-1").updateCircle();
            }
            else if (first.getId().equals("0-2") & second.getId().equals("0-0")){
                pegs.get("0-1").isEmpty = true;
                pegs.get("0-1").updateCircle();
            }
            else if (first.getId().equals("0-2") & second.getId().equals("2-2")){
                pegs.get("1-2").isEmpty = true;
                pegs.get("1-2").updateCircle();
            } else {
                pegs.get("0-3").isEmpty = true;
                pegs.get("0-3").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }

        if (((first.getId().equals("0-3") & second.getId().equals("0-1") & pegs.get("0-1").isEmpty) || (first.getId().equals("0-3") & second.getId().equals("2-1") & pegs.get("2-1").isEmpty))){
            first.isEmpty = true;
            first.updateCircle();
            if ((first.getId().equals("0-3") & second.getId().equals("0-1"))){
                pegs.get("0-2").isEmpty = true;
                pegs.get("0-2").updateCircle();
            }
            else{
                pegs.get("1-2").isEmpty = true;
                pegs.get("1-2").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }
        if (((first.getId().equals("0-4") & second.getId().equals("2-2") & pegs.get("2-2").isEmpty) || (first.getId().equals("0-4") & second.getId().equals("0-2") & pegs.get("0-2").isEmpty))){
            first.isEmpty = true;
            first.updateCircle();
            if ((first.getId().equals("0-4") & second.getId().equals("2-2"))){
                pegs.get("1-3").isEmpty = true;
                pegs.get("1-3").updateCircle();
            }
            else{
                pegs.get("0-2").isEmpty = true;
                pegs.get("0-2").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }
        if (((first.getId().equals("1-0") & second.getId().equals("3-0") & pegs.get("3-0").isEmpty) || (first.getId().equals("1-0") & second.getId().equals("1-2") & pegs.get("1-2").isEmpty))){
            first.isEmpty = true;
            first.updateCircle();
            if ((first.getId().equals("1-0") & second.getId().equals("3-0"))){
                pegs.get("2-0").isEmpty = true;
                pegs.get("2-0").updateCircle();
            }
            else{
                pegs.get("1-1").isEmpty = true;
                pegs.get("1-1").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }
        if (((first.getId().equals("1-1") & second.getId().equals("1-3") & pegs.get("1-3").isEmpty) || (first.getId().equals("1-1") & second.getId().equals("3-1") & pegs.get("3-1").isEmpty))){
            first.isEmpty = true;
            first.updateCircle();
            if ((first.getId().equals("1-1") & second.getId().equals("1-3"))){
                pegs.get("1-2").isEmpty = true;
                pegs.get("1-2").updateCircle();
            }
            else{
                pegs.get("2-1").isEmpty = true;
                pegs.get("2-1").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }
        if (((first.getId().equals("1-2") & second.getId().equals("1-0") & pegs.get("1-0").isEmpty) || (first.getId().equals("1-2") & second.getId().equals("3-0") & pegs.get("3-0").isEmpty))){
            first.isEmpty = true;
            first.updateCircle();
            if ((first.getId().equals("1-2") & second.getId().equals("1-0"))){
                pegs.get("1-1").isEmpty = true;
                pegs.get("1-1").updateCircle();
            }
            else{
                pegs.get("2-1").isEmpty = true;
                pegs.get("2-1").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }

        if (((first.getId().equals("1-3") & second.getId().equals("3-1") & pegs.get("3-1").isEmpty) || (first.getId().equals("1-3") & second.getId().equals("1-1") & pegs.get("1-1").isEmpty))){
            first.isEmpty = true;
            first.updateCircle();
            if ((first.getId().equals("1-3") & second.getId().equals("3-1"))){
                pegs.get("2-2").isEmpty = true;
                pegs.get("2-2").updateCircle();
            }
            else{
                pegs.get("1-2").isEmpty = true;
                pegs.get("1-2").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }

        if ((first.getId().equals("2-0") & second.getId().equals("0-0") & pegs.get("0-0").isEmpty) || (first.getId().equals("2-0") & second.getId().equals("4-0") & pegs.get("4-0").isEmpty) ||
                (first.getId().equals("2-0") & second.getId().equals("2-2") & pegs.get("2-2").isEmpty) || (first.getId().equals("2-0") & second.getId().equals("0-2") & pegs.get("0-2").isEmpty)){
            first.isEmpty = true;
            first.updateCircle();
            if ((first.getId().equals("2-0") & second.getId().equals("0-0"))) {
                pegs.get("1-0").isEmpty = true;
                pegs.get("1-0").updateCircle();
            }
            else if (first.getId().equals("2-0") & second.getId().equals("0-2")){
                pegs.get("1-1").isEmpty = true;
                pegs.get("1-1").updateCircle();
            }
            else if (first.getId().equals("2-0") & second.getId().equals("2-2")){
                pegs.get("2-1").isEmpty = true;
                pegs.get("2-1").updateCircle();

            } else {
                pegs.get("3-0").isEmpty = true;
                pegs.get("3-0").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }

        if (((first.getId().equals("2-1") & second.getId().equals("0-1") & pegs.get("0-1").isEmpty) || (first.getId().equals("2-1") & second.getId().equals("0-3") & pegs.get("0-3").isEmpty))){
            first.isEmpty = true;
            first.updateCircle();

            if ((first.getId().equals("2-1") & second.getId().equals("0-1"))){
                pegs.get("1-1").isEmpty = true;
                pegs.get("1-1").updateCircle();
            }
            else{
                pegs.get("1-2").isEmpty = true;
                pegs.get("1-2").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }

        if ((first.getId().equals("2-2") & second.getId().equals("2-0") & pegs.get("2-0").isEmpty) || (first.getId().equals("2-2") & second.getId().equals("4-0") & pegs.get("4-0").isEmpty) ||
                (first.getId().equals("2-2") & second.getId().equals("0-4") & pegs.get("0-4").isEmpty) || (first.getId().equals("2-0") & second.getId().equals("0-2") & pegs.get("0-2").isEmpty)){
            first.isEmpty = true;
            first.updateCircle();

            if ((first.getId().equals("2-2") & second.getId().equals("2-0"))) {
                pegs.get("2-1").isEmpty = true;
                pegs.get("2-1").updateCircle();
            }
            else if (first.getId().equals("2-2") & second.getId().equals("0-4")){
                pegs.get("1-3").isEmpty = true;
                pegs.get("1-3").updateCircle();
            }
            else if (first.getId().equals("2-2") & second.getId().equals("0-2")){
                pegs.get("1-1").isEmpty = true;
                pegs.get("1-1").updateCircle();

            } else {
                pegs.get("3-1").isEmpty = true;
                pegs.get("3-1").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }

        if (((first.getId().equals("3-0") & second.getId().equals("1-0") & pegs.get("1-0").isEmpty) || (first.getId().equals("3-0") & second.getId().equals("1-3") & pegs.get("1-3").isEmpty))){
            first.isEmpty = true;
            first.updateCircle();
            if ((first.getId().equals("3-0") & second.getId().equals("1-0"))){
                pegs.get("2-0").isEmpty = true;
                pegs.get("2-0").updateCircle();
            }
            else{
                pegs.get("2-1").isEmpty = true;
                pegs.get("2-1").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }

        if (((first.getId().equals("3-1") & second.getId().equals("1-1") & pegs.get("1-1").isEmpty) || (first.getId().equals("3-0") & second.getId().equals("1-3") & pegs.get("1-3").isEmpty))){
            first.isEmpty = true;
            first.updateCircle();
            if ((first.getId().equals("3-1") & second.getId().equals("1-1"))){
                pegs.get("2-1").isEmpty = true;
                pegs.get("2-1").updateCircle();
            }
            else{
                pegs.get("2-2").isEmpty = true;
                pegs.get("2-2").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }

        if (((first.getId().equals("4-0") & second.getId().equals("2-0") & pegs.get("2-0").isEmpty) || (first.getId().equals("4-0") & second.getId().equals("2-2") & pegs.get("2-2").isEmpty))){
            first.isEmpty = true;
            first.updateCircle();
            if ((first.getId().equals("4-0") & second.getId().equals("2-0"))){
                pegs.get("3-0").isEmpty = true;
                pegs.get("3-0").updateCircle();
            }
            else{
                pegs.get("3-1").isEmpty = true;
                pegs.get("3-1").updateCircle();
            }
            second.isEmpty = false;
            second.updateCircle();
        }

        first.isSelected = false;
        second.isSelected = false;
        first.updateCircle();
        second.updateCircle();
        firstAndSecond.clear();

    }

    // this func is called when a peg is clicked upon
    void pegClicked(String id) {
        System.out.println("pegClicked id: " + id);
        // find the peg at this id, there should be just one.
        Peg selectedPeg = pegs.get(id);

        if (selectedPeg == null) {
            // bail early
            // and this should not really happen
            return;
        }

        // configure the initial peg
        if (initialPeg == null) {
            // now the game can start
            initialPeg = selectedPeg;
            initialPeg.isEmpty = true;
            initialPeg.updateCircle();
            return;
        }



        selectedPeg.toggle();
        selectedPeg.updateCircle();

        // if selectedPeg.isSelected and not in the array, add it
        // if not and in the array, remove it
        if (selectedPeg.isSelected && !firstAndSecond.contains(selectedPeg)) {
            firstAndSecond.add(selectedPeg);
        }
        if (!selectedPeg.isSelected && firstAndSecond.contains(selectedPeg)) {
            firstAndSecond.remove(selectedPeg);
        }

        // if the array has 2 items, play
        if (firstAndSecond.size() == 2) {
            play(firstAndSecond.get(0), firstAndSecond.get(1));
            return;
        }
    }


    int decrementScore() {return Integer.parseInt(GameScoreLabel.getText()) - 1;}

    // Current thought: Continue with the idea that we check empty pegs and put the ones that are not empty into a list
    // from there, we send the list to the nextTO method and that method will check to see if there are any valid moves
    // aka pegs close enough to each other.
    boolean nextTo(ArrayList <Peg> nonEmpty){
        ArrayList<int> xAxisPeg = new ArrayList<>();

        for(Peg val : nonEmpty){

            String xAxis = val.getRow();  // to check all moves, you can add 1 and subtract one from X and Y axis o determine if there are pegs there.
            String yAxis = val.getColumn();

            if (xAxis + 1 & yAxis + 1) in
        }
    }

    boolean gameOver() {
        ArrayList<Peg> leftoverPeg = new ArrayList<Peg>();

        int count = 0;
        pegs.forEach(peg -> {
            if(peg.isEmpty() != false) {
                leftoverPeg.add();

        });
        return leftoverPeg;
        }
    }

    void didStart() {
        // create the state
        List<Circle> circles = Arrays.asList(Peg0, Peg1, Peg2, Peg3, Peg4, Peg5, Peg6, Peg7, Peg8, Peg9, Peg10, Peg11, Peg12, Peg13, Peg14);
        // set up the clicks
        circles.forEach(circle -> {
            Peg newPeg = new Peg();

            newPeg.circle = circle;
            pegs.put(newPeg.getId(), newPeg);
            circle.setFill(newPeg.getColor());
            circle.setOnMouseClicked( event -> {
                Circle clicked = (Circle)event.getSource();
                String id = clicked.getId();

                pegClicked(id);
            });
        });
    }


}
