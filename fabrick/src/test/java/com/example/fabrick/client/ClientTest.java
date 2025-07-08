package com.example.fabrick.client;

import com.example.fabrick.service.ContoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import static com.example.fabrick.client.EndPoint.ACCOUNTGET;
import static com.example.fabrick.client.EndPoint.ACCOUNTSPOST;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ClientTest {

    @Value("${client.url.base}")
     String urlBase;

    @Mock
    HttpRequest.Builder builder;

    @Autowired
    private Client client;


    @Test
    public void generateBuilderRequestGetCorrect() throws URISyntaxException {
        HttpRequest.Builder result= client.generateBuilderRequest(ACCOUNTGET,"test");
        Assertions.assertEquals(ACCOUNTGET.method.toString(),result.build().method());
        Assertions.assertEquals(urlBase+ACCOUNTGET.phat+"test",result.build().uri().toString());
    }

    @Test
    public void generateBuilderRequestGetCorrectBody() throws URISyntaxException {
        HttpRequest.Builder result= client.generateBuilderRequest(ACCOUNTSPOST,"test","Body");
        Assertions.assertEquals(ACCOUNTSPOST.method.toString(),result.build().method());
        Assertions.assertEquals(urlBase+ACCOUNTSPOST.phat+"test",result.build().uri().toString());

    }
}
