package model.shapes;

import configuration.Configuration;

import java.awt.*;

/**
 *  The StraightLineVector class is used to create straight lines. It extends the ShapeVector basic class.
 *  @author: 210017984
 */
public class StraightLineVector extends ShapeVector {
    
    // Points of the straight line.
    private Point start, end;

    /**
     * Constructor for a new straight line.
     *
     * @param colour   the colour that the shape will have. Uses the Java's Colour class.
     * @param thickness the thickness of the vector.
     * @param isFilled if the shape is filled or not.
     * @param start the starting point.
     * @param end the ending point.
     */
    public StraightLineVector(Color colour, int thickness, boolean isFilled, Point start, Point end) {
        super(colour, thickness, isFilled);
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
     * Get ending point.
     * @return point.
     */
    public Point getEnd() {
        return end;
    }

    /**
     * Returns the type of vector.
     * @return type of line.
     */
    @Override
    public String getType() {
        return Configuration.LINE;
    }
}
