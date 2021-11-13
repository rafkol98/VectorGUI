package model.shapes;

import java.awt.*;

/**
 *  The ShapeInterface is used to enforce some functions that all the shapes should have.
 *  @author: 210017984
 */
public interface ShapeInterface {

    void calculateStartEnd();

    Point getStart();

    Point getEnd();

    Color getColour();

    boolean isFilled();
}
