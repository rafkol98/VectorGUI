package delegate;

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
    private JButton buttonColour, buttonFill, buttonUndo, buttonRedo, buttonLine, buttonRectangle, buttonSquare, buttonEllipse, buttonCircle, buttonDiagonalCross;
    private JMenuBar menu;

    private final ImageIcon fillEmptyImgIcon = new ImageIcon(new ImageIcon("Icons/filling-empty.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));


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

        //Make the center component big, since that's the
        //typical usage of BorderLayout.
        VectorBoard vectorBoard = new VectorBoard(model);
        JButton button = new JButton("Button 2 (CENTER)");
        pane.add(vectorBoard, BorderLayout.CENTER);

    }

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
        ImageIcon colorImgIcon = new ImageIcon(new ImageIcon("Icons/color-circle.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        ImageIcon undoImgIcon = new ImageIcon(new ImageIcon("Icons/undo.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        ImageIcon redoImgIcon = new ImageIcon(new ImageIcon("Icons/redo.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        ImageIcon lineImgIcon = new ImageIcon(new ImageIcon("Icons/line.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        ImageIcon rectangleImgIcon = new ImageIcon(new ImageIcon("Icons/rectangle.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        ImageIcon squareImgIcon = new ImageIcon(new ImageIcon("Icons/square.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon ellipseImgIcon = new ImageIcon(new ImageIcon("Icons/ellipse.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        ImageIcon circleImgIcon = new ImageIcon(new ImageIcon("Icons/circle.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon diagonalCrossImgIcon = new ImageIcon(new ImageIcon("Icons/diagonal_cross.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

        // Create colour and fill button.
        buttonColour = new JButton(colorImgIcon);
        buttonFill = new JButton(fillEmptyImgIcon);

        // Create undo and redo buttons.
        buttonUndo = new JButton(undoImgIcon);
        buttonRedo = new JButton(redoImgIcon);
        // Create shapes buttons.
        buttonLine = new JButton(lineImgIcon);
        buttonRectangle = new JButton(rectangleImgIcon);

        buttonSquare = new JButton(squareImgIcon);
        buttonEllipse = new JButton(ellipseImgIcon);
        buttonCircle= new JButton(circleImgIcon);
        buttonDiagonalCross = new JButton(diagonalCrossImgIcon);

        // add buttons to the toolbar
        toolbar.add(buttonColour);
        toolbar.add(buttonFill);
        toolbar.add(buttonUndo);
        toolbar.add(buttonRedo);
        toolbar.add(buttonLine);
        toolbar.add(buttonRectangle);
        toolbar.add(buttonSquare);
        toolbar.add(buttonEllipse);
        toolbar.add(buttonCircle);
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
                    // Change color to selected.
                    model.changeColor(chosenColor);
                }
            }
        });

        buttonFill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Called");
                model.changeFillValue();
                // Update fill button image.
                updateFillButtonImage();
            }
        });


        // Undo button.
        buttonUndo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.undo();
            }
        });

        // Redo button.
        buttonRedo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.redo();
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

        // Draw new circle button.
        buttonCircle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.selectShape(CIRCLE);
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

    /**
     * Updates fill button image depending on whether the user clicked on the fill button.
     */
    public void updateFillButtonImage() {
        if (model.getHasFill()){
            ImageIcon fillImgIcon = new ImageIcon(new ImageIcon("Icons/filling.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            buttonFill.setIcon(fillImgIcon);
        } else {
            buttonFill.setIcon(fillEmptyImgIcon);
        }
    }

}
