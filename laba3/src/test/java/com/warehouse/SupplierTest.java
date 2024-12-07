package com.warehouse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SupplierTest {
    @Test
    public void testSupplierCreation() {
        Supplier supplier = new Supplier("Supplier1");
        assertEquals("Supplier1", supplier.getName());
    }
}