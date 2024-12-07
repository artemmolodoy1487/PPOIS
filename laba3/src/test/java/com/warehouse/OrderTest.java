package com.warehouse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class OrderTest {
    @Test
    public void testOrderCreation() {
        Supplier supplier = new Supplier("Supplier1");
        Order order = new Order(supplier);
        assertEquals(supplier, order.getSupplier());
    }

    @Test
    public void testAddItemToOrder() {
        Supplier supplier = new Supplier("Supplier1");
        Order order = new Order(supplier);
        StockItem item = new StockItem("Item1", 10);
        order.addItem(item);
        List<StockItem> items = order.getItems();
        assertEquals(1, items.size());
        assertEquals(item, items.get(0));
    }
}
