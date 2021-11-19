package model;


import model.shapes.EllipseVector;
import model.shapes.RectangleVector;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TwoDimensionalShapeTests {
    private RectangleVector squareVector = new RectangleVector(Color.BLUE, 5, false, new Point(10,10), new Point(50, 50), true);
    private EllipseVector ellipseVector = new EllipseVector(Color.RED, 10, true, new Point(50,10), new Point(15, 40), false);

    @Test
    public void getHeight() {
        assertNotNull(squareVector.getHeight());
        assertEquals(40, squareVector.getHeight());

        assertNotNull(ellipseVector.getHeight());
        assertEquals(30, ellipseVector.getHeight());
    }

    @Test
    public void getWidth() {
        assertNotNull(squareVector.getWidth());
        assertEquals(40, squareVector.getWidth());

        assertNotNull(ellipseVector.getWidth());
        assertEquals(35, ellipseVector.getWidth());
    }


}
