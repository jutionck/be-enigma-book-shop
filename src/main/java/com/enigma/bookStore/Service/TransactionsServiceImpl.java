package com.enigma.bookStore.Service;

import com.enigma.bookStore.Entity.Book;
import com.enigma.bookStore.Entity.Member;
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

    @Autowired
    BookService serviceBook;

    @Autowired
    MemberService serviceMember;


    @Override
    public void create(MemberhasBooks trx) {
        repository.save(trx);
    }

    @Override
    public List<MemberhasBooks> getByMember(Integer id) {
        return repository.findMemberhasBooksByMemberEquals(id);
    }


}
