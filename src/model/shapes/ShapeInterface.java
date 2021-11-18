package model.shapes;

import java.awt.*;

/**
 *  The ShapeInterface is used to enforce some functions that all the shapes should have.
 *  @author: 210017984
 */
public interface ShapeInterface {

    /**
     * Calculate start and end points.
     */
    void calculateStartEnd();

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
