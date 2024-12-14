package by.starovoitov.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {
    @Test
    public void testMoneyDetails() {
        Money money = new Money(1500.0, "USD");
        assertEquals(1500.0, money.getAmount());
        assertEquals("USD", money.getCurrency());
    }
}
