package model.shapes;

import main.Configuration;

import java.awt.*;

public class RectangleVector extends TwoDimensionalShapeVector {

    /**
     * Constructor for a new VectorShape.
     *
     * @param colour   the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled if the shape is filled or not.
     * @param one
     * @param two
     */
    public RectangleVector(Color colour, boolean isFilled, Point one, Point two) {
        super(colour, isFilled, one, two);
    }


    @Override
    public String getType() {
        return Configuration.RECTANGLE;
    }
}
