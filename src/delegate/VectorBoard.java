package delegate;

import model.Model;
import model.shapes.StraightLineVector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VectorBoard extends JPanel implements MouseListener, MouseMotionListener, PropertyChangeListener {

    private Model model;
    private String selectedShapeType;

    private Color color;
//    private boolean hasFilling;

    // Initialise vectors.
    private StraightLineVector straightLineVector;

    public VectorBoard(Model model) {
        this.model = model;
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setVisible(true);
        this.setBackground(Color.red);
        this.color = Color.BLACK;
    }


    /**
     * This method contains code to update the GUI view when the model changes.
     * The method is called when the model changes (i.e. when the model executes notifier.firePropertyChange)
     *
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getSource() == model && evt.getPropertyName().equals("SelectedShape")) {
            // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
            SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    selectedShapeType = (String) evt.getNewValue();
                }
            });
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


}
