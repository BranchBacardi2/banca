package com.example.fabrick.service;



import com.example.fabrick.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.fabrick.client.EndPoint.ACCOUNTGET;


@Service
public class ContoService {
    private static Logger logger = Logger.getLogger("ContoService");


    @Autowired
    Client client;

    public String callTransazioni() {
        try {
            HttpRequest request = client.generateBuilderRequest(ACCOUNTGET,"");
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> respose = client.send(request, HttpResponse.BodyHandlers.ofString());
            return respose.body();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
        return "500 error";
    }



    public String callSaldo() {
        try {
            HttpRequest request = client.generateBuilderRequest(ACCOUNTGET,"/"+client.accountId);
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> respose = client.send(request, HttpResponse.BodyHandlers.ofString());
            return respose.body();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
        return "500 error";
    }


   }


