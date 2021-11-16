//package delegate;
//
//import model.Model;
//
//import javax.swing.*;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Hashtable;
//
//import static main.Configuration.*;
//import static main.Configuration.CROSS;
//
//public class VectorToolbar extends JToolBar {
//
//    private Model model;
//    private JToolBar toolbar;
//    private JButton buttonColour, buttonFill, buttonUndo, buttonRedo, buttonLine, buttonRectangle, buttonSquare, buttonEllipse, buttonCircle, buttonDiagonalCross;
//
//    private JSlider slider;
//    JLabel sliderStatus;
//
//    private final ImageIcon fillEmptyImgIcon = new ImageIcon(new ImageIcon("Icons/filling-empty.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
//
//
//    public VectorToolbar(Model model) {
//        this.toolbar = new JToolBar();
//        this.model = model;
//        setupToolBar();
//    }
//
//    /**
//     * Set's up the toolbar.
//     */
//    private void setupToolBar() {
//        // Initialise new toolbar.
//        toolbar = new JToolBar();
//        // add the buttons to the toolbar.
//        createToolBarButtons();
//        // add actions to the toolbar.
//        addActionsToButtons();
//        toolbar.setVisible(true);
//    }
//
//    /**
//     * Creates all the buttons for the toolbar in an appropriate fashion.
//     */
//    private void createToolBarButtons() {
//        try {
//            // add icons to buttons.
//            ImageIcon colorImgIcon = new ImageIcon(new ImageIcon("Icons/color-circle.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
//            ImageIcon undoImgIcon = new ImageIcon(new ImageIcon("Icons/undo.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
//            ImageIcon redoImgIcon = new ImageIcon(new ImageIcon("Icons/redo.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
//            ImageIcon lineImgIcon = new ImageIcon(new ImageIcon("Icons/line.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
//            ImageIcon rectangleImgIcon = new ImageIcon(new ImageIcon("Icons/rectangle.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
//            ImageIcon squareImgIcon = new ImageIcon(new ImageIcon("Icons/square.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
//            ImageIcon ellipseImgIcon = new ImageIcon(new ImageIcon("Icons/ellipse.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
//            ImageIcon circleImgIcon = new ImageIcon(new ImageIcon("Icons/circle.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
//            ImageIcon diagonalCrossImgIcon = new ImageIcon(new ImageIcon("Icons/diagonal_cross.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
//
//            // Create colour and fill button.
//            buttonColour = new JButton(colorImgIcon);
//            buttonFill = new JButton(fillEmptyImgIcon);
//
//            // Create undo and redo buttons.
//            buttonUndo = new JButton(undoImgIcon);
//            buttonRedo = new JButton(redoImgIcon);
//            // Create shapes buttons.
//            buttonLine = new JButton(lineImgIcon);
//            buttonRectangle = new JButton(rectangleImgIcon);
//
//            buttonSquare = new JButton(squareImgIcon);
//            buttonEllipse = new JButton(ellipseImgIcon);
//            buttonCircle = new JButton(circleImgIcon);
//            buttonDiagonalCross = new JButton(diagonalCrossImgIcon);
//
//            // add buttons to the toolbar
//            toolbar.add(buttonColour);
//            toolbar.add(buttonFill);
//            toolbar.add(buttonUndo);
//            toolbar.add(buttonRedo);
//            toolbar.add(buttonLine);
//            toolbar.add(buttonRectangle);
//            toolbar.add(buttonSquare);
//            toolbar.add(buttonEllipse);
//            toolbar.add(buttonCircle);
//            toolbar.add(buttonDiagonalCross);
//
//            // Add status label to show the status of the slider
//            sliderStatus = new JLabel("     Thickness: ", JLabel.CENTER);
//
//            // Set the slider
//            slider = new JSlider(1, 20);
//            slider.setValue(1);
//            slider.setMinorTickSpacing(1);
//            slider.setPaintTicks(true);
//
//            // Set the labels to be painted on the slider
//            slider.setPaintLabels(true);
//
//            // Add positions label in the slider
//            Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
//            position.put(1, new JLabel("1"));
//            position.put(10, new JLabel("10"));
//            position.put(20, new JLabel("20"));
//
//            // Set the label to be drawn
//            slider.setLabelTable(position);
//
//            toolbar.add(sliderStatus);
//            toolbar.add(slider);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    /**
//     * Add an action to each of the buttons in the toolbar.
//     */
//    private void addActionsToButtons() {
//        // Button Colour action - show color palette.
//        buttonColour.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Select color from the color palette.
//                Color chosenColor = JColorChooser.showDialog(VectorToolbar.this, "Color Chooser", Color.BLACK);
//                if (chosenColor != null) {
//                    // Change color to selected.
//                    model.changeColor(chosenColor);
//                }
//            }
//        });
//
//        buttonFill.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Called");
//                model.changeFillValue();
//                // Update fill button image.
//                updateFillButtonImage();
//            }
//        });
//
//
//        // Undo button.
//        buttonUndo.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                model.undo();
//            }
//        });
//
//        // Redo button.
//        buttonRedo.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                model.redo();
//            }
//        });
//
//        // Draw new line button.
//        buttonLine.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                model.selectShape(LINE);
//            }
//        });
//
//        // Draw new rectangle button.
//        buttonRectangle.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                model.selectShape(RECTANGLE);
//            }
//        });
//
//        // Draw new square button.
//        buttonSquare.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                model.selectShape(SQUARE);
//            }
//        });
//
//        // Draw new ellipse button.
//        buttonEllipse.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                model.selectShape(ELLIPSE);
//            }
//        });
//
//        // Draw new circle button.
//        buttonCircle.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                model.selectShape(CIRCLE);
//            }
//        });
//
//        // Draw new diagonal cross button.
//        buttonDiagonalCross.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                model.selectShape(CROSS);
//            }
//        });
//
//        // Add change listener to the thickness slider.
//        slider.addChangeListener(new ChangeListener() {
//            public void stateChanged(ChangeEvent e) {
//                int thickness = ((JSlider) e.getSource()).getValue();
//                sliderStatus.setText("      Thickness: " + thickness);
//                // change thickness in the model.
//                model.changeThickness(thickness);
//            }
//        });
//
//    }
//
//    /**
//     * Updates fill button image depending on whether the user clicked on the fill button.
//     */
//    public void updateFillButtonImage() {
//        if (model.getHasFill()) {
//            ImageIcon fillImgIcon = new ImageIcon(new ImageIcon("Icons/filling.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
//            buttonFill.setIcon(fillImgIcon);
//        } else {
//            buttonFill.setIcon(fillEmptyImgIcon);
//        }
//    }
//
//
//}