package com.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {
    @Test
    public void testFlightDetails() {
        Flight flight = new Flight("Airline X", 200);
        assertEquals("Airline X", flight.getAirline());
        assertEquals("Flight", flight.getType());
    }
}
