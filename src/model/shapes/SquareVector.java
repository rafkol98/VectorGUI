package model.shapes;

import java.awt.*;

public class SquareVector extends QuadrilateralVector {

    /**
     *
     * @param shapeType
     * @param colour
     * @param isFilled
     * @param start
     * @param end
     */
    public SquareVector(String shapeType, Color colour, boolean isFilled, Point start, Point end) {
        super(shapeType, colour, isFilled, start, end);
    }

}
