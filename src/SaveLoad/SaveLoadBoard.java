package SaveLoad;

import model.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveLoadBoard {

    public static void saveBoard(Model model, String filename) throws IOException {
        if (filename != null && filename.endsWith(".vectorboard")) {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)));
            oos.writeObject(model);
            oos.close();
        } else {
            throw new IOException("Please enter a valid filename. It must end with .vectorboard");
        }
    }

    public static Model loadBoard(String filename) throws IOException, ClassNotFoundException {
        if (filename != null && filename.endsWith(".vectorboard")) {
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
