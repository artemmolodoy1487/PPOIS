package by.starovoitov.warehouse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ReportTest {
    @Test
    public void testGenerateReport() {
        Warehouse warehouse = new Warehouse("Main Warehouse");
        StockItem item = new StockItem("Item1", 10);
        warehouse.addItem(item);
        Report report = new Report(warehouse);

        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        report.generateReport();
        assertTrue(outContent.toString().contains("Warehouse Report for: Main Warehouse"));
        assertTrue(outContent.toString().contains("Item1: 10"));

        // Reset System.out
        System.setOut(System.out);
    }
}