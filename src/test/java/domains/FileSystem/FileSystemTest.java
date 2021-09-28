package domains.FileSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FileSystemTest {

    private FileSystem fileSystem = new FileSystem();

    @Test
    void writeToFile() {
        fileSystem.setFileName("Test.txt");
        assertTrue(fileSystem.createFile());
        fileSystem.fileDelete();
    }
}