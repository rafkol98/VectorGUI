package delegate;

import main.Configuration;
import model.Model;
import model.shapes.RectangleVector;
import model.shapes.ShapeVector;
import model.shapes.StraightLineVector;

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
//    private boolean hasFilling;

    // Initialise vectors.
    private StraightLineVector straightLineVector;
    private RectangleVector rectangleVector;

    public VectorBoard(Model model) {
        this.model = model;
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setVisible(true);
        this.setBackground(Color.WHITE);
        this.model.addObserver(this);
        this.color = Color.BLACK;
        selectedShapeType = LINE;
        shapesList = new ArrayList<>();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("MESA");
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(), getHeight());


        for (ShapeVector shape : shapesList) {
            System.out.println(shapesList.size());
            // TODO: CHANGE TO COLOR.
            g.setColor(Color.black);
            System.out.println("DAME called");
            switch(shape.getShapeType()) {
                case LINE:
                    g.drawLine(((StraightLineVector) shape).getStart().x, ((StraightLineVector) shape).getStart().y, ((StraightLineVector) shape).getEnd().x, ((StraightLineVector) shape).getEnd().y );
                    break;

                case RECTANGLE:
                    System.out.println("sto rec");
                    g.drawRect(((RectangleVector) shape).getStart().x, ((RectangleVector) shape).getStart().y, ((RectangleVector) shape).getWidth(), ((RectangleVector) shape).getHeight() );
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
        if(evt.getSource() == model && evt.getPropertyName().equals("selectedShape")) {
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
        switch (selectedShapeType) {
            case LINE:
                straightLineVector = new StraightLineVector(LINE, Color.BLACK,true, e.getPoint(), new Point());
                break;

            case RECTANGLE:
                System.out.println("REC called");
                rectangleVector = new RectangleVector(RECTANGLE, Color.BLACK,true, e.getPoint(), new Point());
                break;

        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (selectedShapeType) {
            case LINE:
                straightLineVector.setEnd(e.getPoint());
                break;

            case RECTANGLE:
                rectangleVector.setEnd(e.getPoint());
                break;

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (selectedShapeType) {
            case LINE:
                shapesList.add(straightLineVector);
                model.addVector(straightLineVector);
                break;

            case RECTANGLE:
                shapesList.add(rectangleVector);
                model.addVector(rectangleVector);
                break;
        }
        repaint();
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
