package domains.PESEL;

import lombok.Data;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

@Setter
public class PeselFromFile {
    Set<String> peselsToSet = new HashSet<>();

    private String fileName;

    public PeselFromFile() {
    }

    public PeselFromFile(String fileName) {
        this.fileName = fileName;
    }

    private void readFile() {
        try {
            peselsToSet.addAll(Files.readAllLines(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkPesel() {
        readFile();
        PESEL pesel = new PESEL();
        if(!peselsToSet.isEmpty()) {
            for(String pesels : peselsToSet) {
                return pesel.getPesel(pesels.replace("\n", "").trim(), false);
            }
        }
        return false;
    }
}
