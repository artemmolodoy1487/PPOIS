package com.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {
    @Test
    public void testBookingDetails() {
        Client client = new Client("Jane Doe", "jane@example.com");
        Tour tour = new Tour("London", 7, 1500.0);
        Booking booking = new Booking(client, tour);
        assertEquals("Jane Doe booked a tour to London", booking.getDetails());
    }
}
