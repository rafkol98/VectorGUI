package model;

import java.awt.*;
import java.beans.PropertyChangeListener;

/**
 * The ModelInterface is used to initialise methods that the model should implement.
 * @author: 210017984
 */
public interface ModelInterface {

    void addObserver(PropertyChangeListener listener);

    void changeColor(Color color);

    void changeThickness(int thickness);

    void selectShape(String selectedShape);

    void createVector(String type, int thickness, Color colour, boolean isFilled, Point one, Point two);

    void undo();

    void redo();


}
