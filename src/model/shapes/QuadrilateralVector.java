package model.shapes;

import main.Configuration;

import java.awt.*;

public abstract class QuadrilateralVector extends ShapeVector {


    private int height, width;

    /**
     * Constructor for a new VectorShape.
     *
     * @param colour   the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled if the shape is filled or not.
     * @param one
     * @param two
     */
    public QuadrilateralVector(Color colour, boolean isFilled, Point one, Point two) {
        super(colour, isFilled, one, two);
    }

//    public QuadrilateralVector(Color colour, boolean isFilled, Point one, Point two) {
//        super(colour, isFilled);
//        this.one = one;
//        this.two = two;
//        start = new Point();
//        end = new Point();
//    }



//    private void calculateStartEnd() {
//        if(one.x > two.x) {
//            start.x = two.x;
//            end.x = one.x;
//        } else {
//            start.x = one.x;
//            end.x = two.x;
//        }
//        if(one.y > two.y) {
//            start.y =  two.y;
//            end.y = one.y;
//        } else {
//            start.y = one.y;
//            end.y = two.y;
//        }
//    }


    //TODO: problem with direction
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
