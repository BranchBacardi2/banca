package com.example.fabrick.pojo.bonificoSerialize.response;

public class Amount {
    private Long debtorAmount;
    private String debtorCurrency;
    private Long creditorAmount;
    private String creditorCurrency;
    private String creditorCurrencyDate;
    private Integer exchangeRate;

    public Amount() {
    }

    public Integer getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Integer exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCreditorCurrencyDate() {
        return creditorCurrencyDate;
    }

    public void setCreditorCurrencyDate(String creditorCurrencyDate) {
        this.creditorCurrencyDate = creditorCurrencyDate;
    }

    public String getCreditorCurrency() {
        return creditorCurrency;
    }

    public void setCreditorCurrency(String creditorCurrency) {
        this.creditorCurrency = creditorCurrency;
    }

    public Long getCreditorAmount() {
        return creditorAmount;
    }

    public void setCreditorAmount(Long creditorAmount) {
        this.creditorAmount = creditorAmount;
    }

    public String getDebtorCurrency() {
        return debtorCurrency;
    }

    public void setDebtorCurrency(String debtorCurrency) {
        this.debtorCurrency = debtorCurrency;
    }

    public Long getDebtorAmount() {
        return debtorAmount;
    }

    public void setDebtorAmount(Long debtorAmount) {
        this.debtorAmount = debtorAmount;
    }
}
