package model.shapes;

import java.awt.*;

/**
 *  The TwoDimensionalShapeVector class holds methods that all 2D shapes in this program share.
 *  It extends the ShapeVector class.
 *  @author: 210017984
 */
public abstract class TwoDimensionalShapeVector extends ShapeVector {

    /**
     * Constructor for a new VectorShape.
     *
     * @param colour   the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled if the shape is filled or not.
     * @param one the first point the user clicked.
     * @param two the second point the user dragged until.
     */
    public TwoDimensionalShapeVector(Color colour, int thickness, boolean isFilled, Point one, Point two) {
        super(colour, thickness, isFilled, one, two);
    }

    /**
     * Calculates and returns the height of a 2D shape.
     * @return height of shape.
     */
    public int getHeight() {
        return getEnd().y - getStart().y;
    }

    /**
     * Calculates and returns the width of a 2D shape.
     * @return width of shape.
     */
    public int getWidth() {
        return getEnd().x - getStart().x;
    }

    /**
     * Abstract class that enforces the classes that extend TwoDimensionalShapeVector class
     * to implement a method that returns the type of shape.
     * @return type of shape.
     */
    @Override
    public abstract String getType();


}
