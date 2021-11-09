package model;

import java.awt.*;
import java.beans.PropertyChangeListener;

public interface ModelInterface {

    void addObserver(PropertyChangeListener listener);

    void changeColor(Color color);

    void selectShape(String selectedShape);

    void createVector(String type, Color colour, boolean isFilled, Point one, Point two);

    void undo();

    void redo();


}
