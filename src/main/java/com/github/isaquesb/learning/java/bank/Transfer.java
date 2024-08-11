package com.github.isaquesb.learning.java.bank;

public class Transfer {

    Transaction tx;

    final Account origin;

    final Account destination;

    public Transfer(Transaction transaction, Account origin, Account destination) {
        this.tx = transaction;
        this.origin = origin;
        this.destination = destination;
    }

    public void execute() throws InsufficientFundsException {
        if (origin.balance < tx.getValue()) {
            throw new InsufficientFundsException();
        }
        synchronized (origin) {
            synchronized (destination) {
                origin.balance -= tx.getValue();
                destination.balance += tx.getValue();
            }
        }
    }
}
