package by.starovoitov.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    @Test
    public void testPaymentDetails() {
        Payment payment = new Payment(200.0, "Credit Card");
        assertEquals(200.0, payment.getAmount());
        assertEquals("Credit Card", payment.getMethod());
    }
}
