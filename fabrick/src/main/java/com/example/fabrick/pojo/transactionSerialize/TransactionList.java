package com.example.fabrick.pojo.transactionSerialize;

import java.util.ArrayList;



public class TransactionList {
    private ArrayList<Transaction> list;

    public TransactionList() {
    }

    public TransactionList(ArrayList<Transaction> list) {
        this.list = list;
    }

    public ArrayList<Transaction> getList() {
        return list;
    }

    public void setList(ArrayList<Transaction> list) {
        this.list = list;
    }
}
