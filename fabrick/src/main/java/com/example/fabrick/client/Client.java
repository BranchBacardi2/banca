package com.example.fabrick.client;

import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.logging.Level;
import java.util.logging.Logger;


@Component
public class Client {
    private static Logger logger = Logger.getLogger("Client");

    public final   String baseUrl;
    public final   String autShema;
    public final   String apiKey;
    public final   String accountId;




    @Autowired
    public Client(@Value("${client.url.base}")String  baseUrl,
                        @Value("${client.heder.api.key}") String apiKey,
                        @Value("${client.aut.shema}") String autShema,
                        @Value("${client.heder.account.id}") String accountId)
    {
        logger.log(Level.CONFIG,"baseUrl :{}",baseUrl);
        logger.log(Level.CONFIG,"apiKey :{}",apiKey);
        logger.log(Level.CONFIG,"autShema :{}",autShema);
        logger.log(Level.CONFIG,"accountId :{}",accountId);
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.autShema = autShema;
        this.accountId= accountId;
    }

    public HttpRequest.Builder generateBuilderRequest(EndPoint endPoint, String parameters)  {
        String url = baseUrl+endPoint.phat+parameters;
        logger.log(Level.INFO,"call endpoint : phat"+url+" , verbo{}" ,endPoint.method);
        HttpRequest.Builder result =  HttpRequest.newBuilder().
                uri(URI.create(url)).
                version(HttpClient.Version.HTTP_2).
                header("Auth-Schema",autShema).
                header("apikey",apiKey);
        switch (endPoint.method){
            case HttpMethod.GET -> result.GET();
            case HttpMethod.DELETE -> result.DELETE();
        }
        return  result;
    }


    public HttpRequest.Builder generateBuilderRequest(EndPoint endPoint, String parameters, String body) throws URISyntaxException {
        String url = baseUrl+endPoint.phat+parameters;
        logger.log(Level.INFO,"call endpoint : phat"+url+" , verbo{}" ,endPoint.method);
        HttpRequest.Builder result =   HttpRequest.newBuilder().
                uri(URI.create(url)).
                version(HttpClient.Version.HTTP_2).
                header("Auth-Schema",autShema).
                header("apikey",apiKey).
                header("ContentType","application/json");
        switch (endPoint.method){
            case HttpMethod.PUT -> result.PUT(HttpRequest.BodyPublishers.ofString(body));
            case HttpMethod.POST -> result.POST(HttpRequest.BodyPublishers.ofString(body));
        }
        return  result;
    }

}
