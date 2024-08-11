package com.github.isaquesb.learning.java.bank;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountTest {

    @Test
    @Order(1)
    void accountProperties() {
        Account account = new AccountChecking();
        account.bank = new Bank("TestBank");
        account.number = 123;
        account.agency = "1234";
        account.name = "Test";
        account.balance = 10.0;

        Assertions.assertEquals("TestBank", account.getBank().getName());
        Assertions.assertEquals(123, account.getNumber());
        Assertions.assertEquals("1234", account.getAgency());
        Assertions.assertEquals("Test", account.getName());
        Assertions.assertEquals(10.0, account.getBalance());
    }

    @Test
    @Order(2)
    void accountDeposit() {
        Account account = new AccountChecking();
        account.balance = 12.0;
        Transaction tx = new Transaction(10.0, "Deposit");
        account.deposit(tx);

        Assertions.assertEquals(22.0, account.getBalance());
    }

    @Test
    @Order(3)
    void accountWithdraw() throws InsufficientFundsException {
        Account account = new AccountChecking();
        account.balance = 12.0;
        Transaction tx = new Transaction(10.0, "Deposit");
        double newBalance = account.withdraw(tx);

        Assertions.assertEquals(2.0, account.getBalance());
        Assertions.assertEquals(2.0, newBalance);
    }

    @Test
    @Order(4)
    void accountWithdrawNegativeValue() {
        Account account = new AccountChecking();
        account.balance = 12.0;
        Transaction tx = new Transaction(-10.0, "Deposit");
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.withdraw(tx));
    }

    @Test
    @Order(5)
    void accountWithdrawZeroValue() {
        Account account = new AccountChecking();
        account.balance = 12.0;
        Transaction tx = new Transaction(0.0, "Deposit");
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.withdraw(tx));
    }

    @Test
    @Order(6)
    void accountWithdrawInsufficientFunds() {
        Account account = new AccountChecking();
        account.balance = 12.0;
        Transaction tx = new Transaction(20.0, "Deposit");
        Assertions.assertThrows(InsufficientFundsException.class, () -> account.withdraw(tx));
    }
}
