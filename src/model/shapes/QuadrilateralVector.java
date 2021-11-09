package model.shapes;

import main.Configuration;

import java.awt.*;

public abstract class QuadrilateralVector extends ShapeVector {


    private int height, width;
    private Point one, two, start, end;

    /**
     * Constructor for a new VectorShape.
     *
     * @param colour   the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled if the shape is filled or not.
     */
    public QuadrilateralVector(Color colour, boolean isFilled, Point one, Point two) {
        super(colour, isFilled);
        this.one = one;
        this.two = two;
        start = new Point();
        end = new Point();
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
        one = start;
        calculateStartEnd();
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
        two = end;
        calculateStartEnd();
    }

    private void calculateStartEnd() {

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


    //TODO: problem with direction
    public int getHeight() {
        int tempY;
        if(start.y > end.y) {
            tempY = start.y;
            start.y =  end.y;
            end.y = tempY;
        }

        height = Math.abs(end.y - start.y);
        return height;
    }

    public int getWidth() {
        int tempX;
        if(start.x > end.x) {
            tempX = start.x;

            start.x =  end.x;
            end.x = tempX;
        }

        width = end.x - start.x;
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
        System.out.println(height+" ,, "+width);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public abstract String getType();
}
