package model.shapes;

import java.awt.*;

public class VectorQuadrilateral extends VectorShape {

    private Point topLeft, bottomLeft, topRight, bottomRight;

    /**
     * Constructor for a new VectorShape.
     *
     * @param id       the unique id of the shape.
     * @param colour   the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled if the shape is filled or not.
     */
    public VectorQuadrilateral(String id, Color colour, boolean isFilled, Point topLeft, Point bottomLeft, Point topRight, Point bottomRight) {
        super(id, colour, isFilled);
        this.topLeft = topLeft;
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        this.bottomRight = bottomRight;

    }

    /**
     * Get the top left point.
     * @return top left point of quadrilateral.
     */
    public Point getTopLeft() {
        return topLeft;
    }

    /**
     * Set the top left point.
     */
    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    /**
     * Get the bottom left point.
     * @return bottom left point of quadrilateral.
     */
    public Point getBottomLeft() {
        return bottomLeft;
    }

    /**
     * Set the bottom left point.
     */
    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    /**
     * Get the top right point.
     * @return top right point of quadrilateral.
     */
    public Point getTopRight() {
        return topRight;
    }

    /**
     * Set the top right point.
     */
    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }


    /**
     * Get the bottom right point.
     * @return bottom right point of quadrilateral.
     */
    public Point getBottomRight() {
        return bottomRight;
    }

    /**
     * Set bottom right right point.
     */
    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }
}
