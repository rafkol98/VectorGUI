package model.shapes;

import main.Configuration;

import java.awt.*;

public abstract class TwoDimensionalShapeVector extends ShapeVector {


    private int height, width;

    /**
     * Constructor for a new VectorShape.
     *
     * @param colour   the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled if the shape is filled or not.
     * @param one the first point the user clicked.
     * @param two the second point the user dragged until.
     */
    public TwoDimensionalShapeVector(Color colour, boolean isFilled, Point one, Point two) {
        super(colour, isFilled, one, two);
    }

    public int getHeight() {
        return getEnd().y - getStart().y;
    }

    public int getWidth() {
        return getEnd().x - getStart().x;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public abstract String getType();


}
