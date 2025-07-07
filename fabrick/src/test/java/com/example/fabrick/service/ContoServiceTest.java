package com.example.fabrick;

import com.example.fabrick.client.Client;
import com.example.fabrick.service.ContoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.example.fabrick.client.EndPoint.ACCOUNTGET;

@SpringBootTest
public class ContoServiceTest {


    @InjectMocks
    private ContoService service;

    @Mock
    private Client clientUtil;

    @Mock
    HttpClient client;
    @Mock
    HttpRequest request;

    @Mock
    HttpRequest.Builder builder;

    @Mock
    HttpResponse<String> respose;

    @Test
    public void   callSaldoCorrect() throws URISyntaxException, IOException, InterruptedException {
        Mockito.when(clientUtil.generateBuilderRequest(ACCOUNTGET, Mockito.any())).thenReturn(builder);
        Mockito.when(builder.build()).thenReturn(request);
        Mockito.when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(respose);
    }


}
