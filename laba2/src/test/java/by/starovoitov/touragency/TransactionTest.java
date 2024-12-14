package by.starovoitov.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {
    @Test
    public void testTransactionDetails() {
        Transaction transaction = new Transaction(300.0);
        assertEquals(300.0, transaction.getAmount());
        assertNotNull(transaction.getId());
    }
}
