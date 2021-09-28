package domains.PESEL;

import domains.FileSystem.FileSystem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PESEL {

    private final int lengthOfPesel = 11;

    private final int[] weight = {1, 3, 7, 9, 1, 3, 7 ,9 ,1 ,3};

    private FileSystem fileSystem = new FileSystem();

    public boolean getPesel (String Pesel, boolean toggle) {
        if(Pesel.length() != lengthOfPesel) {
            System.out.println("Pesel musi miec 11 cyfer");
            return false;
        } else {
            int[] peselToInt = Pesel.chars()
                    .filter(Character::isDigit)
                    .map(Character::getNumericValue)
                    .toArray();

            return checkPesel(peselToInt, toggle);
        }
    }

    private boolean checkPesel(int[] Pesel, boolean toggle) {
        List<Integer> arrayList = Arrays.stream(Pesel).boxed().collect(Collectors.toList());
        int checkSum = 0;

        for(int i = 0; i < 10; i++) {
            checkSum += arrayList.get(i) * weight[i];
        }

        int lastNumber = checkSum % 10;

        int controlNumber = 10 - lastNumber;

        if(controlNumber == arrayList.get(10)) {
            StringBuilder pesel = new StringBuilder("");
            arrayList.forEach(pesel::append);
            if(toggle) {
                System.out.println("Twoj PESEL jest poprawny");
                fileSystem.writeToFile(pesel.toString());
            } else {
                System.out.printf("PESEL: %s jest poprawny %n", pesel);
            }
            return true;
        } else {
            System.out.println("Twoj PESEL jest niepoprawny");
            return false;
        }
    }
}
