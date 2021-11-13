package model.shapes;

import main.Configuration;

import java.awt.*;

/**
 * The CrossVector class has all the methods and behaviour for the cross vector that can be drawn
 * in the GUI.
 * @author: 210017984
 */
public class CrossVector extends ShapeVector{

    private Point start, end;

    /**
     * Creates a new diagonal cross vector.
     * @param colour the colour of the cross vector.
     * @param isFilled whether the cross vector is filled.
     * @param start the starting position of the cross vector.
     * @param end the ending position of the cross vector.
     */
    public CrossVector(Color colour, boolean isFilled, Point start, Point end) {
        super(colour, isFilled);
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
     * Get reverse starting point - used for the mirrored diagonal line.
     * @return point.
     */
    public Point getReverseStart() {
        Point reverseStart = new Point();
        reverseStart.x = start.x;
        reverseStart.y = end.y;
        return reverseStart;
    }

    /**
     * Get reverse ending point - used for the mirrored diagonal line.
     * @return point.
     */
    public Point getReverseEnd() {
        Point reverseEnd = new Point();
        reverseEnd.x = end.x;
        reverseEnd.y = start.y;
        return reverseEnd;
    }

    /**
     * Get type of the vector.
     * @return
     */
    @Override
    public String getType() {
        return Configuration.CROSS;
    }


}
