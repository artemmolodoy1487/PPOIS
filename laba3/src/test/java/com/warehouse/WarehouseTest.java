package com.warehouse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarehouseTest {
    @Test
    public void testAddItem() {
        Warehouse warehouse = new Warehouse("Main Warehouse");
        StockItem item = new StockItem("Item1", 10);
        warehouse.addItem(item);
        assertEquals(1, warehouse.getStockItems().size());
    }

    @Test
    public void testRemoveItem() {
        Warehouse warehouse = new Warehouse("Main Warehouse");
        StockItem item = new StockItem("Item1", 10);
        warehouse.addItem(item);
        warehouse.removeItem(item);
        assertEquals(0, warehouse.getStockItems().size());
    }
}
