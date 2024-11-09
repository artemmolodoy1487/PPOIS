package by.starovoitov.shop.logic;

public class Transaction {
    Wallet sender;
    Wallet receiver;

    public Transaction(Wallet sender, Wallet receiver, int amount) {
        this.sender = sender;
        this.receiver = receiver;

        sender.sendMoney(amount, receiver);

    }

}
