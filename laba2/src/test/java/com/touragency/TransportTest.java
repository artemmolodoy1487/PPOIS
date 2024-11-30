package com.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransportTest {
    @Test
    public void testTransportDetails() {
        Transport transport = new Transport("Bus", 50);
        assertEquals("Bus", transport.getType());
        assertEquals(50, transport.getCapacity());
    }
}
