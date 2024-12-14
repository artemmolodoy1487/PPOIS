package by.starovoitov.touragency;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    private List<Transaction> transactions;

    public BlockChain() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
