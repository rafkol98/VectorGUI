package tests;

import saveload.SaveLoadBoard;
import model.Model;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class SaveLoadBoardTests {

    private Model model;
    private String name;

    /**
     * Setup before each test.
     */
    @Before
    public void setup() {
        model = new Model();
        name = "example.vectorboard";
    }

    /**
     * After class delete the file created to test the saveboard fucntionality.
     */
    @AfterClass
    public static void after() {
        File file = new File("example.vectorboard");
        // After checking that it successfully works, delete "example.vectorboard".
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * Tests that the saveBoard throws an exception when the filename provided is not valid.
     * @throws IOException exception thrown by the method when filename is not valid.
     */

    @Test(expected = IOException.class)
    public void testSaveBoardErrorCase() throws IOException {
        System.out.println("SaveLoadBoardTest - Testing changeFillValue");
        // Assert if an exception is thrown.
        SaveLoadBoard.saveBoard(model, "notAcceptedName");
        fail("Exception must be thrown.");
    }

    /**
     * Tests that the saveBoard throws an exception when the ending of the filename
     * does not end with ".vectorboard".
     * @throws IOException exception thrown by the method when filename is not valid.
     */
    @Test(expected = IOException.class)
    public void testSaveBoardErrorCaseDifferentEnding() throws IOException {
        System.out.println("SaveLoadBoardTest - Testing testSaveBoardErrorCaseDifferentEnding");
        // Assert if an exception is thrown.
        SaveLoadBoard.saveBoard(model, "name.vector");
        fail("Exception must be thrown.");
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



    }

    /**
     * Tests that the loadBoard functionality throws an exception when trying to enter a not existing file.
     * @throws IOException exception thrown by the method when filename is not valid.
     */
    @Test(expected = IOException.class)
    public void testLoadBoardErrorCase() throws IOException, ClassNotFoundException {
        System.out.println("SaveLoadBoardTest - Testing testLoadBoardErrorCase");
        // Assert if an exception is thrown.
        SaveLoadBoard.loadBoard("notExistingFile.vectorboard");
        fail("Exception must be thrown.");
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
