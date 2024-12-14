package by.starovoitov.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CruiseTest {
    @Test
    public void testCruiseDetails() {
        Cruise cruise = new Cruise("Titanic", 300);
        assertEquals("Titanic", cruise.getShipName());
        assertEquals("Cruise", cruise.getType());
    }
}
