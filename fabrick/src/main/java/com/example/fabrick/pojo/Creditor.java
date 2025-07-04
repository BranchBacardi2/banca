package com.example.fabrick.pojo;

public class Creditor {
    private String name;
    private Account account;

    public Account getAccount() {
        return account;
    }

    public Creditor(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public Creditor(String name, String accountCode) {
        this.name = name;
        this.account = new Account(accountCode);
    }

    public Creditor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
