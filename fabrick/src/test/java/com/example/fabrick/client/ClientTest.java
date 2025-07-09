package com.example.fabrick.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import static com.example.fabrick.client.EndPoint.ACCOUNTGET;
import static com.example.fabrick.client.EndPoint.ACCOUNTSPOST;

@SpringBootTest
public class ClientTest {

    @Value("${client.url.base}")
     String urlBase;


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
