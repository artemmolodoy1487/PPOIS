package by.starovoitov.warehouse;

public class InventoryAudit {
    private Warehouse warehouse;

    public InventoryAudit(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void performAudit() {
        System.out.println("Performing inventory audit for: " + warehouse.getName());
        for (StockItem item : warehouse.getStockItems()) {
            System.out.println("Item: " + item.getName() + ", Quantity: " + item.getQuantity());
        }
    }
}
