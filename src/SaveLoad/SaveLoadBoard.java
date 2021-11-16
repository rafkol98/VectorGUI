package SaveLoad;

import model.Model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveLoadBoard {

    public static void saveBoard(Model model, String filename) throws IOException {
        if (filename != null && filename.endsWith(".save")) {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)));
            oos.writeObject(model);
            oos.close();
        } else {
            throw new IOException("Please enter a valid filename. It must end with .save");
        }
    }

//    public static Model loadBoard(String filename) throws IOException {
//        if (filename != null) {
//
//        }
//    }



}
