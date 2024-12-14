package by.starovoitov.warehouse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarehouseManagerTest {
    @Test
    public void testAddItemToWarehouse() {
        Warehouse warehouse = new Warehouse("Main Warehouse");
        WarehouseManager manager = new WarehouseManager(warehouse);
        StockItem item = new StockItem("Item1", 10);
        manager.addItemToWarehouse(item);
        assertEquals(1, warehouse.getStockItems().size());
    }

    @Test
    public void testRemoveItemFromWarehouse() {
        Warehouse warehouse = new Warehouse("Main Warehouse");
        StockItem item = new StockItem("Item1", 10);
        warehouse.addItem(item);
        WarehouseManager manager = new WarehouseManager(warehouse);
        manager.removeItemFromWarehouse(item);
        assertEquals(0, warehouse.getStockItems().size());
    }
}