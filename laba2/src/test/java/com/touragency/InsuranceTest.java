package com.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsuranceTest {
    @Test
    public void testInsuranceDetails() {
        Insurance insurance = new Insurance("Provider A", 1000.0);
        assertEquals("Provider A", insurance.getProvider());
        assertEquals(1000.0, insurance.getAmount());
    }
}
