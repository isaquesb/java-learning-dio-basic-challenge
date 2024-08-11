package com.github.isaquesb.learning.java.bank;

import java.util.Optional;

public class Transaction {

    double value;

    String description;

    public Transaction(double value, String description) {
        this.value = value;
        this.description = Optional.ofNullable(description).orElseGet(() -> "Unknown");
    }

    public double getValue() {
        return value;
    }
}
