package model;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model implements ModelInterface{


    /** The change support object to help us fire change events at observers */
    private PropertyChangeSupport notifier;


    @Override
    public void addObserver(PropertyChangeListener listener) {
        notifier.addPropertyChangeListener(listener);
    }

    @Override
    public void changeColor(Color color) {

    }

    @Override
    public void createShapeSelected(String selectedShape) {
        switch (selectedShape) {

        }

    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
