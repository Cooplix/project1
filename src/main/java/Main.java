import domains.FileSystem.FileSystem;
import domains.PESEL.PESEL;
import domains.PESEL.PeselFromFile;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        PeselFromFile peselFromFile = new PeselFromFile("PESEL.txt");
        peselFromFile.checkPesel();

        while (true) {
            System.out.print("Podaj PESEL: ");
            String inputPesel;

            PESEL pesel = new PESEL();

            Scanner scanner = new Scanner(System.in);

            inputPesel = scanner.nextLine();

            pesel.getPesel(inputPesel, true);
        }
    }
}
