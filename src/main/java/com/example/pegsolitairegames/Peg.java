package com.example.pegsolitairegames;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/*
 This is our data structure to keep together the ui peg and some state that goes with it.
 Peg contains 6 instance variables, row, column, id, circle, isSelected, and isEmpty
 Id is the ID of a circle in the scenebuilder UI, and from this we extrapolate the row and column numbers.
 isSelected indicates when a peg is clicked on, or stationary
 isEmpty indicates if a peg on the board does not exist and can be moved to
 */
public class Peg {

    public int row;
    public int column;

    public Circle circle;

    public boolean isSelected = false;

    public boolean isEmpty = false;


    public Peg(Circle circle) {
        this.circle = circle;
        this.row = Integer.parseInt("0" + circle.getId().charAt(0));
        this.column = Integer.parseInt("0" + circle.getId().charAt(2));
    }

    public String getId() {
        return circle.getId();
    }




    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void toggle() {
        isSelected = !isSelected;
    }

    /*
    getColor returns a color based on the state of the peg
     */
    private Color getColor() {
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

    /*
    Update circle changes the color of a peg based on its current state
     */
    public void updateCircle() {
        circle.setFill(this.getColor());
    }


}
