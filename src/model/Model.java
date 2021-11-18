package model;

import model.shapes.*;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Stack;

import static configuration.Configuration.*;

/**
 * The Model class does all the operations for the program.
 * @author: 210017984
 */
public class Model implements ModelInterface, Serializable {

    private static final long serialVersionUID = 6529685098267757690L;

    private String currentSelectedShape;

    /** The change support object to help us fire change events at observers */
    private PropertyChangeSupport notifier;

    private Stack<ShapeVector> shapes;
    private Color color;
    private int thickness;
    private boolean hasFill;

    // Used to store the removed item from the stack.
    private ShapeVector removed;


    /**
     * Create new Model. Setup the initial values.
     */
    public Model() {
        notifier = new PropertyChangeSupport(this);
        shapes = new Stack<>();

        // Default values.
        color = Color.BLACK;
        currentSelectedShape = LINE;
        hasFill = false;
        thickness = 1;
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
     * Changes thickness.
     */
    @Override
    public void changeThickness(int thickness) {
        int oldThickness = this.thickness;
        // Set new color selected as color.
        this.thickness = thickness;
        notifier.firePropertyChange("changeThickness", oldThickness, thickness);
    }

    /**
     * Selects shape to be created.
     * @param selectedShape the type of the selected shape.
     */
    @Override
    public void selectShape(String selectedShape) {
        if(selectedShape.equalsIgnoreCase(LINE) || selectedShape.equalsIgnoreCase(RECTANGLE) || selectedShape.equalsIgnoreCase(SQUARE) || selectedShape.equalsIgnoreCase(ELLIPSE) || selectedShape.equalsIgnoreCase(CIRCLE) || selectedShape.equalsIgnoreCase(CROSS)) {
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
    public void createVector(String type, int thickness, Color colour, boolean isFilled, Point one, Point two) {

        Stack<ShapeVector> oldShapes = (Stack<ShapeVector>) shapes.clone();
        ShapeVector shapeVector = null;

        switch (type) {
            case LINE:
                shapeVector = new StraightLineVector(color, thickness, isFilled, one, two);
                break;

            case RECTANGLE:
                shapeVector = new RectangleVector(color, thickness, isFilled, one, two, false);
                break;

            case SQUARE:
                shapeVector = new RectangleVector(color, thickness, isFilled, one, two, true);
                break;

            case ELLIPSE:
                shapeVector = new EllipseVector(color, thickness, isFilled, one, two, false);
                break;

            case CIRCLE:
                shapeVector = new EllipseVector(color, thickness, isFilled, one, two, true);
                break;

            case CROSS:
                shapeVector = new CrossVector(colour, thickness, isFilled, one, two);
                break;
        }

        // if shapeVector is not null then add it to the shapes list and fire property change.
        if (shapeVector != null) {
            shapes.push(shapeVector);
            notifier.firePropertyChange("newShape", oldShapes, shapes);
        }

    }

    /**
     * The function is used to undo a recently done operation.
     * E.g.: undo the drawing of an ellipse.
     */
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

    /**
     * The function is used to redo a recently undone operation.
     * E.g.: Redo the drawing of an ellipse that was undone.
     */
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


    /**
     * Clear the canvas.
     */
    public void clear() {
        Stack<ShapeVector> oldShapes = (Stack<ShapeVector>) shapes.clone();
        shapes.clear();
        notifier.firePropertyChange("newShape", oldShapes, shapes);
    }

    /**
     * Saves the state of the model.
     */
    public void saveState() {
        notifier.firePropertyChange("save", null, null);
    }

    /**
     * Loads the state of the model.
     */
    public void loadState() {
        notifier.firePropertyChange("load", null, null);
    }


    public void setShapesList(Stack<ShapeVector> shapesList) {
        shapes = shapesList;
    }


    /**
     * Returns whether the items to be painted should have fill or not.
     * @return if the item to be drawn should be filled.
     */
    public boolean getHasFill() {
        return hasFill;
    }

    /**
     * Gets current thickness selected.
     * @return thickness selected.
     */
    public int getThickness() {
        return thickness;
    }

    /**
     * Gets the current color selected.
     * @return current color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets current shape selected.
     * @return shape selected.
     */
    public String getCurrentSelectedShape() {
        return currentSelectedShape;
    }

    /**
     * Gets shapes of model.
     * @return the shapes.
     */
    public Stack<ShapeVector> getShapes() {
        return shapes;
    }
}
