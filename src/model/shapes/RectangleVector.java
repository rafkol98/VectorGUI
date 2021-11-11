package model.shapes;

import main.Configuration;

import java.awt.*;

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
    public RectangleVector(Color colour, boolean isFilled, Point one, Point two, boolean square) {
        super(colour, isFilled, one, two);
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
