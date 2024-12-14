package by.starovoitov.warehouse;

public class StockAdjustment {
    private StockItem item;
    private int adjustment;

    public StockAdjustment(StockItem item, int adjustment) {
        this.item = item;
        this.adjustment = adjustment;
    }

    public void adjust() {
        item.setQuantity(item.getQuantity() + adjustment);
        System.out.println("Adjusted " + item.getName() + " by " + adjustment + ". New quantity: " + item.getQuantity());
    }
}
