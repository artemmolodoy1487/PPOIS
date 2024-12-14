package by.starovoitov.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    @Test
    public void testClientDetails() {
        Client client = new Client("John Doe", "john@example.com");
        assertEquals("John Doe", client.getName());
        assertEquals("john@example.com", client.getEmail());
    }
}
