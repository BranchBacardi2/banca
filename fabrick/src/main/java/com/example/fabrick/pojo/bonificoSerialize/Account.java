package com.example.fabrick.pojo;

public class Account {
   private String  accountCode;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public Account(String accountCode) {
        this.accountCode = accountCode;
    }
}
