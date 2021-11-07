package model.shapes;

import java.awt.*;

public class VectorShape {

    // Initialise shape variables.
    private String id;
    private Color colour;
    private boolean isFilled;

    /**
     * Constructor for a new VectorShape.
     * @param id the unique id of the shape.
     * @param colour the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled if the shape is filled or not.
     */
    public VectorShape(String id, Color colour, boolean isFilled) {
        this.id = id;
        this.colour = colour;
        this.isFilled = isFilled;
    }

    /**
     * Get shape's id.
     * @return id of shape.
     */
    public String getId() {
        return id;
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
}
