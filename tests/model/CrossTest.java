package model;

import model.shapes.CrossVector;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CrossTest {

    private CrossVector crossVector = new CrossVector(Color.RED, 10, true, new Point(50,10), new Point(15, 40));

    /**
     * Test that the getReverseStart method works properly.
     */
    @Test
    public void getReverseStart() {
        System.out.println("CrossTest - Testing getReverseStart");
        assertNotNull(crossVector.getReverseStart());
        assertEquals(50, crossVector.getReverseStart().x);
        assertEquals(40, crossVector.getReverseStart().y);
    }

    /**
     * Test that the getReverseEnd method works properly.
     */
    @Test
    public void getReverseEnd() {
        System.out.println("CrossTest - Testing getReverseEnd");
        assertNotNull(crossVector.getReverseEnd());
        assertEquals(15, crossVector.getReverseEnd().x);
        assertEquals(10, crossVector.getReverseEnd().y);
    }

}
