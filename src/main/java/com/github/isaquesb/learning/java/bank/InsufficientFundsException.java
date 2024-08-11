package com.github.isaquesb.learning.java.bank;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super("Insufficient funds");
    }
}
