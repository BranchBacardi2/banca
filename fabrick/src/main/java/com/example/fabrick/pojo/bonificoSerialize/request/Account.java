package com.example.fabrick.pojo.bonificoSerialize.request;

public class Account {
   private String  accountCode;
   private String bicCode;

    public String getAccountCode() {
        return accountCode;
    }

    public String getBicCode() {
        return bicCode;
    }

    public void setBicCode(String bicCode) {
        this.bicCode = bicCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public Account(String accountCode) {
        this.accountCode = accountCode;
    }

    public Account() {

    }
}
