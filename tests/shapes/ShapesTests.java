package shapes;

import configuration.Configuration;
import model.shapes.EllipseVector;
import model.shapes.StraightLineVector;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ShapesTests {

    private StraightLineVector straightLineVector = new StraightLineVector(Color.CYAN, 10, false, new Point(10,10), new Point(15, 40));
    private EllipseVector ellipseVector = new EllipseVector(Color.RED, 10, true, new Point(50,10), new Point(15, 40), false);


    /**
     * Test the getThickness method.
     */
    @Test
    public void getThickness() {
        // Check that the thickness of the line is 10.
        assertEquals(10, straightLineVector.getThickness());
    }

    /**
     * Test the getStart point method.
     */
    @Test
    public void getStart() {
        System.out.println("ShapesTests - Testing getStart");
        // Assert that the start point of the line is not null.
        assertNotNull(straightLineVector.getStart());
        Point start = straightLineVector.getStart();
        assertEquals(10, start.x);
        assertEquals(10, start.y);

        // Check for ellipse vector - here the start is supposed to have the x of point two and y of point one
        // (as they are the smallest).
        Point ellipseStart = ellipseVector.getStart();
        assertEquals(15, ellipseStart.x);
        assertEquals(10, ellipseStart.y);
    }

    /**
     * Test the getEnd point method.
     */
    @Test
    public void getEnd() {
        System.out.println("ShapesTests - Testing getEnd");
        // Assert that the start point of the line is not null.
        assertNotNull(straightLineVector.getEnd());
        Point end = straightLineVector.getEnd();
        assertEquals(15, end.x);
        assertEquals(40, end.y);

        // Check for ellipse vector - here the start is supposed to have the x of point two and y of point one
        // (as they are the smallest).
        Point ellipseStart = ellipseVector.getEnd();
        assertEquals(50, ellipseStart.x);
        assertEquals(40, ellipseStart.y);
    }


    /**
     * Test the getColour method.
     */
    @Test
    public void getColour() {
        System.out.println("ShapesTests - Testing getColour");
        assertNotNull(straightLineVector.getColour());
        assertEquals(Color.CYAN, straightLineVector.getColour());

        assertNotNull(ellipseVector.getColour());
        assertEquals(Color.RED, ellipseVector.getColour());
    }

    /**
     * Test the isFilled method.
     */
    @Test
    public void isFilled() {
        System.out.println("ShapesTests - Testing isFilled");
        assertNotNull(straightLineVector.isFilled());
        assertEquals(false, straightLineVector.isFilled());

        assertNotNull(ellipseVector.getColour());
        assertEquals(true , ellipseVector.isFilled());
    }

    /**
     * Test the getType method.
     */
    @Test
    public void getType() {
        System.out.println("ShapesTests - Testing getType");
        assertNotNull(straightLineVector.getType());
        assertEquals(Configuration.LINE, straightLineVector.getType());

        assertNotNull(ellipseVector.getColour());
        assertEquals(Configuration.ELLIPSE , ellipseVector.getType());
    }

}
