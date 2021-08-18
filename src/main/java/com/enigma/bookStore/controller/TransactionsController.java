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

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    TransactionsService service;

    @GetMapping("/{id}")
    public List<MemberhasBooks> getByMemberId(@PathVariable Integer id){
        return service.getByMember(id);
    }
}
