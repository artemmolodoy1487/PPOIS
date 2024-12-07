package com.warehouse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    @Test
    public void testCustomerCreation() {
        Customer customer = new Customer("Customer1");
        assertEquals("Customer1", customer.getName());
    }
}