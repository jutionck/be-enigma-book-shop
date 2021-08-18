package com.enigma.bookStore.Service;

import com.enigma.bookStore.Entity.Member;
import com.enigma.bookStore.Entity.MemberhasBooks;
import com.enigma.bookStore.Repository.TransactionsRepository;
import com.enigma.bookStore.dto.RequestTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionsService {

   public void create(MemberhasBooks trx);
   public List<MemberhasBooks> getByMember(Integer id);

}
