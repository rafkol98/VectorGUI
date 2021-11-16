package model.shapes;

import configuration.Configuration;

import java.awt.*;

/**
 *  The RectangleVector class is used to create rectangles. It extends the TwoDimensionalShapeVector
 *  class as it shares similar characteristics with other two dimensional shapes.
 *  @author: 210017984
 */
public class RectangleVector extends TwoDimensionalShapeVector {

    private boolean square;

    /**
     * Constructor for a new VectorShape.
     *
     * @param colour   the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled if the shape is filled or not.
     * @param one
     * @param two
     */
    public RectangleVector(Color colour, int thickness, boolean isFilled, Point one, Point two, boolean square) {
        super(colour, thickness, isFilled, one, two);
        this.square = square;
    }

    //TODO: set might be more correct!
    @Override
    public int getHeight() {
        // If the ellipse is circle then
        if (square) {
            return getWidth();
        } else {
            return super.getHeight();
        }
    }


    @Override
    public String getType() {
        return Configuration.RECTANGLE;
    }
}
