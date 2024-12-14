package by.starovoitov.warehouse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ShipmentTest {
    @Test
    public void testShipOrder() {
        Supplier supplier = new Supplier("Supplier1");
        Order order = new Order(supplier);
        StockItem item = new StockItem("Item1", 10);
        order.addItem(item);
        Shipment shipment = new Shipment(order);

        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        shipment.ship();
        assertTrue(outContent.toString().contains("Shipping order from supplier: Supplier1"));
        assertTrue(outContent.toString().contains("Shipping item: Item1 (Quantity: 10)"));

        // Reset System.out
        System.setOut(System.out);
    }
}