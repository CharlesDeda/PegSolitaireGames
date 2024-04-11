package com.example.pegsolitairegames;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

// This is our data structure to keep together the ui peg and some state that goes with it.
public class Peg {
    public Circle circle;

    public boolean isSelected;

    public String getId() {
        return circle.getId();
    }

    public void toggle() {
        isSelected = !isSelected;
    }

    public Color getColor() {
        if (isSelected) {
            return Color.RED;
        } else {
            return Color.BLUE;
        }
    }

}
