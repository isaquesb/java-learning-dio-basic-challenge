package com.github.isaquesb.learning.java.bank;

public interface MakesTransfer {
    public void transfer(Account to, Transaction tx) throws InsufficientFundsException;
}
