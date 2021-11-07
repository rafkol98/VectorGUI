package delegate;

import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Delegate extends JFrame implements PropertyChangeListener {

    private static final int FRAME_HEIGHT = 800;
    private static final int FRAME_WIDTH = 1000;

    private JFrame mainFrame;

    private JToolBar toolbar;
    private JButton buttonColour, buttonUndo, buttonRedo, buttonLine, buttonRectangle, buttonEllipse, buttonDiagonalCross;
    private JMenuBar menu;

    private Model model;

    public Delegate(Model model) {
        this.model = model;
        setupFrame();

    }

    public void addComponentsToPane(Container pane) {

        // TODO: replace with Toolbar
        JButton button = new JButton("Button 1 (PAGE_START)");
        setupToolBar();
        pane.add(toolbar, BorderLayout.NORTH);

        // TODO: replace with main GUI components
        //Make the center component big, since that's the
        //typical usage of BorderLayout.
        button = new JButton("Button 2 (CENTER)");
//        button.setPreferredSize(new Dimension(200, 100));
        pane.add(button, BorderLayout.CENTER);


//        button = new JButton("Long-Named Button 4 (PAGE_END)");
//        pane.add(button, BorderLayout.PAGE_END);

    }

    private void setupToolBar() {
        // Initialise new toolbar.
        toolbar = new JToolBar();

        // add the buttons to the toolbar.
        createToolBarButtons();

        // add

        // add actions to the toolbar.
        addActionsToButtons();

    }

    /**
     *
     */
    private void createToolBarButtons() {
        // add icons to buttons.
        ImageIcon colorImgIcon = new ImageIcon(new ImageIcon("Icons/color-circle.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        // Create colour button.
        buttonColour = new JButton(colorImgIcon);
        // Create undo and redo buttons.
        buttonUndo = new JButton("Undo");
        buttonRedo = new JButton("Redo");
        // Create shapes buttons.
        buttonLine = new JButton("Line");
        buttonRectangle = new JButton("Rectangle");
        buttonEllipse = new JButton("Ellipse");
        buttonDiagonalCross = new JButton("DiagonalCross");

        // add buttons to the toolbar
        toolbar.add(buttonColour);
        toolbar.add(buttonUndo);
        toolbar.add(buttonRedo);
        toolbar.add(buttonLine);
        toolbar.add(buttonRectangle);
        toolbar.add(buttonEllipse);
        toolbar.add(buttonDiagonalCross);
    }

    /**
     * Add an action to each of the buttons in the toolbar.
     */
    private void addActionsToButtons() {
        // Button Colour action - show color palette.
        buttonColour.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Select color from the color palette.
                Color chosenColor = JColorChooser.showDialog(Delegate.this,"Color Chooser",Color.BLACK);
                if (chosenColor != null) {
                    // TODO: add chosenColor to model.
                }
            }
        });

//        buttonColour.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                // Select color from the color palette.
//                Color chosenColor = JColorChooser.showDialog(Delegate.this,"Color Chooser",Color.BLACK);
//                if (chosenColor != null) {
//                    // TODO: add chosenColor to model.
//                }
//            }
//        });


    }



    public void setupFrame() {
        this.mainFrame = new JFrame();
        mainFrame.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        addComponentsToPane(mainFrame.getContentPane());
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);

    }

    /**
     * The method is called when the model changes (i.e. when the model executes notifier.firePropertyChange)
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

}
