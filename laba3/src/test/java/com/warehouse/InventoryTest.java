package com.warehouse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InventoryTest {
    @Test
    public void testCheckStock() {
        Warehouse warehouse = new Warehouse("Main Warehouse");
        StockItem item = new StockItem("Item1", 10);
        warehouse.addItem(item);
        Inventory inventory = new Inventory(warehouse);

        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        inventory.checkStock();
        assertTrue(outContent.toString().contains("Item1: 10"));

        // Reset System.out
        System.setOut(System.out);
    }
}