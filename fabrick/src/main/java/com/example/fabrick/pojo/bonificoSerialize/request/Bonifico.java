package com.example.fabrick.pojo.bonificoSerialize.request;

import com.example.fabrick.pojo.Currency;
import com.example.fabrick.pojo.bonificoSerialize.Creditor;


public class Bonifico {
   private Creditor creditor;
   private String executionDate;
   private String uri;
   private String description;
   private String amount ;
   private Currency currency;
   private Boolean isUrgent;
   private Boolean isInstant;
   private String feeType;
   private Long feeAccountId;
   private TaxRelief taxRelief;

    public Bonifico() {
      }

    public Bonifico(Creditor creditor, String executionDate, String description, String amount, Currency currency) {
        this.creditor = creditor;
        this.executionDate = executionDate;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
    }


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Boolean getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(Boolean urgent) {
        isUrgent = urgent;
    }

    public Boolean getIsInstant() {
        return isInstant;
    }

    public void setIsInstant(Boolean instant) {
        isInstant = instant;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Long getFeeAccountId() {
        return feeAccountId;
    }

    public void setFeeAccountId(Long feeAccountId) {
        this.feeAccountId = feeAccountId;
    }

    public TaxRelief getTaxRelief() {
        return taxRelief;
    }

    public void setTaxRelief(TaxRelief taxRelief) {
        this.taxRelief = taxRelief;
    }

    public Creditor getCreditor() {
        return creditor;
    }

    public void setCreditor(Creditor creditor) {
        this.creditor = creditor;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }


}
