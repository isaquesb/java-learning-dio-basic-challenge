package com.github.isaquesb.learning.java.bank;

public interface MakesWithdraw {
    public double withdraw(Transaction tx) throws InsufficientFundsException;
}
