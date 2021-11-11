//package model.shapes;
//
//import main.Configuration;
//
//import java.awt.*;
//
//public class SquareVector extends TwoDimensionalShapeVector {
//
//    /**
//     * Constructor for a new VectorShape.
//     *
//     * @param colour   the colour that the shape will have. Uses the Java's Colour class.
//     * @param isFilled if the shape is filled or not.
//     * @param one
//     * @param two
//     */
//    public SquareVector(Color colour, boolean isFilled, Point one, Point two) {
//        super(colour, isFilled, one, two);
//    }
//
//    @Override
//    public String getType() {
//        return Configuration.SQUARE;
//    }
//
//    /**
//     * Get height returns get width - square has equal width and height.
//     * @return height of the square.
//     */
//    @Override
//    public int getHeight() {
//        return getWidth();
//    }
//
//}
