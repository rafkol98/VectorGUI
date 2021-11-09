package model;

import model.shapes.*;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import static main.Configuration.*;

public class Model implements ModelInterface{

    private String currentSelectedShape;

    /** The change support object to help us fire change events at observers */
    private PropertyChangeSupport notifier;

    private ArrayList<ShapeVector> shapes;
    private Color color;

    public Model() {
        notifier = new PropertyChangeSupport(this);
        shapes = new ArrayList<>();
        color = Color.BLACK;
    }

    @Override
    public void addObserver(PropertyChangeListener listener) {
        notifier.addPropertyChangeListener(listener);
    }

    @Override
    public void changeColor(Color color) {
        Color oldColor = this.color;
        // Set new color selected as color.
        this.color = color;
        notifier.firePropertyChange("changeColor", oldColor, color);
    }

    @Override
    public void selectShape(String selectedShape) {
        // Make oldSelectedShape have the current value of currentSelectedShape
        String oldSelectedShape = currentSelectedShape;
        // Assign currentSelectedShape to be the new selectedShape passed in.
        currentSelectedShape = selectedShape;
        notifier.firePropertyChange("selectedShape", oldSelectedShape, currentSelectedShape);
    }

//    public void addVector(ShapeVector shapeVector) {
//        // Add vector to shapes list.
//        shapes.add(shapeVector);
//    }

    public void createVector(String type, Color colour, boolean isFilled, Point one, Point two) {

        ArrayList<ShapeVector> oldShapes = (ArrayList<ShapeVector>) shapes.clone();
        ShapeVector shapeVector;


        switch (type) {
            case LINE:
                System.out.println("HERE createVector");
                shapeVector = new StraightLineVector(color, true, one, two);
                shapes.add(shapeVector);
                break;

            case RECTANGLE:
                shapeVector = new RectangleVector(color, true, one, two);
                shapes.add(shapeVector);
                break;

            case SQUARE:
                shapeVector = new SquareVector(color, true, one, two);
                shapes.add(shapeVector);
                break;

            case ELLIPSE:
                shapeVector = new EllipseVector(color, true, one, two);
                shapes.add(shapeVector);
                break;
        }


        notifier.firePropertyChange("newShape", oldShapes, shapes);

    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
