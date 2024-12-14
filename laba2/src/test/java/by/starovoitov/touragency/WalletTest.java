package by.starovoitov.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    @Test
    public void testWalletBalance() {
        Wallet wallet = new Wallet(100.0);
        assertEquals(100.0, wallet.getBalance());
        wallet.deposit(50.0);
        assertEquals(150.0, wallet.getBalance());
        assertTrue(wallet.withdraw(100.0));
        assertEquals(50.0, wallet.getBalance());
        assertFalse(wallet.withdraw(100.0));
    }
}
