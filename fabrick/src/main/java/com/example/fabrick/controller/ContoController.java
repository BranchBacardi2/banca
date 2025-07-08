package com.example.fabrick.controller;

import com.example.fabrick.pojo.ResposeClient;
import com.example.fabrick.pojo.saldo.Saldo;
import com.example.fabrick.pojo.bonificoSerialize.request.Bonifico;
import com.example.fabrick.pojo.bonificoSerialize.response.BonificoResponse;
import com.example.fabrick.pojo.transactionSerialize.TransactionList;
import com.example.fabrick.service.ContoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController()
public class ContoController {

    @Autowired
    ContoService service;

    @GetMapping("transactions/{id}")
    public ResposeClient<TransactionList> getAllTransaction( @PathVariable Long id, @RequestParam("fromAccountingDate") String startDate,@RequestParam("toAccountingDate") String endDate) throws Exception {
        LocalDate dateStart = LocalDate.parse(startDate);
        LocalDate dateEnd = LocalDate.parse(endDate);
        return service.callTransazioni(  id, dateStart , dateEnd);
    }


    @GetMapping("saldo/{id}")
    public ResposeClient<Saldo> getSaldo(@PathVariable Long id) throws Exception {
      return   service.callSaldo(id);
    }

   @PostMapping("bonifico/{id}")
    public ResposeClient<BonificoResponse> doBonifico(@RequestBody Bonifico bonifico, @PathVariable Long id) throws Exception {
    return   service.doBonifico( bonifico,  id);
   }



}
