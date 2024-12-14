package by.starovoitov.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<StockItem> items;
    private Supplier supplier;

    public Order(Supplier supplier) {
        this.supplier = supplier;
        this.items = new ArrayList<>();
    }

    public void addItem(StockItem item) {
        items.add(item);
    }

    public List<StockItem> getItems() {
        return items;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}
