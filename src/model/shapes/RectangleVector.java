package model.shapes;

import main.Configuration;

import java.awt.*;

public class RectangleVector extends QuadrilateralVector {

    /**
     * Constructor for a new VectorShape.
     *
     * @param colour    the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled  if the shape is filled or not.
     * @param start
     * @param end
     */
    public RectangleVector(Color colour, boolean isFilled, Point start, Point end) {
        super(colour, isFilled, start, end);
    }

    @Override
    public String getType() {
        return Configuration.RECTANGLE;
    }
}
