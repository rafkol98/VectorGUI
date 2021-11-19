package model;

import java.awt.*;
import java.beans.PropertyChangeListener;

/**
 * The ModelInterface is used to initialise methods that the model should implement.
 * @author: 210017984
 */
public interface ModelInterface {

    /**
     * Add observer to the property change listener.
     * @param listener A "PropertyChange" event gets fired whenever a bean changes a "bound" property.
     */
    void addObserver(PropertyChangeListener listener);

    /**
     * Changes color used.
     * @param color selected by the user.
     */
    void changeColor(Color color);

    /**
     * Changes selected thickness - used to make a shape to be drawn thicker or slimmer.
     */
    void changeThickness(int thickness);

    /**
     * Selects shape to be created.
     * @param selectedShape the type of the selected shape.
     */
    void selectShape(String selectedShape);

    /**
     * Toggles hasFill value. If its false make it true and vice versa. Used to create shapes with or without filling.
     */
    void changeFillValue();

    /**
     * Creates a vector based on the parameters passed in. This vector is then sent to an interface with firePropertyChange.
     * @param type the type of vector.
     * @param colour the colour of the vector to be created.
     * @param isFilled whether the vector should be filled.
     * @param one the first point.
     * @param two the second point.
     * @param shift if the shift button was pressed while drawing the item.
     */
    void createVector(String type, int thickness, Color colour, boolean isFilled, Point one, Point two, boolean shift);

    /**
     * The function is used to undo a recently done operation.
     * E.g.: undo the drawing of an ellipse.
     */
    void undo();

    /**
     * The function is used to redo a recently undone operation.
     * E.g.: Redo the drawing of an ellipse that was undone.
     */
    void redo();

    /**
     * The funtion is used to clear the canvas (remove all the shapes).
     */
    void clear();

    /**
     * Fires property to save the current state of the model.
     */
    void saveState();

    /**
     * Fires property to load a saved model.
     */
    void loadState();
}
