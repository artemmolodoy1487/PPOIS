package com.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private String name;
    private List<StockItem> stockItems;

    public Warehouse(String name) {
        this.name = name;
        this.stockItems = new ArrayList<>();
    }

    public void addItem(StockItem item) {
        stockItems.add(item);
    }

    public void removeItem(StockItem item) {
        stockItems.remove(item);
    }

    public List<StockItem> getStockItems() {
        return stockItems;
    }

    public String getName() {
        return name;
    }
}
