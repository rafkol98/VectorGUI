package model.shapes;

import configuration.Configuration;

import java.awt.*;

/**
 * The EllipseVector class has all the methods and behaviour for ellipse vectors that can be drawn
 * in the GUI. It extends the two dimensional shape vector class since it has common behaviour with other
 * two dimensional shape vectors.
 * @author: 210017984
 */
public class EllipseVector extends TwoDimensionalShapeVector{

    private boolean circle;
    /**
     * Constructor for a new EllipseVector.
     *
     * @param colour   the colour that the shape will have. Uses the Java's Colour class.
     * @param thickness the thickness of the vector.
     * @param isFilled if the shape is filled or not.
     * @param one      the first point the user clicked.
     * @param two      the second point the user dragged until.
     */
    public EllipseVector(Color colour, int thickness, boolean isFilled, Point one, Point two, boolean cirle) {
        super(colour, thickness, isFilled, one, two);
        this.circle = cirle;
    }

    /**
     * Returns height of the ellipse.
     * If its a circle, then return width as height (have to be the same size).
     * @return height of ellipse.
     */
    @Override
    public int getHeight() {
        // If the ellipse is circle then
        if (circle) {
            return getWidth();
        } else {
            return super.getHeight();
        }
    }

    /**
     * Returns the type of vector.
     * @return type of ellipse.
     */
    @Override
    public String getType() {
        return Configuration.ELLIPSE;
    }
}
