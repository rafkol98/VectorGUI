package model;


import SaveLoad.SaveLoadBoard;
import configuration.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SaveLoadBoardTests {

    private Model model;
    private String name;

    /**
     * Setup before each test.
     */
    @BeforeEach
    public void setup() {
        model = new Model();
        name = "example.vectorboard";
    }

    /**
     * Tests that the saveBoard throws an exception when the filename provided is not valid.
     * @throws IOException exception thrown by the method when filename is not valid.
     */
    @Test
    public void testSaveBoardErrorCase() throws IOException {
        System.out.println("SaveLoadBoardTest - Testing changeFillValue");
        // Assert if an exception is thrown.
        assertThrows(IOException.class,
                () -> {
                    SaveLoadBoard.saveBoard(model, "notAcceptedName");
                });
    }

    /**
     * Tests that the saveBoard throws an exception when the ending of the filename
     * does not end with ".vectorboard".
     * @throws IOException exception thrown by the method when filename is not valid.
     */
    @Test
    public void testSaveBoardErrorCaseDifferentEnding() throws IOException {
        System.out.println("SaveLoadBoardTest - Testing testSaveBoardErrorCaseDifferentEnding");
        // Assert if an exception is thrown.
        assertThrows(IOException.class,
                () -> {
                    SaveLoadBoard.saveBoard(model, "name.vector");
                });
    }


    /**
     * Tests that the saveBoard functionality works properly.
     * @throws IOException exception thrown by the method when filename is not valid.
     */
    @Test
    public void testSaveBoard() throws IOException {
        System.out.println("SaveLoadBoardTest - Testing testSaveBoard");
        // Get file with name "example.vectorboard".
        File file = new File(name);
        // Check that file does not exist.
        assertFalse(file.exists());
        // Use saveBoard to save file.
        SaveLoadBoard.saveBoard(model, name);
        // Checks that the file now exists and that it was successfully saved.
        assertTrue(file.exists());

        // After checking that it successfully works, delete "example.vectorboard".
        if (file.exists()) {
            file.delete();
        }

    }

    /**
     * Tests that the loadBoard functionality throws an exception when trying to enter a not existing file.
     * @throws IOException exception thrown by the method when filename is not valid.
     */
    @Test
    public void testLoadBoardErrorCase() throws IOException {
        System.out.println("SaveLoadBoardTest - Testing testLoadBoardErrorCase");
        // Assert if an exception is thrown.
        assertThrows(IOException.class,
                () -> {
                    SaveLoadBoard.loadBoard("notExistingFile.vectorboard");
                });
    }

    /**
     * Tests that the loadBoard functionality works properly.
     * @throws IOException exception thrown by the method when filename is not valid.
     * @throws ClassNotFoundException exception thrown by the method when file cannot be read.
     */
    @Test
    public void testLoadBoard() throws IOException, ClassNotFoundException {
        System.out.println("SaveLoadBoardTest - Testing testLoadBoard");
        // Use saveBoard to save file.
        SaveLoadBoard.saveBoard(model, name);
        // Load the board.
        Model loaded = SaveLoadBoard.loadBoard(name);
        // Asserts that the loaded model is not null.
        assertNotNull(loaded);
        // Checks that the loaded model and the original model have the same shapes.
        assertEquals(loaded.getShapes(), model.getShapes());
    }


}
