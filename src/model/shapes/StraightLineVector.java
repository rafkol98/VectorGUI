package model.shapes;

import java.awt.*;

public class StraightLineVector extends ShapeVector {
    
    // Points of the straight line.
    private Point start, end;

    /**
     * Constructor for a new straight line.
     *
     * @param shapeType       the unique shapeType of the shape.
     * @param colour   the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled if the shape is filled or not.
     */
    public StraightLineVector(String shapeType, Color colour, boolean isFilled, Point start, Point end) {
        super(shapeType, colour, isFilled);
        this.start = start;
        this.end = end;
    }

    /**
     * Get starting point.
     * @return point.
     */
    public Point getStart() {
        return start;
    }

    /**
     * Set the starting point - in case of change.
     * @param start the point to which start will be updated to.
     */
    public void setStart(Point start) {
        this.start = start;
    }

    /**
     * Get ending point.
     * @return point.
     */
    public Point getEnd() {
        return end;
    }

    /**
     * Set the ending point - in case of change.
     * @param end the point to which end will be updated to.
     */
    public void setEnd(Point end) {
        this.end = end;
    }
}
