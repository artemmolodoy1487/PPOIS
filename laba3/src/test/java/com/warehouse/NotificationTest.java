package com.warehouse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NotificationTest {
    @Test
    public void testSendNotification() {
        Notification notification = new Notification();

        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notification.sendNotification("Test message");
        assertTrue(outContent.toString().contains("Notification: Test message"));

        // Reset System.out
        System.setOut(System.out);
    }
}
