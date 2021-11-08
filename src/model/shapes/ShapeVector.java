package model.shapes;

import java.awt.*;

public abstract class ShapeVector {

    // Initialise shape variables.
    private Color colour;
    private boolean isFilled;

    /**
     * Constructor for a new VectorShape.
     * @param colour the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled if the shape is filled or not.
     */
    public ShapeVector(Color colour, boolean isFilled) {
        this.colour = colour;
        this.isFilled = isFilled;
    }

    /**
     * Get shape's colour.
     * @return colour of shape.
     */
    public Color getColour() {
        return colour;
    }

    /**
     * Get if a shape is filled or not.
     * @return boolean if its filled.
     */
    public boolean isFilled() {
        return isFilled;
    }

    public abstract String getType();
}
