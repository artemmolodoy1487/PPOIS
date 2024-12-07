package com.warehouse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InventoryAuditTest {
    @Test
    public void testPerformAudit() {
        Warehouse warehouse = new Warehouse("Main Warehouse");
        StockItem item = new StockItem("Item1", 10);
        warehouse.addItem(item);
        InventoryAudit audit = new InventoryAudit(warehouse);

        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        audit.performAudit();
        assertTrue(outContent.toString().contains("Performing inventory audit for: Main Warehouse"));
        assertTrue(outContent.toString().contains("Item: Item1, Quantity: 10"));

        // Reset System.out
        System.setOut(System.out);
    }
}
