package com.warehouse;

public class StockMovement {
    private StockItem item;
    private int quantity;

    public StockMovement(StockItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public void move() {
        System.out.println("Moving " + quantity + " of " + item.getName());
    }
}
