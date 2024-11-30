package com.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlockChainTest {
    @Test
    public void testAddTransaction() {
        BlockChain blockChain = new BlockChain();
        Transaction transaction = new Transaction(500.0);
        blockChain.addTransaction(transaction);
        assertEquals(1, blockChain.getTransactions().size());
        assertEquals(500.0, blockChain.getTransactions().get(0).getAmount());
    }
}
