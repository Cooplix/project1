package domains;

import domains.PESEL.PESEL;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PESELTest {

    private static final PESEL PESEL = new PESEL();

    @Test
    void whenPeselCorrect_thenTestTrue() {
        String pesel = "81100216357";

        assertTrue(PESEL.getPesel(pesel, false));
    }

    @Test
    void whenPeselIncorrect_thenTestFalse() {
        String pesel = "81100216327";

        assertFalse(PESEL.getPesel(pesel, false));
    }

    @Test
    void whenPeselNotHave11Number_thenReturnFalse() {
        String pesel = "1234";

        assertFalse(PESEL.getPesel(pesel, false));
    }

}