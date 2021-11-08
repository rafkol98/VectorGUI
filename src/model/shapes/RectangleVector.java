package model.shapes;

import java.awt.*;

public class RectangleVector extends QuadrilateralVector {

    /**
     * Constructor for a new VectorShape.
     *
     * @param shapeType the type of the shape.
     * @param colour    the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled  if the shape is filled or not.
     * @param start
     * @param end
     */
    public RectangleVector(String shapeType, Color colour, boolean isFilled, Point start, Point end) {
        super(shapeType, colour, isFilled, start, end);
    }
}
