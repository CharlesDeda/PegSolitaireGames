package com.example.pegsolitairegames;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.*;
import java.util.function.BiConsumer;

public class GameManager {

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
    private Text scoreCounter;

    @FXML
    private Button resetButton;


    // initialPeg is the peg the user chooses to select from the gameBoard, which allows them to begin playing
    Peg initialPeg;

    //this arrayList is built to contain our first selected and second selected pegs to utilize in the play func
    ArrayList<Peg> firstAndSecond = new ArrayList<Peg>();

    // this arrayList is build to contain all the empty pegs on the board.
    ArrayList<Peg> empty = new ArrayList<Peg>();

    //https://www.baeldung.com/java-hashmap
    //this hashmap contains our board of pegs with ids starting from bottom left = "0-0" and top of diamond is "4-0"
    HashMap<String, Peg> pegs = new HashMap<String, Peg>();


    /*
    play function is the game logic, update circles based on current state and what user is inputting.
    to begin playing, we need to grab the middle peg based on our first and second selections, with this func called we now have the pegs in which state must be updated
    first selected isEmpty, middlePeg isEmpty, and finally secondPeg !isSelected (full)

     */
    void play(Peg first, Peg second) {

        Peg middlePeg = pegBetween(first, second);

        //if our middlePeg is already empty we cannot make the move, so clear everything and return
        if (middlePeg == null || middlePeg.isEmpty) {
            first.isSelected = false;
            second.isSelected = false;
            first.updateCircle();
            second.updateCircle();
            firstAndSecond.clear();
            return;
        }

        //if the peg selected isEmpty, we just leave clear everything and return
        if (first == null || first.isEmpty) {
            first.isSelected = false;
            second.isSelected = false;
            first.updateCircle();
            second.updateCircle();
            firstAndSecond.clear();
            return;
        }

        //updating our state
        first.isEmpty = true;
        first.updateCircle();
        middlePeg.isEmpty = true;
        middlePeg.updateCircle();
        second.isEmpty = false;
        second.updateCircle();

        //updating score
        decrementScore();

        //clearing our state
        first.isSelected = false;
        second.isSelected = false;
        first.updateCircle();
        second.updateCircle();
        firstAndSecond.clear();

        endGame();


    }

    /*
    pegBetween calculates which peg is being jumped over on the board
    using some simple matrix calculations, it can be assumed that there are 3 states
    if row is same but column is different, calculate middle peg by subtracting 1 from the column with a higher value
    if row is different but row is different, calculate middle peg by subtracting 1 from the row with a higher value
    if row is different and  column is different, calculate middle peg by subtracting 1 from both the row and column with a higher value
    these values are calculated, and then using a hashmap with those values we grab the id straight from our map of pegs
    this peg is then returned
     */
    Peg pegBetween(Peg first, Peg second) {

        // Peg middlePeg = new Peg();
        int maxColumn = 0;
        int maxRow = 0;
        if (first.getRow() == second.getRow() & first.getColumn() != second.getColumn()) {
            maxColumn = Math.max(first.getColumn(), second.getColumn());
            maxColumn -= 1;
            maxRow = first.getRow();
        } else if (first.getRow() != second.getRow() & first.getColumn() == second.getColumn()) {
            maxRow = Math.max(first.getRow(), second.getRow());
            maxRow -= 1;
            maxColumn = first.getColumn();
        } else {
            maxRow = Math.max(first.getRow(), second.getRow());
            maxColumn = Math.max(first.getColumn(), second.getColumn());
            maxColumn -= 1;
            maxRow -= 1;
        }

        String pegid = maxRow + "-" + maxColumn;

        Peg middlePeg = pegs.get(pegid);

        if (middlePeg == null) {
            // we should not really get here
            System.out.println(pegid);
        }
        return middlePeg;
    }

    /*
    pegClicked is called each time a peg is clicked upon
    the selectedPeg is grabbed from our hashmap Pegs and then set
    once a peg is selected, we toggle its state, and it is added to our arrayList firstAndSecond
    once two pegs have been added to the list, we call play
     */
    void pegClicked(String id) {

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
            decrementScore();
            return;
        }

        //updating selectedPegs color to indicate to user they are playing
        selectedPeg.toggle();
        selectedPeg.updateCircle();

        //adding our pegs to firstAndSecond for playing
        if (selectedPeg.isSelected && !firstAndSecond.contains(selectedPeg)) {
            firstAndSecond.add(selectedPeg);
        }
        //make sure we do not click on the same one
        if (!selectedPeg.isSelected && firstAndSecond.contains(selectedPeg)) {
            firstAndSecond.remove(selectedPeg);
        }

        // if the arraylist has 2 items, play
        if (firstAndSecond.size() == 2) {
            play(firstAndSecond.get(0), firstAndSecond.get(1));
            return;
        }


    }

    /*
    decrement score grabs the inital score, and decrements by 1
    this is called each time a new peg is emptied
     */
    void decrementScore() {
        int score = Integer.parseInt(scoreCounter.getId());
        scoreCounter.setId(String.valueOf(score - 1));
        scoreCounter.setText(String.valueOf(scoreCounter.getId()));
    }


    /*
    reset score is part of our reset logic, when the player wants to start over we have to initialize the score back to 15
     */
    void resetScore() {
        int score = 16;
        scoreCounter.setId(String.valueOf(score - 1));
        scoreCounter.setText(String.valueOf(scoreCounter.getId()));
    }

    /*
    setResetButtonAction handles a mouseclick event on the reset button, when clicked we call didStart and restart the game
     */
    void setResetButtonAction() {
        resetButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                didStart();
            }
        });
    }


    /*
    didStart intializes our state, we build a hashmap of pegs and foreach peg, we can handle some mouseclick event
    in this initialization we have the ability to reset everything as well
    each peg has an id, and this id is sent to the other funcs to allow easy state management
     */
    void didStart() {
        // reset all state
        pegs.clear();
        firstAndSecond.clear();
        initialPeg = null;
        setResetButtonAction();
        resetScore();

        // create the state
        List<Circle> circles = Arrays.asList(Peg0, Peg1, Peg2, Peg3, Peg4, Peg5, Peg6, Peg7, Peg8, Peg9, Peg10, Peg11, Peg12, Peg13, Peg14);
        // set up the clicks
        circles.forEach(circle -> {
            Peg newPeg = new Peg(circle);

            pegs.put(newPeg.getId(), newPeg);
            newPeg.updateCircle();
            circle.setOnMouseClicked(event -> {
                Circle clicked = (Circle) event.getSource();
                String id = clicked.getId();

                pegClicked(id);
            });
        });
    }

    /*
    This method is meant to go through each peg and checks the surrounding pegs to determine if there are any valid moves.
    If there are no pegs next to it, you can assume no moves for that peg.
     */
    void endGame() {

        pegs.forEach((key, peg) -> {
            boolean cond1 = false;
            boolean cond2 = false;
            boolean cond3 = false;
            boolean cond4 = false;
            int row = peg.getRow();
            int column = peg.getColumn();


            if (peg.isEmpty) {
                empty.add(peg);
            }


            String pegid1 = (row) + "-" + (column + 1);
            String pegid2 = (row + 1) + "-" + (column);
            String pegid3 = (row - 1) + "-" + (column);
            String pegid4 = (row) + "-" + (column - 1);

            if (peg.getRow() == 0) {
                if (pegs.get(pegid1).isEmpty || pegs.get(pegid1).getRow() >= 0 & pegs.get(pegid1).getRow() <= 4 &
                        pegs.get(pegid1).getColumn() >= 0 & pegs.get(pegid1).getColumn() <= 4) {
                    cond1 = true;
                }
            } else if (peg.getRow() == 1) {

                if (pegs.get(pegid2).isEmpty || pegs.get(pegid2).getRow() >= 0 & pegs.get(pegid2).getRow() <= 4 &
                        pegs.get(pegid2).getColumn() >= 0 & pegs.get(pegid2).getColumn() <= 3) {
                    cond2 = true;
                }
            } else if (peg.getRow() == 2) {
                if (pegs.get(pegid3).isEmpty || pegs.get(pegid3).getRow() >= 0 & pegs.get(pegid3).getRow() <= 4 &
                        pegs.get(pegid3).getColumn() >= 0 & pegs.get(pegid3).getColumn() <= 2) {
                    cond3 = true;
                }
            } else if (peg.getRow() == 3) {
                if (pegs.get(pegid4).isEmpty || pegs.get(pegid4).getRow() >= 0 & pegs.get(pegid4).getRow() <= 4 &
                        pegs.get(pegid4).getColumn() >= 0 & pegs.get(pegid4).getColumn() <= 1) {
                    cond4 = true;

                }
            } else if (peg.getRow() == 4) {
                if (pegs.get(pegid4).isEmpty || pegs.get(pegid4).getRow() >= 0 & pegs.get(pegid4).getRow() <= 4 &
                        pegs.get(pegid4).getColumn() >= 0 & pegs.get(pegid4).getColumn() <= 0) {
                    cond4 = true;
                }
            }
            if (cond1 == true & cond2 == true & cond3 == true & cond4 == true) {
                System.out.print("banans");
            }
            /*
            // Check right (+1 to row)
            int row = peg.getRow();
            int column = peg.getColumn();

            // check left (-1 to row) where row is greater than or equal to 0)
            int plusID = row + 1;
            int negRow = row - 1;
            int plusCol = column + 1;
            int negCol = column - 1;

            if (peg.getId().isEmpty() )

            // diagonal (+1, +1) row and column where row and column is positive or 0 or row <= 4 column <= 5

            // diagonal left (-1, +1) row and column

            // diagonal leftDown (-1, -1) row and column

            // diagonal rightDown (+1, -1) row and column

            // check above (+1 to column)

            // check below (-1 to column)


            if (first.getRow()  & first.getColumn() != second.getColumn()) {
                maxColumn = Math.max(first.getColumn(), second.getColumn());
                maxColumn -= 1;
                maxRow = first.getRow();
            } else if (first.getRow() != second.getRow() & first.getColumn() == second.getColumn()) {
                maxRow = Math.max(first.getRow(), second.getRow());
                maxRow -= 1;
                maxColumn = first.getColumn();
            } else {
                maxRow = Math.max(first.getRow(), second.getRow());
                maxColumn = Math.max(first.getColumn(), second.getColumn());
                maxColumn -= 1;
                maxRow -= 1;
            }

            String pegid = maxRow + "-" +maxColumn;

            Peg middlePeg = pegs.get(pegid);

            if (middlePeg == null) {
                // we should not really get here
                System.out.println(pegid);
            }
            return middlePeg;
        });

         if (empty.size() == 14) {
             System.out.print("We made it");
         }
        */
        });
    }
}
