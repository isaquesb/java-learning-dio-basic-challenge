package com.github.isaquesb.learning.java.bank;

public abstract class Account implements MakesDeposit, MakesTransfer, MakesWithdraw {
    Bank bank;

    int number;

    String agency;

    String name;

    double balance;

    public Bank getBank() {
        return bank;
    }

    public int getNumber() {
        return number;
    }

    public String getAgency() {
        return agency;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void transfer(Account to, Transaction tx) throws InsufficientFundsException {
        Transfer transfer = new Transfer(tx, this, to);
        transfer.execute();
    }

    public double withdraw(Transaction tx) throws InsufficientFundsException {
        if (tx.getValue() <= 0) {
            throw new IllegalArgumentException("Value must be greater than zero");
        }
        synchronized (this) {
            if (balance < tx.getValue()) {
                throw new InsufficientFundsException();
            }
            balance -= tx.getValue();
        }
        return getBalance();
    }

    public double deposit(Transaction tx) {
        synchronized (this) {
            balance += tx.getValue();
        }
        return getBalance();
    }
}
