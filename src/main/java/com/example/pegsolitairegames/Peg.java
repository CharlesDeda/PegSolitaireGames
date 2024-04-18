package com.example.pegsolitairegames;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

// This is our data structure to keep together the ui peg and some state that goes with it.
public class Peg {
    public int row;
    public String id;
    public int column;
    public Circle circle;

    public boolean isSelected = false;

    // the first peg is empty
    // and a peg becomes empty or not as we play the game
    // initially they are all not empty
    public boolean isEmpty = false;
    // this will be of the shape 1-1 or x-y
    // the x token is the row, the y token is the column

    public Peg(Circle circle) {
        this.circle = circle;
        this.row = Integer.parseInt("0" + circle.getId().charAt(0));
        this.column = Integer.parseInt("0" + circle.getId().charAt(2));
    }
    public String getId() {
        return circle.getId();
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
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


}
