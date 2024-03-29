package model.shapes;

import java.awt.*;
import java.io.Serializable;

/**
 * The ShapeVector class has all methods that all shapes share.
 * @author: 210017984
 */
public abstract class ShapeVector implements ShapeInterface, Serializable {

    /**
     * Serializable id.
     */
    private static final long serialVersionUID = 6529685098267757690L;

    // Initialise shape variables.
    private Color colour;
    private int thickness;
    private boolean isFilled;
    private Point one, two, start, end;

    /**
     * Constructor for a new VectorShape - used for line and cross vectors.
     * @param colour the colour that the shape will have. Uses the Java's Colour class.
     * @param thickness the thickness of the vector.
     * @param isFilled if the shape is filled or not.
     */
    public ShapeVector(Color colour, int thickness, boolean isFilled) {
        this.colour = colour;
        this.thickness = thickness;
        this.isFilled = isFilled;
    }

    /**
     *  Constructor for a new VectorShape.
     * @param colour the colour that the shape will have. Uses the Java's Colour class.
     * @param thickness the thickness of the vector.
     * @param isFilled if the shape is filled or not.
     * @param one the first point the user clicked.
     * @param two the second point the user dragged until.
     */
    public ShapeVector(Color colour, int thickness, boolean isFilled, Point one, Point two) {
        this.colour = colour;
        this.thickness = thickness;
        this.isFilled = isFilled;
        this.one = one;
        this.two = two;

        start = new Point();
        end = new Point();
        // Calculate start and end points.
        calculateStartingPoint();
        calculateEndingPoint();
    }


    /**
     * Calculates the starting point depending on from which direction the user drew the shapes.
     */
    public void calculateStartingPoint() {
        if(one.x > two.x) {
            start.x = two.x;
            end.x = one.x;
        } else {
            start.x = one.x;
            end.x = two.x;
        }
    }

    /**
     * Calculates the ending point depending on from which direction the user drew the shapes.
     */
    public void calculateEndingPoint() {
        if(one.y > two.y) {
            start.y =  two.y;
            end.y = one.y;
        } else {
            start.y = one.y;
            end.y = two.y;
        }
    }

    public int getThickness() {
        return thickness;
    }

    /**
     * Get the top left point.
     * @return top left point of quadrilateral.
     */
    public Point getStart() {
        return start;
    }

    /**
     * Get the bottom left point.
     * @return bottom left point of quadrilateral.
     */
    public Point getEnd() {
        return end;
    }

    /**
     * Get shape's colour.
     * @return colour of shape.
     */
    public Color getColour() {
        return colour;
    }

    /**
     * Get if a shape is filled or not.
     * @return boolean if its filled.
     */
    public boolean isFilled() {
        return isFilled;
    }

    /**
     * Get type of vector.
     * @return type of shape.
     */
    public abstract String getType();





}
