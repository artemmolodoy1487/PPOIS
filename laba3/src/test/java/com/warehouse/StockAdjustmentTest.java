package com.warehouse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StockAdjustmentTest {
    @Test
    public void testAdjustStock() {
        StockItem item = new StockItem("Item1", 10);
        StockAdjustment adjustment = new StockAdjustment(item, 5);
        adjustment.adjust();
        assertEquals(15, item.getQuantity());
    }
}