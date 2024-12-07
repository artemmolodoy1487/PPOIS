package com.warehouse;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse("Main Warehouse");
        StockItem item1 = new StockItem("Item1", 10);
        StockItem item2 = new StockItem("Item2", 20);
        
        warehouse.addItem(item1);
        warehouse.addItem(item2);

        Inventory inventory = new Inventory(warehouse);
        inventory.checkStock();

        Supplier supplier = new Supplier("Supplier1");
        Order order = new Order(supplier);
        order.addItem(item1);
        
        Shipment shipment = new Shipment(order);
        shipment.ship();
        
        Report report = new Report(warehouse);
        report.generateReport();

        InventoryAudit audit = new InventoryAudit(warehouse);
        audit.performAudit();
        
        StockAdjustment adjustment = new StockAdjustment(item1, 5);
        adjustment.adjust();
        
        Notification notification = new Notification();
        notification.sendNotification("Stock adjustment completed.");
    }
}
