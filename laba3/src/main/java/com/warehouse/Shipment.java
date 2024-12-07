package com.warehouse;

public class Shipment {
    private Order order;

    public Shipment(Order order) {
        this.order = order;
    }

    public void ship() {
        System.out.println("Shipping order from supplier: " + order.getSupplier().getName());
        for (StockItem item : order.getItems()) {
            System.out.println("Shipping item: " + item.getName() + " (Quantity: " + item.getQuantity() + ")");
        }
    }
}
