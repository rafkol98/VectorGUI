package delegate;

import model.Model;
import model.shapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Stack;

import static configuration.Configuration.*;

/**
 * The VectorBoard class is used to create a board/panel where the user can draw shapes.
 *
 * @author: 210017984
 */
public class VectorBoard extends JPanel implements MouseListener, MouseMotionListener, PropertyChangeListener, Serializable {

    private static final long serialVersionUID = 6529685098267757690L;

    // Initialise variables.
    private Model model;
    private String selectedShapeType;

    private Stack<ShapeVector> shapesList;

    private Color color;

    boolean isFilled;

    private int thickness;

    private Point start, end;

    /**
     * Creates a new board for the vectors to be drawn.
     *
     * @param model the model used.
     */
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

    /**
     * Adds all the components drawn by the user in the GUI.
     *
     * @param g allows to draw onto components.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set color of panel.
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Iterate through shapes.
        for (ShapeVector shape : shapesList) {
            // Draw shape.
            drawShape((Graphics2D) g, shape);
        }
    }

    /**
     * Draw shape depending on its type.
     *
     * @param g     the graphics.
     * @param shape the shape to be drawn.
     */
    private void drawShape(Graphics2D g, ShapeVector shape) {
        // Set color as the color of the current shape.
        g.setColor(shape.getColour());
        g.setStroke(new BasicStroke(shape.getThickness()));

        if (shape != null) {
            // Create shape depending on shape type.
            switch (shape.getType()) {
                case LINE:
                    if (shape.getStart() != null && shape.getEnd() != null) {
                        g.drawLine(shape.getStart().x, shape.getStart().y, shape.getEnd().x, shape.getEnd().y);
                    }
                    break;

                case RECTANGLE:
                    // Check if its filled.
                    if (shape.getStart() != null && shape.getEnd() != null && ((TwoDimensionalShapeVector) shape).getWidth() > 0 && ((TwoDimensionalShapeVector) shape).getHeight() > 0) {
                        if (shape.isFilled()) {
                            g.fillRect(shape.getStart().x, shape.getStart().y, ((TwoDimensionalShapeVector) shape).getWidth(), ((TwoDimensionalShapeVector) shape).getHeight());
                        } else {
                            g.drawRect(shape.getStart().x, shape.getStart().y, ((TwoDimensionalShapeVector) shape).getWidth(), ((TwoDimensionalShapeVector) shape).getHeight());
                        }
                    }
                    break;

                case ELLIPSE:
                    // Check if its filled.
                    if (shape.getStart() != null && shape.getEnd() != null && ((TwoDimensionalShapeVector) shape).getWidth() > 0 && ((TwoDimensionalShapeVector) shape).getHeight() > 0) {
                        if (shape.isFilled()) {
                            g.fillOval(shape.getStart().x, shape.getStart().y, ((TwoDimensionalShapeVector) shape).getWidth(), ((TwoDimensionalShapeVector) shape).getHeight());
                        } else {
                            g.drawOval(shape.getStart().x, shape.getStart().y, ((TwoDimensionalShapeVector) shape).getWidth(), ((TwoDimensionalShapeVector) shape).getHeight());
                        }
                    }
                    break;

                case CROSS:
                    if (shape.getStart() != null && shape.getEnd() != null && ((CrossVector) shape).getReverseStart() != null && ((CrossVector) shape).getReverseStart() != null) {
                        g.drawLine(shape.getStart().x, shape.getStart().y, shape.getEnd().x, shape.getEnd().y);
                        g.drawLine(((CrossVector) shape).getReverseStart().x, ((CrossVector) shape).getReverseStart().y, ((CrossVector) shape).getReverseEnd().x, ((CrossVector) shape).getReverseEnd().y);
                    }
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

            if (evt.getPropertyName().equals("changeThickness")) {
                // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        thickness = (int) evt.getNewValue();
                    }
                });
            }

            if (evt.getPropertyName().equals("drawShapes")) {
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

    /**
     * Called when the mouse is pressed.
     *
     * @param e the mouse event that caused the method to be called.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        start = e.getPoint();
    }

    /**
     * Called when the mouse is dragged.
     *
     * @param e the mouse event that caused the method to be called.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        end = e.getPoint();
    }

    /**
     * Called when the mouse is released.
     *
     * @param e the mouse event that caused the method to be called.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        // Check if selected shape is rectangle or ellipse.
        if (selectedShapeType == RECTANGLE || selectedShapeType == ELLIPSE) {
            // if shift is down then create square or circle.
            if (e.isShiftDown()) {
                model.createVector(selectedShapeType, thickness, color, isFilled, start, end, true);
            }
            // if shift is not down then create rectangle or ellipse.
            else {
                model.createVector(selectedShapeType, thickness, color, isFilled, start, end, false);
            }
        }
        // Create all other shapes.
        else {
            model.createVector(selectedShapeType, thickness, color, isFilled, start, end, false);
        }
    }

    /**
     * Called when the mouse is entered into the component.
     *
     * @param e the mouse event that caused the method to be called.
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Called when the mouse exited the component.
     *
     * @param e the mouse event that caused the method to be called.
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Called when the mouse is moved.
     *
     * @param e the mouse event that caused the method to be called.
     */
    @Override
    public void mouseMoved(MouseEvent e) {

    }

    /**
     * Sets the shape list.
     *
     * @param shapesList the shapes list for the shapesList to be updated to.
     */
    public void setShapesList(Stack<ShapeVector> shapesList) {
        this.shapesList = shapesList;
        repaint();
    }

    /**
     * Sets the model.
     *
     * @param model the model to be updated to.
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Gets the model.
     *
     * @return the model.
     */
    public Model getModel() {
        return model;
    }
}
