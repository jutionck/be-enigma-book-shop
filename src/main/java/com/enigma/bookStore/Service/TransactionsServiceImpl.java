package com.enigma.bookStore.Service;

import com.enigma.bookStore.Entity.Book;
import com.enigma.bookStore.Entity.Member;
import com.enigma.bookStore.Entity.MemberhasBooks;
import com.enigma.bookStore.Repository.BookRepository;
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
    public MemberhasBooks create(RequestTransactions trx) {
        MemberhasBooks transactions = new MemberhasBooks();
        for (Integer id: trx.getBookId()) {
            Integer totalPrice = 0;
            Book book = serviceBook.getBookById(id);
            Member member = serviceMember.getMemberById(trx.getMemberId());
            totalPrice += (book.getPrice() * trx.getQuantity());
            transactions.setBook(book);
            transactions.setMember(member);
            transactions.setQuantity(trx.getQuantity());
            transactions.setTotalPrice(totalPrice);
            book.setPurchaseAmount(book.getPurchaseAmount()+trx.getQuantity());
            book.setStock(book.getStock()- trx.getQuantity());
            serviceBook.addBook(book);
        }
        return repository.save(transactions);
    }


}
