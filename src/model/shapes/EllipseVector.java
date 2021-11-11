package model.shapes;

import main.Configuration;

import java.awt.*;

public class EllipseVector extends TwoDimensionalShapeVector{

    private boolean circle;
    /**
     * Constructor for a new EllipseVector.
     *
     * @param colour   the colour that the shape will have. Uses the Java's Colour class.
     * @param isFilled if the shape is filled or not.
     * @param one      the first point the user clicked.
     * @param two      the second point the user dragged until.
     */
    public EllipseVector(Color colour, boolean isFilled, Point one, Point two, boolean cirle) {
        super(colour, isFilled, one, two);
        this.circle = cirle;
    }

    //TODO: set might be more correct!
    @Override
    public int getHeight() {
        // If the ellipse is circle then
        if (circle) {
            return getWidth();
        } else {
            return super.getHeight();
        }
    }

    @Override
    public String getType() {
        return Configuration.ELLIPSE;
    }
}
