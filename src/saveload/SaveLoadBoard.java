package saveload;

import model.Model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveLoadBoard implements Serializable {

    /**
     * Saves the board.
     * @param model
     * @param filename
     * @throws IOException
     */
    public static void saveBoard(Model model, String filename) throws IOException {
        if (filename != null && filename.endsWith(".vectorboard")) {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)));
            oos.writeObject(model);
            oos.close();
        } else {
            throw new IOException("Please enter a valid filename. It must end with .vectorboard");
        }
    }

    /**
     * Loads the board.
     * @param filename
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
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
