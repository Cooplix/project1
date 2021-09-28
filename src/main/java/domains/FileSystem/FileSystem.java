package domains.FileSystem;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.Scanner;

@Setter
public class FileSystem {

    private String fileName = "PESEL.txt";

    private File file = new File(fileName);

    public void writeToFile(String PESEL) {
        createFile();
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(PESEL);
            writer.write("\n");
            writer.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void readFromFile() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public boolean createFile() {
        try {
            if (file.createNewFile()) {
                System.out.println("Stworznie listy PESEL");
                return true;
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public void fileDelete() {
        file.delete();
    }
}
