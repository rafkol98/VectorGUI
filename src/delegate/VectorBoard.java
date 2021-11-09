package delegate;

import main.Configuration;
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
    private ShapeVector shapeVector;

    // Initialise vectors.
    private StraightLineVector straightLineVector;
    private RectangleVector rectangleVector;
    private SquareVector squareVector;
    private EllipseVector ellipseVector;

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
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("MESA");
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());


        for (ShapeVector shape : shapesList) {
            System.out.println("STO FOR LOOP");
            // Set color as the color of the current shape.
            g.setColor(shape.getColour());

            // Create shape depending on shape type.
            switch (shape.getType()) {
                case LINE:
                    // Set color to color selected.
                    g.drawLine(((StraightLineVector) shape).getStart().x, ((StraightLineVector) shape).getStart().y, ((StraightLineVector) shape).getEnd().x, ((StraightLineVector) shape).getEnd().y);
                    break;

                case RECTANGLE:
                    System.out.println("Sto REC!");
                    System.out.println(((RectangleVector) shape).getWidth() +" "+((RectangleVector) shape).getHeight());
                    g.drawRect(((RectangleVector) shape).getStart().x, ((RectangleVector) shape).getStart().y, ((RectangleVector) shape).getWidth(), ((RectangleVector) shape).getHeight());
                    break;

                case SQUARE:
                    System.out.println("sto square");
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
                    System.out.println("RUNNING shape");
                    selectedShapeType = (String) evt.getNewValue();
                }
            });
        }

        if (evt.getSource() == model && evt.getPropertyName().equals("changeColor")) {
            // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    color = (Color) evt.getNewValue();
                    System.out.println(color.toString());
                }
            });
        }

        if (evt.getSource() == model && evt.getPropertyName().equals("newShape")) {
            // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    System.out.println("RUNNING new shape");
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
//        switch (selectedShapeType) {
//            case LINE:
//
//                straightLineVector = new StraightLineVector(color, true, e.getPoint(), new Point());
//                break;
//
//            case RECTANGLE:
//                rectangleVector = new RectangleVector(color, true, e.getPoint(), new Point());
//                break;
//
//            case SQUARE:
//                squareVector = new SquareVector(color, true, e.getPoint(), new Point());
//                break;
//
//            case ELLIPSE:
//                ellipseVector = new EllipseVector(color, true, e.getPoint(), new Point());
//                break;
//
//        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        end = e.getPoint();
//        switch (selectedShapeType) {
//            case LINE:
//                straightLineVector.setEnd(e.getPoint());
//                break;
//
//            case RECTANGLE:
//                rectangleVector.setEnd(e.getPoint());
//                break;
//
//            case SQUARE:
//                squareVector.setEnd(e.getPoint());
//                break;
//
//            case ELLIPSE:
//                ellipseVector.setEnd(e.getPoint());
//                break;
//
//        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        model.createVector(selectedShapeType, color, true, start, end);

//        switch (selectedShapeType) {
//            case LINE:
//
//                shapesList.add(straightLineVector);
//                model.addVector(straightLineVector);
//                break;
//
//            case RECTANGLE:
//                shapesList.add(rectangleVector);
//                model.addVector(rectangleVector);
//                break;
//
//            case SQUARE:
//                //TODO fix this!
//                squareVector.setHeight(squareVector.getWidth());
//                System.out.println(squareVector.getHeight() +" "+ squareVector.getWidth());
//                shapesList.add(squareVector);
//                break;
//
//            case ELLIPSE:
//                shapesList.add(ellipseVector);
//                model.addVector(ellipseVector);
//                break;
//        }
//        repaint();
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
