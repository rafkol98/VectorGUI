package model;

import model.shapes.*;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Stack;

import static main.Configuration.*;

public class Model implements ModelInterface{

    private String currentSelectedShape;

    /** The change support object to help us fire change events at observers */
    private PropertyChangeSupport notifier;

    private Stack<ShapeVector> shapes;
    private Color color;
    private boolean hasFill;

    // Used to store the removed item from the stack.
    private ShapeVector removed;


    /**
     * Create new Model. Setup the initial values.
     */
    public Model() {
        notifier = new PropertyChangeSupport(this);
        shapes = new Stack<>();
        color = Color.BLACK;
        hasFill = false;
    }


    /**
     * Add observer to the property change listener.
     * @param listener A "PropertyChange" event gets fired whenever a bean changes a "bound" property.
     */
    @Override
    public void addObserver(PropertyChangeListener listener) {
        notifier.addPropertyChangeListener(listener);
    }

    /**
     * Changes color used.
     * @param color selected by the user.
     */
    @Override
    public void changeColor(Color color) {
        Color oldColor = this.color;
        // Set new color selected as color.
        this.color = color;
        notifier.firePropertyChange("changeColor", oldColor, color);
    }

    /**
     * Selects shape to be created.
     * @param selectedShape the type of the selected shape.
     */
    @Override
    public void selectShape(String selectedShape) {
        if(selectedShape.equalsIgnoreCase(LINE) || selectedShape.equalsIgnoreCase(RECTANGLE) || selectedShape.equalsIgnoreCase(SQUARE) || selectedShape.equalsIgnoreCase(ELLIPSE) || selectedShape.equalsIgnoreCase(CROSS)) {
            // Make oldSelectedShape have the current value of currentSelectedShape
            String oldSelectedShape = currentSelectedShape;
            // Assign currentSelectedShape to be the new selectedShape passed in.
            currentSelectedShape = selectedShape;
            notifier.firePropertyChange("selectedShape", oldSelectedShape, currentSelectedShape);
        }
    }

    /**
     * Toggles hasFill value. If its false make it true and vice versa. Used to create shapes with or withouf filling.
     */
    public void changeFillValue() {
        hasFill = !hasFill;
        System.out.println(hasFill);
        notifier.firePropertyChange("changeFillValue", !hasFill, hasFill);
    }

    /**
     * Creates a vector based on the parameters passed in. This vector is then sent to an interface with firePropertyChange.
     * @param type the type of vector.
     * @param colour the colour of the vector to be created.
     * @param isFilled whether the vector should be filled.
     * @param one the first point.
     * @param two the second point.
     */
    @Override
    public void createVector(String type, Color colour, boolean isFilled, Point one, Point two) {

        Stack<ShapeVector> oldShapes = (Stack<ShapeVector>) shapes.clone();
        ShapeVector shapeVector = null;

        switch (type) {
            case LINE:
                shapeVector = new StraightLineVector(color, isFilled, one, two);
                break;

            case RECTANGLE:
                shapeVector = new RectangleVector(color, isFilled, one, two);
                break;

            case SQUARE:
                shapeVector = new SquareVector(color, isFilled, one, two);
                break;

            case ELLIPSE:
                shapeVector = new EllipseVector(color, isFilled, one, two);
                break;

            case CROSS:
                shapeVector = new CrossVector(colour, isFilled, one, two);
                break;
        }

        // if shapeVector is not null then add it to the shapes list and fire property change.
        if (shapeVector != null) {
            shapes.push(shapeVector);
            notifier.firePropertyChange("newShape", oldShapes, shapes);
        }

    }

    @Override
    public void undo() {

        // Check if shapes stack is not empty.
        if (!shapes.empty()) {
            Stack<ShapeVector> oldShapes = (Stack<ShapeVector>) shapes.clone();
            // Take out the last element of the stack and assign it to the removed variable.
            removed = shapes.pop();
            notifier.firePropertyChange("newShape", oldShapes, shapes);
        }
    }

    @Override
    public void redo() {
        // Check that removed has a shape initialised.
        if (removed != null) {
            Stack<ShapeVector> oldShapes = (Stack<ShapeVector>) shapes.clone();
            // Push the removed shape back to the stack.
            shapes.push(removed);
            // Assign null to the removed ShapeVector.
            removed = null;
            notifier.firePropertyChange("newShape", oldShapes, shapes);
        }
    }

    public boolean getHasFill() {
        return hasFill;
    }
}
