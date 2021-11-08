package model.shapes;

import main.Configuration;

import java.awt.*;

public class SquareVector extends QuadrilateralVector {

    /**
     *
     * @param colour
     * @param isFilled
     * @param start
     * @param end
     */
    public SquareVector(Color colour, boolean isFilled, Point start, Point end) {
        super(colour, isFilled, start, end);
        // Set height the same as width.
        setHeight(getWidth());
    }



    @Override
    public String getType() {
        return Configuration.SQUARE;
    }

}
