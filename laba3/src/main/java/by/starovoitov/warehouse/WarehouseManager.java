package by.starovoitov.warehouse;

public class WarehouseManager {
    private Warehouse warehouse;

    public WarehouseManager(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void addItemToWarehouse(StockItem item) {
        warehouse.addItem(item);
    }

    public void removeItemFromWarehouse(StockItem item) {
        warehouse.removeItem(item);
    }
}
