package com.example.fabrick.pojo.saldo;

public class Saldo {
    public String date;
    public Float  balance;
    public Float  availableBalance;
    public String currency;

    public Saldo() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Float availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
