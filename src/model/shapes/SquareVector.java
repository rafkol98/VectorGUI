package model.shapes;

import java.awt.*;

public class SquareVector extends QuadrilateralVector {
    /**
     * Constructor for a new VectorShape.
     *
     * @param shapeType          the unique shapeType of the shape.
     * @param colour      the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled    if the shape is filled or not.
     * @param topLeft
     * @param bottomLeft
     * @param topRight
     * @param bottomRight
     */
    public SquareVector(String shapeType, Color colour, boolean isFilled, Point topLeft, Point bottomLeft, Point topRight, Point bottomRight) {
        super(shapeType, colour, isFilled, topLeft, bottomLeft, topRight, bottomRight);
    }


}
