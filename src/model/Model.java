package model;

import model.shapes.ShapeVector;
import model.shapes.StraightLineVector;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

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

    }

    @Override
    public void selectShape(String selectedShape) {
        // Make oldSelectedShape have the current value of currentSelectedShape
        String oldSelectedShape = currentSelectedShape;
        // Assign currentSelectedShape to be the new selectedShape passed in.
        currentSelectedShape = selectedShape;
        notifier.firePropertyChange("selectedShape", oldSelectedShape, currentSelectedShape);
    }

    public void createStraightLineVector(Point start, Point end) {
        ArrayList<ShapeVector> oldShapes = (ArrayList<ShapeVector>) shapes.clone();
        StraightLineVector line = new StraightLineVector(currentSelectedShape, color, true, start, end);
        shapes.add(line);
//        notifier.firePropertyChange("CreateShape", oldShapes, shapes);
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
