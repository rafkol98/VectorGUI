package model.shapes;

import java.awt.*;

public class VectorSquare extends VectorQuadrilateral {
    /**
     * Constructor for a new VectorShape.
     *
     * @param id          the unique id of the shape.
     * @param colour      the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled    if the shape is filled or not.
     * @param topLeft
     * @param bottomLeft
     * @param topRight
     * @param bottomRight
     */
    public VectorSquare(String id, Color colour, boolean isFilled, Point topLeft, Point bottomLeft, Point topRight, Point bottomRight) {
        super(id, colour, isFilled, topLeft, bottomLeft, topRight, bottomRight);
    }
}
