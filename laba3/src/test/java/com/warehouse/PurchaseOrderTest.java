package com.warehouse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PurchaseOrderTest {
    @Test
    public void testPurchaseOrderCreation() {
        Customer customer = new Customer("Customer1");
        PurchaseOrder purchaseOrder = new PurchaseOrder(customer);
        assertEquals(customer, purchaseOrder.getCustomer());
    }

    @Test
    public void testAddItemToPurchaseOrder() {
        Customer customer = new Customer("Customer1");
        PurchaseOrder purchaseOrder = new PurchaseOrder(customer);
        StockItem item = new StockItem("Item1", 10);
        purchaseOrder.addItem(item);
        List<StockItem> items = purchaseOrder.getItems();
        assertEquals(1, items.size());
        assertEquals(item, items.get(0));
    }
}
