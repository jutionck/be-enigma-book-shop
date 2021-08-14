package com.enigma.bookStore.Service;

import com.enigma.bookStore.Entity.MemberhasBooks;
import com.enigma.bookStore.Repository.TransactionsRepository;
import com.enigma.bookStore.dto.RequestTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsServiceImpl implements TransactionsService{

    @Autowired
    TransactionsRepository repository;


    @Override
    public MemberhasBooks create(RequestTransactions trx) {
        List<RequestTransactions> trxBooks;
//        List<MemberhasBooks> tempTransactions = repository
        return null;
    }
}
