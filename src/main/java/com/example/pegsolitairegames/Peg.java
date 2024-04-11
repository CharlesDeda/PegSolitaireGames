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

}
