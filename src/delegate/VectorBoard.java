package delegate;

import model.Model;
import model.shapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static main.Configuration.*;

public class VectorBoard extends JPanel implements MouseListener, MouseMotionListener, PropertyChangeListener {

    private Model model;
    private String selectedShapeType;

    private ArrayList<ShapeVector> shapesList;

    private Color color;

    boolean isFilled;

    Point start, end;

    public VectorBoard(Model model) {
        this.model = model;
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setVisible(true);
        this.setBackground(Color.WHITE);
        this.model.addObserver(this);
        this.color = Color.BLACK;
        this.selectedShapeType = LINE;
        this.shapesList = new ArrayList<>();
        isFilled = false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set color of panel.
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());


        for (ShapeVector shape : shapesList) {
            // Set color as the color of the current shape.
            g.setColor(shape.getColour());

            // Create shape depending on shape type.
            switch (shape.getType()) {
                case LINE:
                    // Set color to color selected.
                    g.drawLine(((StraightLineVector) shape).getStart().x, ((StraightLineVector) shape).getStart().y, ((StraightLineVector) shape).getEnd().x, ((StraightLineVector) shape).getEnd().y);
                    break;

                case RECTANGLE:
                    if (shape.isFilled()) {
                        g.fillRect(((RectangleVector) shape).getStart().x, ((RectangleVector) shape).getStart().y, ((RectangleVector) shape).getWidth(), ((RectangleVector) shape).getHeight());
                    } else {
                        g.drawRect(((RectangleVector) shape).getStart().x, ((RectangleVector) shape).getStart().y, ((RectangleVector) shape).getWidth(), ((RectangleVector) shape).getHeight());
                    }
                    break;

                case SQUARE:
                    g.drawRect(((SquareVector) shape).getStart().x, ((SquareVector) shape).getStart().y, ((SquareVector) shape).getWidth(), ((SquareVector) shape).getHeight());
                    break;

                case ELLIPSE:
                    g.drawOval(((EllipseVector) shape).getStart().x, ((EllipseVector) shape).getStart().y, ((EllipseVector) shape).getWidth(), ((EllipseVector) shape).getHeight());
                    break;
            }

        }

    }

    /**
     * This method contains code to update the GUI view when the model changes.
     * The method is called when the model changes (i.e. when the model executes notifier.firePropertyChange)
     *
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == model && evt.getPropertyName().equals("selectedShape")) {
            // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    selectedShapeType = (String) evt.getNewValue();
                }
            });
        }

        if (evt.getSource() == model && evt.getPropertyName().equals("changeColor")) {
            // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    color = (Color) evt.getNewValue();
                }
            });
        }

        if (evt.getSource() == model && evt.getPropertyName().equals("changeFillValue")) {
            // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                     isFilled = (Boolean) evt.getNewValue();
                }
            });
        }


        if (evt.getSource() == model && evt.getPropertyName().equals("newShape")) {
            // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    shapesList = (ArrayList<ShapeVector>) evt.getNewValue();
                    repaint();
                }
            });
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        start = e.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        end = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        model.createVector(selectedShapeType, color, isFilled, start, end);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


}
