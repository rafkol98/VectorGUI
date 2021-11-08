package model.shapes;

import main.Configuration;

import java.awt.*;

public abstract class QuadrilateralVector extends ShapeVector {


    private int height, width;
    private Point start, end;

    /**
     * Constructor for a new VectorShape.
     *
     * @param colour   the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled if the shape is filled or not.
     */
    public QuadrilateralVector(Color colour, boolean isFilled, Point start, Point end) {
        super(colour, isFilled);
        this.start = start;
        this.end = end;
    }

    /**
     * Get the top left point.
     * @return top left point of quadrilateral.
     */
    public Point getStart() {
        return start;
    }

    /**
     * Set the top left point.
     */
    public void setStart(Point start) {
        this.start = start;
    }

    /**
     * Get the bottom left point.
     * @return bottom left point of quadrilateral.
     */
    public Point getEnd() {
        return end;
    }

    /**
     * Set the bottom left point.
     */
    public void setEnd(Point end) {
        this.end = end;
    }

    public int getHeight() {
        height = Math.abs(end.y - start.y);
        return height;
    }

    public int getWidth() {
        width = Math.abs(end.x - start.x);
        return width;
    }

    @Override
    public abstract String getType();
}
