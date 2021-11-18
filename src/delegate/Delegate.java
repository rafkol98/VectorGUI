package delegate;

import SaveLoad.SaveLoadBoard;
import model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Hashtable;

import static configuration.Configuration.*;

/**
 * The delegate class is responsible for handling the GUI aspect of the program.
 *
 * @author: 210017984
 */
public class Delegate extends JFrame implements PropertyChangeListener {

    private static final long serialVersionUID = 6529685098267757690L;

    // Frame.
    private JFrame mainFrame;

    /**
     * Height of the frame.
     */
    private static final int FRAME_HEIGHT = 800;

    /**
     * Width of the frame.
     */
    private static final int FRAME_WIDTH = 1000;

    private JMenuBar menu;

    // Toolbar buttons and images.
    private JToolBar toolbar;
    private JButton buttonColour, buttonFill, buttonUndo, buttonRedo, buttonLine, buttonRectangle, buttonSquare, buttonEllipse, buttonCircle, buttonDiagonalCross;
    private ImageIcon colorImgIcon, undoImgIcon, redoImgIcon, lineImgIcon, rectangleImgIcon, squareImgIcon, ellipseImgIcon, circleImgIcon, diagonalCrossImgIcon;
    private final ImageIcon fillEmptyImgIcon = new ImageIcon(new ImageIcon(getBeginningOfPath() + "Icons/filling-empty.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));

    // Slider.
    private JSlider slider;
    private JLabel sliderStatus;

    // Model.
    private Model model;
    private SaveLoadBoard saveLoadBoard;

    private VectorBoard vectorBoard;

    /**
     * Creates a new delegate class. Set's up the frame and displays the content.
     *
     * @param model the model used for the GUI.
     */
    public Delegate(Model model) {
        this.model = model;
        setupFrame();
    }

    /**
     * Set's up the frame of the GUI.
     */
    public void setupFrame() {
        mainFrame = new JFrame();
        mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Add up all the different components to the content pane.
        addComponentsToPane(mainFrame.getContentPane());
        this.model.addObserver(this);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setJMenuBar(menu);
    }


    /**
     * Adds all the different components to the content pane.
     *
     * @param pane the content pane of the main frame.
     */
    public void addComponentsToPane(Container pane) {
        setupMenu();
        // Setup and add toolbar.
        setupToolBar();
        pane.add(toolbar, BorderLayout.NORTH);

        //Make the center component big, since that's the
        //typical usage of BorderLayout.
        vectorBoard = new VectorBoard(model);
        pane.add(vectorBoard, BorderLayout.CENTER);
    }

    /**
     * sets up File menu with save and load entries
     */
    private void setupMenu() {
        menu = new JMenuBar();
        menu.setBackground(Color.BLACK);
        menu.setForeground(Color.WHITE);

        JMenu file = new JMenu("File");
        JMenuItem load = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem clear = new JMenuItem("Clear");

        // Add menu items to file.
        file.add(load);
        file.add(save);
        file.add(clear);

        // Add file to menu.
        menu.add(file);

        // Create new save load board.
        saveLoadBoard = new SaveLoadBoard();

        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.loadState();
            }
        });

        // Save functionality. Saves an object to a file selected by the user.
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.saveState();
            }
        });

        // Save functionality. Saves an object to a file selected by the user.
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.clear();
            }
        });

        // add menubar to frame
        mainFrame.setJMenuBar(menu);
    }

    /**
     * Set's up the toolbar.
     */
    private void setupToolBar() {
        // Initialise new toolbar.
        toolbar = new JToolBar();

        // add the buttons to the toolbar.
        setupToolBarButtons();

        // add actions to the toolbar.
        addActionsToButtons();
    }

    /**
     * Creates all the buttons for the toolbar in an appropriate fashion.
     */
    private void setupToolBarButtons() {
        // Get beginning of path - depends on where you run the program (Terminal or IDE).
        String beginningOfPath = getBeginningOfPath();

        // Initialise the GUI icons.
        initialiseImageIcons(beginningOfPath);

        // Add the buttons to the toolbar. With their corresponding images.
        addToolbarButtons();

        // Setup the thickness slider.
        setupThicknessSlider();
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

        // Fill action button.
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

        // Add change listener to the thickness slider.
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int thickness = ((JSlider) e.getSource()).getValue();
                sliderStatus.setText("      Thickness: " + thickness);
                // change thickness in the model.
                model.changeThickness(thickness);
            }
        });

    }

    /**
     * Updates fill button image depending on whether the user clicked on the fill button.
     */
    private void updateFillButtonImage() {
        if (model.getHasFill()) {
            ImageIcon fillImgIcon = new ImageIcon(new ImageIcon("Icons/filling.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            buttonFill.setIcon(fillImgIcon);
        } else {
            buttonFill.setIcon(fillEmptyImgIcon);
        }
    }

    /**
     * Initialises the image icons for the GUI.
     *
     * @param beginningOfPath the beginning of the path. It is very important to show the images appropriately.
     */
    private void initialiseImageIcons(String beginningOfPath) {
        try {
            // add icons to buttons.
            colorImgIcon = new ImageIcon(new ImageIcon(beginningOfPath + "Icons/color-circle.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            undoImgIcon = new ImageIcon(new ImageIcon(beginningOfPath + "Icons/undo.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            redoImgIcon = new ImageIcon(new ImageIcon(beginningOfPath + "Icons/redo.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            lineImgIcon = new ImageIcon(new ImageIcon(beginningOfPath + "Icons/line.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            rectangleImgIcon = new ImageIcon(new ImageIcon(beginningOfPath + "Icons/rectangle.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            squareImgIcon = new ImageIcon(new ImageIcon(beginningOfPath + "Icons/square.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            ellipseImgIcon = new ImageIcon(new ImageIcon(beginningOfPath + "Icons/ellipse.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            circleImgIcon = new ImageIcon(new ImageIcon(beginningOfPath + "Icons/circle.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            diagonalCrossImgIcon = new ImageIcon(new ImageIcon(beginningOfPath + "Icons/diagonal_cross.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(mainFrame, "There was problem with loading the icons.");
            System.out.println(npe.getMessage());
        }
    }

    /**
     * Function that checks from where the file was run and adjusts the beginning of the path accordingly.
     * If the file was run from a terminal then the relative path is different than when it is run from inside an IDE.
     *
     * @return the beginning of the path.
     */
    private String getBeginningOfPath() {
        File directory = new File("./");
        String path = directory.getAbsolutePath();
        String beginningPath = path.contains("src") ? "../" : "";

        return beginningPath;
    }

    /**
     * Adds all the toolbar buttons to the toolbar. Initialises appropriate icons to the buttons.
     */
    private void addToolbarButtons() {
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
        buttonCircle = new JButton(circleImgIcon);
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
     * Sets up the thickness slider that allows the user to select the thickness of the shapes.
     */
    private void setupThicknessSlider() {
        // Add status label to show the status of the slider
        sliderStatus = new JLabel("     Thickness: ", JLabel.CENTER);

        // Set the slider
        slider = new JSlider(1, 20);
        slider.setValue(1);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);

        // Set the labels to be painted on the slider
        slider.setPaintLabels(true);

        // Add positions label in the slider
        Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
        position.put(1, new JLabel("1"));
        position.put(10, new JLabel("10"));
        position.put(20, new JLabel("20"));

        // Set the label to be drawn
        slider.setLabelTable(position);

        // Add slider status and slider to the toolbar.
        toolbar.add(sliderStatus);
        toolbar.add(slider);
    }


    /**
     * Loads the state.
     */
    public void loadState() {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(fc);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fc.getSelectedFile();
                // Load board - model.
                Model loaded = saveLoadBoard.loadBoard(file.toString());
                if (loaded != null) {
                    model.setShapesList(loaded.getShapes());
                    vectorBoard.setShapesList(loaded.getShapes());
                }
            } catch(IOException | ClassNotFoundException ex) {
                // Show error message that the board could not be load.
                JOptionPane.showMessageDialog(mainFrame, "Could not load the board: " + ex.getMessage());
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Save states of model.
     */
    public void saveState() {
        // Open file chooser.
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(null);
        // Check if everything is ok with location selected.
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                // Get file.
                File file = fc.getSelectedFile();
                // Save board - model.
                saveLoadBoard.saveBoard(model, file.toString());

                // Show message that it was saved successfully.
                JOptionPane.showMessageDialog(mainFrame, "Board saved successfully.");
            } catch (IOException ioe) {
                // Show error message that the board could not be saved.
                JOptionPane.showMessageDialog(mainFrame, "There was a problem: " + ioe.getMessage());
                System.out.println(ioe.getMessage());
            }
        } else {
            // Show error message that the user must select an appropriate location.
            JOptionPane.showMessageDialog(mainFrame, "Please make sure you select an appropriate location.");
        }
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("save")) {
            // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    saveState();
                }
            });
        }

        if (evt.getPropertyName().equals("load")) {
            // Tell the SwingUtilities thread to update the selectedShape in the GUI components.
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    loadState();
                }
            });
        }
    }
}
