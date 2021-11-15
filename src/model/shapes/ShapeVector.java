package model.shapes;

import java.awt.*;


public abstract class ShapeVector implements ShapeInterface {

    // Initialise shape variables.
    private Color colour;
    private int thickness;
    private boolean isFilled;
    private Point one, two, start, end;

    /**
     * Constructor for a new VectorShape - used for line and cross vectors.
     * @param colour the colour that the shape will have. Uses the Java's Colour class.
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
        calculateStartEnd();
    }

    /**
     * Calculates the start and end points of the shape.
     */
    public void calculateStartEnd() {
        if(one.x > two.x) {
            start.x = two.x;
            end.x = one.x;
        } else {
            start.x = one.x;
            end.x = two.x;
        }
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
     * Get type of shape.
     * @return type of shape.
     */
    public abstract String getType();

}
