package com.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TourTest {
    @Test
    public void testTourDetails() {
        Tour tour = new Tour("Paris", 5, 1200.0);
        assertEquals("Paris", tour.getDestination());
        assertEquals(5, tour.getDuration());
        assertEquals(1200.0, tour.getPrice());
    }
}
