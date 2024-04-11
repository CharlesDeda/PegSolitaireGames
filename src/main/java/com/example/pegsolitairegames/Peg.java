package com.example.pegsolitairegames;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

// This is our data structure to keep together the ui peg and some state that goes with it.
public class Peg {
    public Circle circle;

    public boolean isSelected = false;

    // the first peg is empty
    // and a peg becomes empty or not as we play the game
    // initially they are all not empty
    public boolean isEmpty = false;

    // this will be of the shape 1-1 or x-y
    // the x token is the row, the y token is the column
    public String getId() {
        return circle.getId();
    }

    public void toggle() {
        isSelected = !isSelected;
    }

    public Color getColor() {
        if (isEmpty) {
            return Color.WHITE;
        } else {
            if (isSelected) {
                return Color.RED;
            } else {
                return Color.BLUE;
            }
        }
    }

    public void updateCircle() {
        circle.setFill(this.getColor());
    }

    public static boolean validPeg(currPeg, endPeg, pegArr){
        currLoco = currPeg.getNum();
        //open being boolean var to see it its there
        for (int i = 0; i > pegArr.length(); i ++){ // idk if we need this loop. Probably same functionality without
            // example: (currPeg == 0 & (endPeg == 3 & pegArr[3] != None ) || (endPeg == 5 & pegArr[5] != None))
            if(pegArr[i] == 0 & endPeg == 3 || endPeg == 5) { // if taking off loop, change pegArr[i] to currPeg
                return true;                                  // also
            }
            elif (pegArr[i] == 1 & endPeg == 6 || endPeg == 8){
                return true;
            }
            elif (pegArr[i] == 2 & endPeg == 9 || endPeg == 7){
                return true;
            }
            elif (pegArr[i] == 3 & endPeg == 0 || endPeg == 5 || endPeg == 10 || endPeg == 12){
                return true;
            }
            elif (pegArr[i] == 4 & endPeg == 11 || endPeg == 13){
                return true;
            }
            elif (pegArr[i] == 5 & endPeg == 0 || endPeg == 3 || endPeg == 12 || endPeg == 14){
                return true;
            }
            elif (pegArr[i] == 6 & endPeg == 8 || endPeg == 1){
                return true;
            }
            elif (pegArr[i] == 7 & endPeg == 2 || endPeg == 9){
                return true;
            }
            elif (pegArr[i] == 8 & endPeg == 1 || endPeg == 6){
                return true;
            }
            elif (pegArr[i] == 9 & endPeg == 2 || endPeg == 7){
                return true;
            }
            elif (pegArr[i] == 10 & endPeg == 3 || endPeg ==  12){
                return true;
            }
            elif (pegArr[i] == 11 & endPeg == 4 || endPeg == 13){
                return true;
            }
            elif (pegArr[i] == 12 & endPeg == 3 || endPeg == 5 || endPeg == 10 || endPeg == 14){
                return true;
            }
            elif (pegArr[i] == 13 & endPeg == 4 || endPeg == 11) {
                return true;
            }
            elif (pegArr[i] == 14 & endPeg == 5 || endPeg == 12){
                return true;
            }

            return false;
        }

    }
}
