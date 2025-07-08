package com.example.fabrick.client;

public enum EndPoint {
    ACCOUNTGET("/api/gbs/banking/v4.0/accounts", HttpMethod.GET),

    ACCOUNTSPOST("/api/gbs/banking/v4.0/accounts",HttpMethod.POST) ;




    public final String phat;
    public final HttpMethod method;


    EndPoint(String phat, HttpMethod method) {
        this.phat = phat;
        this.method = method;
    }



}
