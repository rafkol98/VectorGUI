package saveload;

import model.Model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class is used to save and load the GUI board.
 * @author: 210017984
 */
public class SaveLoadBoard implements Serializable {

    /**
     * Saves the board.
     * @param model the model that is saved.
     * @param filename the name that the file will be saved as.
     * @throws IOException when the filename does not end with .vectorboard or is null.
     */
    public static void saveBoard(Model model, String filename) throws IOException {
        // Check that filename is not null and that it ends with ".vectorboard".
        if (filename != null && filename.endsWith(".vectorboard")) {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)));
            // write object.
            oos.writeObject(model);
            oos.close();
        } else {
            throw new IOException("Please enter a valid filename. It must end with .vectorboard");
        }
    }

    /**
     * Loads the board.
     * @param filename the name of the file to be loaded.
     * @return the model that was loaded.
     * @throws IOException when the filename does not end with .vectorboard or is null. Or if it does not exist.
     * @throws ClassNotFoundException throws ClassNotFoundException if the class could not be found/read.
     */
    public static Model loadBoard(String filename) throws IOException, ClassNotFoundException {
        // Get file to check if it exists.
        File file = new File(filename);
        // Check if filename is not null, ends with ".vectorboard" and that file exists.
        if (filename != null && filename.endsWith(".vectorboard") && file.exists()) {
            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(filename)));
            if (ois != null) {
                return (Model) ois.readObject();
            }
        } else {
            throw new IOException("Please select a .vectorboard file");
        }
        return null;
    }

}
