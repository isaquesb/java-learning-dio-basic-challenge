package com.github.isaquesb.learning.java.bank;

import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountOpenerTest {

    @Test
    @Order(1)
    void accountOpenerCaptureNumber() {
        ByteArrayInputStream testIn = new ByteArrayInputStream("987444".getBytes());
        AccountOpener opener = new AccountOpener(new AccountSaving(), testIn, System.out);
        opener.captureNumber();
        Assertions.assertEquals(987444, opener.getAccount().getNumber());
    }

    @Test
    @Order(2)
    void accountOpenerCaptureBalance() {
        ByteArrayInputStream testIn = new ByteArrayInputStream("10".getBytes());
        AccountOpener opener = new AccountOpener(new AccountSaving(), testIn, System.out);
        opener.captureBalance();
        Assertions.assertEquals(10, opener.getAccount().getBalance());
    }

    @Test
    @Order(3)
    void accountOpenerCaptureName() {
        ByteArrayInputStream testIn = new ByteArrayInputStream("John".getBytes());
        AccountOpener opener = new AccountOpener(new AccountSaving(), testIn, System.out);
        opener.captureName();
        Assertions.assertEquals("John", opener.getAccount().getName());
    }

    @Test
    @Order(4)
    void accountOpenerCaptureAgency() {
        ByteArrayInputStream testIn = new ByteArrayInputStream("123456".getBytes());
        AccountOpener opener = new AccountOpener(new AccountSaving(), testIn, System.out);
        opener.captureAgency();
        Assertions.assertEquals("123456", opener.getAccount().getAgency());
    }

    @Test
    @Order(5)
    void accountOpenerSayWelcome(){
        Account account = new AccountChecking();
        account.bank = new Bank("TestBank");
        account.number = 123;
        account.agency = "1234";
        account.name = "Test";
        account.balance = 10.0;

        AccountOpener opener = new AccountOpener(account, System.in, System.out);
        String welcomeText = opener.getWelcomeText();
        Assertions.assertEquals(
            "Hello Test, Welcome to TestBank"
                + ", thank you for creating an account with us, your agency is 1234"
                + ", account 123 and your balance 10.0 is already available for withdrawal",
                welcomeText
        );
    }
}
