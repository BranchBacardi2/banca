package com.example.fabrick.pojo.transactionSerialize;

public class Transaction {
    private Long transactionId;
    private Long operationId;
    private String accountingDate;
    private String valueDate;
    private TransactionType type;
    private Long amount;
    private String currency;
    private String description;


    /********
     * {
     *       "transactionId": "1331714087",
     *       "operationId": "00000000273015",
     *       "accountingDate": "2019-04-01",
     *       "valueDate": "2019-04-01",
     *       "type": {
     *         "enumeration": "GBS_TRANSACTION_TYPE",
     *         "value": "GBS_TRANSACTION_TYPE_0023"
     *       },
     *       "amount": -800,
     *       "currency": "EUR",
     *       "description": "BA JOHN DOE PAYMENT INVOICE 75/2017"
     *     },
     * ********/

    public Transaction() {
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(String accountingDate) {
        this.accountingDate = accountingDate;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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
