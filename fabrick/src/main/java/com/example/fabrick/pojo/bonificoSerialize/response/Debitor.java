package com.example.fabrick.pojo.bonificoSerialize.response;

import com.example.fabrick.pojo.bonificoSerialize.request.Account;

public class Debitor {
    private String name;
    private   Account  account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Debitor() {
    }
}
