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
import java.util.Stack;

import static main.Configuration.*;

public class VectorBoard extends JPanel implements MouseListener, MouseMotionListener, PropertyChangeListener {

    private Model model;
    private String selectedShapeType;

    private Stack<ShapeVector> shapesList;

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
        this.shapesList = new Stack<>();
        isFilled = false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set color of panel.
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (ShapeVector shape : shapesList) {
            // Draw shape.
            drawShape(g, shape);
        }

    }

    /**
     * Draw shape depending on its type.
     * @param g the graphics.
     * @param shape the shape to be drawn.
     */
    private void drawShape(Graphics g, ShapeVector shape) {
        // Set color as the color of the current shape.
        g.setColor(shape.getColour());

        // Create shape depending on shape type.
        switch (shape.getType()) {
            case LINE:
                g.drawLine(((StraightLineVector) shape).getStart().x, ((StraightLineVector) shape).getStart().y, ((StraightLineVector) shape).getEnd().x, ((StraightLineVector) shape).getEnd().y);
                break;

            case RECTANGLE:
            case SQUARE:
                // Check if its filled.
                if (shape.isFilled()) {
                    g.fillRect(shape.getStart().x, shape.getStart().y, ((TwoDimensionalShapeVector) shape).getWidth(), ((TwoDimensionalShapeVector) shape).getHeight());
                } else {
                    g.drawRect(shape.getStart().x, shape.getStart().y, ((TwoDimensionalShapeVector) shape).getWidth(), ((TwoDimensionalShapeVector) shape).getHeight());
                }
                break;

            case ELLIPSE:
                // Check if its filled.
                if (shape.isFilled()) {
                    g.fillOval(shape.getStart().x, shape.getStart().y, ((TwoDimensionalShapeVector) shape).getWidth(), ((TwoDimensionalShapeVector) shape).getHeight());
                } else {
                    g.drawOval(shape.getStart().x, shape.getStart().y, ((TwoDimensionalShapeVector) shape).getWidth(), ((TwoDimensionalShapeVector) shape).getHeight());
                }
                break;

            case CROSS:
                g.drawLine(((CrossVector) shape).getStart().x, ((CrossVector) shape).getStart().y, ((CrossVector) shape).getEnd().x, ((CrossVector) shape).getEnd().y);
                g.drawLine(((CrossVector) shape).getReverseStart().x, ((CrossVector) shape).getReverseStart().y, ((CrossVector) shape).getReverseEnd().x, ((CrossVector) shape).getReverseEnd().y);
                break;
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
        if (evt.getSource() == model) {
            if (evt.getPropertyName().equals("selectedShape")) {
                // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        selectedShapeType = (String) evt.getNewValue();
                    }
                });
            }

            if (evt.getPropertyName().equals("changeColor")) {
                // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        color = (Color) evt.getNewValue();
                    }
                });
            }

            if (evt.getPropertyName().equals("changeFillValue")) {
                // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        isFilled = (Boolean) evt.getNewValue();
                    }
                });
            }

            if (evt.getPropertyName().equals("newShape")) {
                // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        shapesList = (Stack<ShapeVector>) evt.getNewValue();
                        repaint();
                    }
                });
            }
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
