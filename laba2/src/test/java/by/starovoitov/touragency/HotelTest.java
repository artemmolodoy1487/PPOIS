package by.starovoitov.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {
    @Test
    public void testHotelDetails() {
        Hotel hotel = new Hotel("Luxury Hotel", 5);
        assertEquals("Luxury Hotel", hotel.getName());
        assertEquals(5, hotel.getStars());
    }
}
