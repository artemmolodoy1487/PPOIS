package com.touragency;

import java.util.UUID;

public class Transaction {
    private UUID id;
    private double amount;

    public Transaction(double amount) {
        this.id = UUID.randomUUID();
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}
