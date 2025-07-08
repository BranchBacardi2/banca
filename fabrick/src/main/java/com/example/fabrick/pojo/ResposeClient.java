package com.example.fabrick.pojo;

import java.util.ArrayList;

public class ResposeClient<T>{
  String status;
  ArrayList<String> error;
  T  payload;

    public ResposeClient() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getError() {
        return error;
    }

    public void setError(ArrayList<String> error) {
        this.error = error;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
