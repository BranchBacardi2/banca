package com.example.fabrick.pojo;

import java.util.Date;

public class Bonifico {
   private Creditor creditor;
   private Date executionDate ;
   private String description;
   private Integer amount ;
   private Currency currency;

    public Bonifico(Creditor creditor, Date executionDate, String description, Integer amount, Currency currency) {
        this.creditor = creditor;
        this.executionDate = executionDate;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
    }

    public Creditor getCreditor() {
        return creditor;
    }

    public void setCreditor(Creditor creditor) {
        this.creditor = creditor;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }


}
