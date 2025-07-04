package com.example.fabrick;

import com.example.fabrick.service.ContoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootTest
public class ContoServiceTest {

    @Autowired
    private ContoService service;


    @Test
    public void callTransazioniNotError()  {
        String s = service.callTransazioni();
        Assertions.assertNotEquals("500 error",s);
    }

    @Test
    public void callSaldoNotError()  {
        String s = service.callSaldo();
        Assertions.assertNotEquals("500 error",s);
    }


}
