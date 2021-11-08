package model.shapes;

import java.awt.*;

public class ShapeVector {

    // Initialise shape variables.
    private String shapeType;
    private Color colour;
    private boolean isFilled;

    /**
     * Constructor for a new VectorShape.
     * @param shapeType the unique id of the shape.
     * @param colour the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled if the shape is filled or not.
     */
    public ShapeVector(String shapeType, Color colour, boolean isFilled) {
        this.shapeType = shapeType;
        this.colour = colour;
        this.isFilled = isFilled;
    }

    /**
     * Get shape's id.
     * @return id of shape.
     */
    public String getShapeType() {
        return shapeType;
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
