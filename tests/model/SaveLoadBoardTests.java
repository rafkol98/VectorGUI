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
    private File file;

    /**
     * Setup before each test.
     */
    @BeforeEach
    public void setup() {
        model = new Model();
        name = "example.vectorboard";
        file = new File(name);

        // Delete "example.vectorboard" file if it exists ( created in testSaveBoard() ) before every test.
        // If it exists then delete it to ensure that the functionality is tested properly.
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * Tests that the saveBoard throws an exception when the filename provided is not valid.
     * @throws IOException exception thrown by the method when filename is not valid.
     */
    @Test
    public void testSaveBoardErrorCase() throws IOException {
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
        // Check that file does not exist.
        assertFalse(file.exists());
        // Use saveBoard to save file.
        SaveLoadBoard.saveBoard(model, name);
        // Checks that the file exists and that it was successfully saved.
        assertTrue(file.exists());
    }

    /**
     * Tests that the loadBoard functionality throws an exception when trying to enter a not existing file.
     * @throws IOException exception thrown by the method when filename is not valid.
     */
    @Test
    public void testLoadBoardErrorCase() throws IOException {
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
