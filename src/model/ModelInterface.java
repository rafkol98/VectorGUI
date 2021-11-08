package model;

import java.awt.*;
import java.beans.PropertyChangeListener;

public interface ModelInterface {

    void addObserver(PropertyChangeListener listener);

    void changeColor(Color color);

    void createShapeSelected(String selectedShape);

    void undo();

    void redo();


}
