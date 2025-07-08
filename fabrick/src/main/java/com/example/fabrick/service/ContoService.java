package com.example.fabrick.service;




import com.example.fabrick.client.Client;
import com.example.fabrick.exeptions.WrongParamitersExeption;
import com.example.fabrick.pojo.ResposeClient;
import com.example.fabrick.pojo.saldo.Saldo;
import com.example.fabrick.pojo.bonificoSerialize.request.Bonifico;
import com.example.fabrick.pojo.bonificoSerialize.response.BonificoResponse;
import com.example.fabrick.pojo.transactionSerialize.TransactionList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.fabrick.client.EndPoint.ACCOUNTGET;
import static com.example.fabrick.client.EndPoint.ACCOUNTSPOST;


@Service
public class ContoService {
    private static Logger logger = Logger.getLogger("ContoService");


    @Autowired
    Client clientUtil;

    private ObjectMapper mapper = new ObjectMapper();

    private  void  chekMandatoryFilds(List<Pair<String,String>> filds) throws WrongParamitersExeption {
        logger.log(Level.INFO,"see if there are all mandatory filds");
        for (Pair<String,String> fild : filds){
            String value= fild.getValue1();
            if(value.isBlank()){
                WrongParamitersExeption ex =   new  WrongParamitersExeption(fild.getValue0());
                logger.log(Level.WARNING,ex.getMessage());
                throw  ex;
            }
         logger.log(Level.INFO,"chek {}",fild.getValue0());
        }
        logger.log(Level.INFO,"chek are all mandatory filds");
    }

    public  ResposeClient<TransactionList>  callTransazioni(Long  id, LocalDate startDate , LocalDate endDate) throws WrongParamitersExeption, URISyntaxException, IOException, InterruptedException {
        List<Pair<String,String>>mandatoryFilds = new ArrayList<>(Arrays.asList(
                new Pair<String,String>("data di inizio ricerca ", startDate.toString()),
                new  Pair<String,String>("data di  fine ricerca ", endDate.toString())));
       this.chekMandatoryFilds(mandatoryFilds);
       logger.log(Level.INFO,"see if the date are right");
        if(startDate.isAfter(endDate)){
            WrongParamitersExeption  ex = new WrongParamitersExeption("startDate","deve essere precedente alla data finale");
            logger.log(Level.WARNING,ex.getMessage());
            throw   ex;
        }
        try {
            SimpleDateFormat dt = new SimpleDateFormat("YYYY-MM-DD");
            String start= startDate.toString();
            String end = endDate.toString();
            logger.log(Level.INFO,"invoke service for  get transazioni");
            HttpRequest request = clientUtil.generateBuilderRequest(ACCOUNTGET,"/"+id+"/transactions?fromAccountingDate="+start+"&toAccountingDate="+end).build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> respose = client.send(request, HttpResponse.BodyHandlers.ofString());
            return  mapper.readValue(respose.body(),ResposeClient.class);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw  ex ;
        }
    }


    public ResposeClient<Saldo> callSaldo(Long  id) throws URISyntaxException, IOException, InterruptedException {
        try {
            logger.log(Level.INFO,"invoke service for  get saldo");
            HttpRequest request = clientUtil.generateBuilderRequest(ACCOUNTGET,"/"+id+"/balance").build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(response.body(),ResposeClient.class);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw  ex;
        }
    }

    
    public ResposeClient<BonificoResponse> doBonifico(Bonifico bonifico, Long accountId) throws WrongParamitersExeption, URISyntaxException, IOException, InterruptedException {
        logger.log(Level.INFO,"invoke service for do e bonifico");
        logger.log(Level.INFO,"bonifico: {}" ,bonifico);
        List<Pair<String,String>>mandatoryFilds = new ArrayList<>(Arrays.asList(
                                         new Pair<String,String>("nome creditore", bonifico.getCreditor().getName()),
                                         new Pair<String,String>("currency", bonifico.getCurrency()==null?"":bonifico.getCurrency().name()),
                                         new Pair<String,String>("codice account del creditore", bonifico.getCreditor().getAccount().getAccountCode()),
                                         new Pair<String,String>("data di esecuzione", bonifico.getExecutionDate())));
        this.chekMandatoryFilds(mandatoryFilds);
        LocalDate bonificoExecutionDate = LocalDate.parse(bonifico.getExecutionDate());
        if(bonificoExecutionDate.isAfter(LocalDate.now())){
             logger.log(Level.WARNING,"the user insert a wrong data ");
             throw new WrongParamitersExeption("date del bonifico"," deve essere antecedente");
         }
        try {
            String bonificoString  = mapper.writeValueAsString(bonifico);
            HttpRequest request = clientUtil.generateBuilderRequest(ACCOUNTSPOST,"/"+ accountId+"/payments/money-transfers",bonificoString).build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> respose = client.send(request, HttpResponse.BodyHandlers.ofString());
            return  mapper.readValue(respose.body(),ResposeClient.class);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            throw  ex;
        }

    }


   }


