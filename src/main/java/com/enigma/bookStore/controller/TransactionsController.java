package com.enigma.bookStore.controller;

import com.enigma.bookStore.Entity.MemberhasBooks;
import com.enigma.bookStore.Service.TransactionsService;
import com.enigma.bookStore.constant.ResponseMessage;
import com.enigma.bookStore.dto.RequestTransactions;
import com.enigma.bookStore.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    TransactionsService service;

    @PostMapping
    public ResponseEntity<Response<MemberhasBooks>> saveTrx(@RequestBody RequestTransactions trx) {
        Response<MemberhasBooks> response = new Response<>();
        String message = String.format(ResponseMessage.SUCCESS, "transactions");
        response.setMessage(message);
        response.setData(service.create(trx));
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
