package by.starovoitov.warehouse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StockItemTest {
    @Test
    public void testStockItemCreation() {
        StockItem item = new StockItem("Item1", 10);
        assertEquals("Item1", item.getName());
        assertEquals(10, item.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        StockItem item = new StockItem("Item1", 10);
        item.setQuantity(20);
        assertEquals(20, item.getQuantity());
    }
}
