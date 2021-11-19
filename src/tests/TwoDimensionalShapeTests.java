package tests;

import model.shapes.CrossVector;
import model.shapes.EllipseVector;
import model.shapes.RectangleVector;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TwoDimensionalShapeTests {
    private RectangleVector squareVector = new RectangleVector(Color.BLUE, 5, false, new Point(10,10), new Point(50, 50), true);
    private EllipseVector ellipseVector = new EllipseVector(Color.RED, 10, true, new Point(50,10), new Point(15, 40), false);

    /**
     * Tests that the getHeight method works as expected.
     */
    @Test
    public void getHeight() {
        System.out.println("TwoDimensionalShapeTests - Testing getHeight");
        assertNotNull(squareVector.getHeight());
        assertEquals(40, squareVector.getHeight());

        assertNotNull(ellipseVector.getHeight());
        assertEquals(30, ellipseVector.getHeight());
    }

    /**
     * Tests that the getWidth method works as expected.
     */
    @Test
    public void getWidth() {
        System.out.println("TwoDimensionalShapeTests - Testing getWidth");
        assertNotNull(squareVector.getWidth());
        assertEquals(40, squareVector.getWidth());

        assertNotNull(ellipseVector.getWidth());
        assertEquals(35, ellipseVector.getWidth());
    }
}