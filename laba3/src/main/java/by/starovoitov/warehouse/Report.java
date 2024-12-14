package by.starovoitov.warehouse;

public class Report {
    private Warehouse warehouse;

    public Report(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void generateReport() {
        System.out.println("Warehouse Report for: " + warehouse.getName());
        for (StockItem item : warehouse.getStockItems()) {
            System.out.println(item.getName() + ": " + item.getQuantity());
        }
    }
}
