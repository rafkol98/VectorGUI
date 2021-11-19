package tests;

import configuration.Configuration;
import model.Model;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ModelTest {
    private static Model model;
    private Color color = Color.BLACK;

    /**
     * Setup before each test.
     */
    @Before
    public void setup() {
        // Initialise the model.
        model = new Model();
    }

    /**
     * Test that the changeColor functionality of the model works.
     */
    @Test
    public void changeColor() {
        System.out.println("ModelTest - Testing changeColor");
        // Change color of model.
        model.changeColor(Color.pink);

        // Check that the color is not black.
        assertNotEquals(color, model.getColor());
        // Check that the color is the one assigned.
        assertEquals(Color.pink, model.getColor());
    }

    /**
     * Test that the selectShape functionality of the model works.
     */
    @Test
    public void selectShape() {
        System.out.println("ModelTest - Testing selectShape");
        // Select shape of model.
        model.selectShape(Configuration.CROSS);
        // Check that the color is not line.
        assertNotEquals(Configuration.LINE, model.getCurrentSelectedShape());
        // Check that the color is a cross.
        assertEquals(Configuration.CROSS, model.getCurrentSelectedShape());
    }


    /**
     * Test that the changeFillValue functionality of the model works.
     */
    @Test
    public void changeFillValue() {
        System.out.println("ModelTest - Testing changeFillValue");
        // Check if model has filling - it should return false.
        assertFalse(model.getHasFill());
        // change fill value.
        model.changeFillValue();
        assertTrue(model.getHasFill());
    }

    /**
     * Test that the changeThickness functionality of the model works.
     */
    @Test
    public void changeThickness() {
        System.out.println("ModelTest - Testing changeThickness");
        // Initialise the model.
        model = new Model();
        // Check that thickness is not 15.
        assertNotEquals(model.getThickness(), 15);
        // Change thickness value to 15.
        model.changeThickness(15);
        // Check that thickness is 15.
        assertEquals(model.getThickness(), 15);
    }

    /**
     * Test that the createVector functionality of the model works.
     */
    @Test
    public void createVector() {
        System.out.println("ModelTest - Testing createVector");
        // Check that there are not shapes currently in the stack.
        assertEquals(0, model.getShapes().size());
        // Create a new vector.
        model.createVector(Configuration.LINE, 10, Color.blue, true, new Point(10,10), new Point(20, 20), false);
        // Check that the vector was added to the stack.
        assertEquals(1, model.getShapes().size());
    }

    /**
     * Test that the undo functionality of the model works.
     */
    @Test
    public void undo() {
        System.out.println("ModelTest - Testing undo");
        model.createVector(Configuration.ELLIPSE, 5, Color.red, false, new Point(40,20), new Point(60, 10), true);
        // check that the new vector was added.
        assertEquals(1, model.getShapes().size());
        // Undo action.
        model.undo();
        // Check that the action of adding the new shape was undone - there are 0 shapes in the stack.
        assertEquals(0, model.getShapes().size());
    }

    /**
     * Test that the redo functionality of the model works.
     */
    @Test
    public void redo() {
        System.out.println("ModelTest - Testing redo");
        // Create a new vector.
        model.createVector(Configuration.ELLIPSE, 5, Color.red, false, new Point(40,20), new Point(60, 10), true);
        // check that the new vector was added.
        assertEquals(1, model.getShapes().size());
        // Undo action.
        model.undo();
        // Check that the action of adding the new shape was undone - there are 0 shapes in the stack.
        assertEquals(0, model.getShapes().size());
        // Redo action.
        model.redo();
        // Check that the shape was readded due to the redo.
        assertEquals(1, model.getShapes().size());
    }

}
