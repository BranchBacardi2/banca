package com.example.fabrick.jpa;

import com.example.fabrick.pojo.transactionSerialize.Transaction;
import jakarta.persistence.*;

import java.sql.Date;

@Entity(name="P001_TRANSACTION")
public class TransazioniEntity {

    @Id
    @Column(name="P001_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "P001_USER_ID")
    private long userId;

    @Column(name = "P001_ACCOUNTING_DATE")
    private Date accountingDate;

    @Column(name = "P001_VALUE_DATE")
    private Date valueDate;

    @Column(name = "P001_AMOUNT")
    private long amount;

    @Column(name = "P001_TYPE_ENUM")
    private String typeEnum;

    @Column(name = "P001_TYPE_VALUE")
    private String typeValue;

    @Column(name = "P001_CURRENCY")
    private String currency;

    @Column(name = "P001_DESCRIPTION")
    private String description;


    public TransazioniEntity() {
    }

    public TransazioniEntity(Transaction transaction, Long customerId) {
     this.id=  transaction.getTransactionId();
     this.userId=customerId;
     this.accountingDate= Date.valueOf(transaction.getAccountingDate());
     this.valueDate= Date.valueOf(transaction.getValueDate());
     this.amount=transaction.getAmount();
     this.typeEnum=transaction.getType().getEnumeration();
     this.typeValue=transaction.getType().getValue();
     this.currency=transaction.getCurrency();
     this.description= transaction.getDescription();
    }



    public long getId() {
        return id;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(Date accountingDate) {
        this.accountingDate = accountingDate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(String typeEnum) {
        this.typeEnum = typeEnum;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
