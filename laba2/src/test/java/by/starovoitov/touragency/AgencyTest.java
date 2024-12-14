package by.starovoitov.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AgencyTest {
    @Test
    public void testAddTour() {
        Agency agency = new Agency("Travel Agency");
        Tour tour = new Tour("Paris", 5, 1200.0);
        agency.addTour(tour);
        List<Tour> tours = agency.getTours();
        assertEquals(1, tours.size());
        assertEquals("Paris", tours.get(0).getDestination());
    }

    @Test
    public void testGetName() {
        Agency agency = new Agency("Travel Agency");
        assertEquals("Travel Agency", agency.getName());
    }
}
