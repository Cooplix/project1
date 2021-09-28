package domains.PESEL;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PeselFromFileTest {
    private String fileName = "TEST.txt";
    private static File file = new File("TEST.txt");

    @BeforeEach
    public void init() {
        try {
            file.createNewFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @AfterEach
    public void deleteFile() {
        file.delete();
    }

    @AfterAll
    public static void set() {
        file.delete();
    }

    @Test
    public void whenPeselFromFileCorrect_thenReturnTrue() throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write("81100216357");
        writer.write("\n");
        writer.close();

        PeselFromFile peselFromFile = new PeselFromFile(fileName);

        assertTrue(peselFromFile.checkPesel());
    }

    @Test
    public void whenPeselFromFileInCorrect_thenReturnFalse() throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write("81100216307");
        writer.write("\n");
        writer.close();

        PeselFromFile peselFromFile = new PeselFromFile(fileName);
        assertFalse(peselFromFile.checkPesel());


    }
}