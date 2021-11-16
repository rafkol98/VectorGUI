package model;

import model.shapes.CrossVector;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CrossTest {

    CrossVector crossVector = new CrossVector(Color.RED, 10, true, new Point(50,10), new Point(15, 40));

    @Test
    public void getReverseStart() {
        assertNotNull(crossVector.getReverseStart());
        assertEquals(50, crossVector.getReverseStart().x);
        assertEquals(40, crossVector.getReverseStart().y);
    }

    @Test
    public void getReverseEnd() {
        assertNotNull(crossVector.getReverseEnd());
        assertEquals(15, crossVector.getReverseEnd().x);
        assertEquals(10, crossVector.getReverseEnd().y);
    }

}
