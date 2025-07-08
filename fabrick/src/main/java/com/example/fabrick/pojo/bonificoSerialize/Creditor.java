package com.example.fabrick.pojo.bonificoSerialize;

import com.example.fabrick.pojo.bonificoSerialize.request.Account;
import com.example.fabrick.pojo.bonificoSerialize.request.Address;

public class Creditor {
    private String name;
    private Account account;
    private Address address;

    public Account getAccount() {
        return account;
    }

    public Creditor() {
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
