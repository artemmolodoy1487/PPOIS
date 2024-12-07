package com.warehouse;

import java.util.ArrayList;
import java.util.List;

public class PurchaseOrder {
    private Customer customer;
    private List<StockItem> items;

    public PurchaseOrder(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(StockItem item) {
        items.add(item);
    }

    public List<StockItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }
}
