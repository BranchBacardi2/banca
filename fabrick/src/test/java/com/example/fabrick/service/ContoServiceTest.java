package com.example.fabrick.service;

import com.example.fabrick.client.Client;
import com.example.fabrick.exeptions.WrongParamitersExeption;
import com.example.fabrick.jpa.TransazioniRepository;
import com.example.fabrick.pojo.ResposeClient;
import com.example.fabrick.pojo.bonificoSerialize.request.Bonifico;
import com.example.fabrick.pojo.bonificoSerialize.response.BonificoResponse;
import com.example.fabrick.pojo.saldo.Saldo;
import com.example.fabrick.pojo.transactionSerialize.TransactionList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class ContoServiceTest {


    @InjectMocks
    ContoService service;

    @Mock
    Client clientUtil;

    @Mock
    HttpClient client;
    @Mock
    HttpRequest request;

    @Mock
    HttpRequest.Builder builderRequest;

    @Mock
    HttpResponse<String> response;

    @Mock
    HttpClient.Builder builderClient;

    @Mock
    TransazioniRepository repoTrans;


    private ObjectMapper mapper = new ObjectMapper();
    @BeforeEach
    public void mokHttp() throws IOException, InterruptedException, URISyntaxException {
        MockedStatic<HttpClient> utilities = Mockito.mockStatic(HttpClient.class);
        Mockito.when(clientUtil.generateBuilderRequest(any(), any())).thenReturn(builderRequest);
        Mockito.when(clientUtil.generateBuilderRequest(any(), any(), any())).thenReturn(builderRequest);
        Mockito.when(builderRequest.build()).thenReturn(request);
        utilities.when(HttpClient::newBuilder).thenReturn(builderClient);
        Mockito.when(builderClient.build()).thenReturn(client);
        Mockito.when(client.send(request, HttpResponse.BodyHandlers.ofString())).thenReturn(response);
        Mockito.when(repoTrans.saveAllAndFlush(any())).thenReturn(new ArrayList<>());
    }


    @Test
    public void   callSaldoCorrect() throws URISyntaxException, IOException, InterruptedException {
        String content = Files.readString(Paths.get("src/test/resources/bodySaldo200ResposnseBody.json"));
        Mockito.when(response.body()).thenReturn(content);
        ResposeClient<Saldo> result = service.callSaldo(1L);
        Assertions.assertEquals("OK",result.getStatus());
    }


    @Test
    public void callTransazioni200() throws WrongParamitersExeption, URISyntaxException, IOException, InterruptedException {
        String content = Files.readString(Paths.get("src/test/resources/callTransazioni200BodyResponse.json"));
        Mockito.when(response.body()).thenReturn(content);
        LocalDate startDate = LocalDate.parse("2019-04-01");
        LocalDate endDate = LocalDate.parse("2019-05-01");
        ResposeClient<TransactionList> result = service.callTransazioni(1L,startDate,endDate);
        Assertions.assertEquals(2,result.getPayload().getList().size());
    }


    @Test
    public void callTransazioniDateError() throws  IOException {
        String content = Files.readString(Paths.get("src/test/resources/callTransazioni200BodyResponse.json"));
        Mockito.when(response.body()).thenReturn(content);
        LocalDate endDate = LocalDate.parse("2019-04-01");
        LocalDate startDate = LocalDate.parse("2019-05-01");
        Exception exception = assertThrows(WrongParamitersExeption.class, () -> {
            service.callTransazioni(1L,startDate,endDate);
        });
        String expectedMessage = "deve essere precedente alla data finale";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void TransazioniDecorator200() throws IOException, WrongParamitersExeption, URISyntaxException, InterruptedException {
        String content = Files.readString(Paths.get("src/test/resources/callTransazioni200BodyResponse.json"));
        Mockito.when(response.body()).thenReturn(content);
        LocalDate startDate = LocalDate.parse("2019-04-01");
        LocalDate endDate = LocalDate.parse("2019-05-01");
        ResposeClient<TransactionList> result = service.decoretorCallTransazioniWhitStrocio(1L,startDate,endDate);
        Assertions.assertEquals(2,result.getPayload().getList().size());
    }


    @Test
    public void doBonifico200() throws IOException, WrongParamitersExeption, URISyntaxException, InterruptedException {
        String contentRequest = Files.readString(Paths.get("src/test/resources/doBonifico200BodyRequest.json"));
        String contentResponse = Files.readString(Paths.get("src/test/resources/doBonifico200ResponseBody.json"));
        Mockito.when(response.body()).thenReturn(contentResponse);
        Bonifico bonifico = mapper.readValue(contentRequest,Bonifico.class);
        ResposeClient<BonificoResponse> result= service.doBonifico(bonifico,1L);
        assertEquals("452516859427",result.getPayload().getMoneyTransferId());
    }


    @Test
    public void doBonificoMissingMandatoryFild() throws IOException {
        String contentRequest = Files.readString(Paths.get("src/test/resources/doBonifico200BodyRequest.json"));
        Mockito.when(response.body()).thenReturn(contentRequest);
        Bonifico bonifico = mapper.readValue(contentRequest,Bonifico.class);
        bonifico.getCreditor().setName("");
        bonifico.setCurrency(null);
        bonifico.setExecutionDate("");
        Exception exception = assertThrows(WrongParamitersExeption.class, () -> {
            service.doBonifico(bonifico,1L);
        });
        String expectedMessage = " è obbligatorio";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }



}
