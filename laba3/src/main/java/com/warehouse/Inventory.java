package com.warehouse;

public class Inventory {
    private Warehouse warehouse;

    public Inventory(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void checkStock() {
        for (StockItem item : warehouse.getStockItems()) {
            System.out.println(item.getName() + ": " + item.getQuantity());
        }
    }
}
