package delegate;

import main.Configuration;
import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static main.Configuration.*;

public class Delegate extends JFrame implements PropertyChangeListener {

    private static final int FRAME_HEIGHT = 800;
    private static final int FRAME_WIDTH = 1000;

    private JFrame mainFrame;

    private JToolBar toolbar;
    private JButton buttonColour, buttonUndo, buttonRedo, buttonLine, buttonRectangle, buttonSquare, buttonEllipse, buttonDiagonalCross;
    private JMenuBar menu;

    private Model model;

    public Delegate(Model model) {
        this.model = model;
        setupFrame();

    }

    public void setupFrame() {
        this.mainFrame = new JFrame();
        mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        addComponentsToPane(mainFrame.getContentPane());
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);

    }


    public void addComponentsToPane(Container pane) {

        setupToolBar();
        pane.add(toolbar, BorderLayout.NORTH);

        // TODO: replace with main GUI components
        //Make the center component big, since that's the
        //typical usage of BorderLayout.
        VectorBoard vectorBoard = new VectorBoard(model);
        JButton button = new JButton("Button 2 (CENTER)");
        pane.add(vectorBoard, BorderLayout.CENTER);

    }

    //TODO: maybe toolbar in another class?

    /**
     * Set's up the toolbar.
     */
    private void setupToolBar() {
        // Initialise new toolbar.
        toolbar = new JToolBar();

        // add the buttons to the toolbar.
        createToolBarButtons();

        // add actions to the toolbar.
        addActionsToButtons();
    }

    /**
     * Creates all the buttons for the toolbar in an appropriate fashion.
     */
    private void createToolBarButtons() {
        // add icons to buttons.
        ImageIcon colorImgIcon = new ImageIcon(new ImageIcon("Icons/color-circle.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon undoImgIcon = new ImageIcon(new ImageIcon("Icons/undo.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon redoImgIcon = new ImageIcon(new ImageIcon("Icons/redo.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon lineImgIcon = new ImageIcon(new ImageIcon("Icons/line.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon rectangleImgIcon = new ImageIcon(new ImageIcon("Icons/rectangle.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon ellipseImgIcon = new ImageIcon(new ImageIcon("Icons/ellipse.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon diagonalCrossImgIcon = new ImageIcon(new ImageIcon("Icons/diagonal_cross.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

        // Create colour button.
        buttonColour = new JButton(colorImgIcon);
        // Create undo and redo buttons.
        buttonUndo = new JButton(undoImgIcon);
        buttonRedo = new JButton(redoImgIcon);
        // Create shapes buttons.
        buttonLine = new JButton(lineImgIcon);
        buttonRectangle = new JButton(rectangleImgIcon);
        //TODO: update this!
        buttonSquare = new JButton(rectangleImgIcon);
        buttonEllipse = new JButton(ellipseImgIcon);
        buttonDiagonalCross = new JButton(diagonalCrossImgIcon);

        // add buttons to the toolbar
        toolbar.add(buttonColour);
        toolbar.add(buttonUndo);
        toolbar.add(buttonRedo);
        toolbar.add(buttonLine);
        toolbar.add(buttonRectangle);
        toolbar.add(buttonSquare);
        toolbar.add(buttonEllipse);
        toolbar.add(buttonDiagonalCross);
    }

    /**
     * Add an action to each of the buttons in the toolbar.
     */
    private void addActionsToButtons() {
        // Button Colour action - show color palette.
        buttonColour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Select color from the color palette.
                Color chosenColor = JColorChooser.showDialog(Delegate.this, "Color Chooser", Color.BLACK);
                if (chosenColor != null) {
                    System.out.println("ALO");
                    // Change color to selected.
                    model.changeColor(chosenColor);
                }
            }
        });

        // Undo button.
        buttonUndo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Redo button.
        buttonRedo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Draw new line button.
        buttonLine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.selectShape(LINE);
            }
        });

        // Draw new rectangle button.
        buttonRectangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.selectShape(RECTANGLE);
            }
        });

        // Draw new square button.
        buttonSquare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.selectShape(SQUARE);
            }
        });

        // Draw new ellipse button.
        buttonEllipse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.selectShape(ELLIPSE);
            }
        });

        // Draw new diagonal cross button.
        buttonDiagonalCross.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.selectShape(CROSS);
            }
        });


    }



    /**
     * The method is called when the model changes (i.e. when the model executes notifier.firePropertyChange)
     *
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

}
