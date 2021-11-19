package model.shapes;

import java.awt.*;

/**
 *  The ShapeInterface is used to enforce some functions that all the shapes should have.
 *  @author: 210017984
 */
public interface ShapeInterface {

    /**
     * Calculates the starting point depending on from which direction the user drew the shapes.
     */
    void calculateStartingPoint();

    /**
     * Calculates the ending point depending on from which direction the user drew the shapes.
     */
    void calculateEndingPoint();

    /**
     * Gets starting point of shape.
     * @return point of shape.
     */
    Point getStart();

    /**
     * Gets ending point of shape.
     * @return point of shape.
     */
    Point getEnd();

    /**
     * Gets colour of shape.
     * @return the colour of the shape.
     */
    Color getColour();

    /**
     * Gets isFilled.
     * @return whether the shape is filled.
     */
    boolean isFilled();
}
