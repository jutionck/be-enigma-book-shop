package com.enigma.bookStore.Service;

import com.enigma.bookStore.Entity.MemberhasBooks;
import com.enigma.bookStore.Repository.TransactionsRepository;
import com.enigma.bookStore.dto.RequestTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface TransactionsService {

   public MemberhasBooks create(RequestTransactions trx);


}
