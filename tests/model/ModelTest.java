package model;

import model.shapes.ShapeVector;
import model.shapes.StraightLineVector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    private Model model;
    private ArrayList<ShapeVector> shapeVectors;
//    Model model;
//    A shapeVectors;
    private Color color = Color.BLACK;


    //TODO: CHECK THAT NOTIFIERS ARE BEING FIRED!
    @Test
    public void addObserver() {
    }

    @Test
    public void changeColor() {
        model = new Model();
        model.changeColor(Color.pink);

        // Check that the color is not black.
        assertNotEquals(color, model.getColor());
        // Check that the color is the one assigned.
        assertEquals(Color.pink, model.getColor());
    }

    @Test
    public void selectShape() {

    }

    @Test
    public void changeFillValue() {
    }

    @Test
    public void createVector() {
    }

    @Test
    public void undo() {
    }

    @Test
    public void redo() {
    }

    @Test
    public void getHasFill() {
    }
}