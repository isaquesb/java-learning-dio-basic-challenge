package com.github.isaquesb.learning.java.bank;

public class Terminal {

    public static void main(String[] args) {
        Account account = new AccountChecking();

        AccountOpener opener = new AccountOpener(account, System.in, System.out);

        String welcomeText = opener.setBank(new Bank("MyBank"))
            .captureNumber()
            .captureAgency()
            .captureName()
            .captureBalance()
            .getWelcomeText();

        System.out.println(welcomeText);
    }
}
