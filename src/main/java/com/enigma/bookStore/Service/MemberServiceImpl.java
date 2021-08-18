package com.enigma.bookStore.Service;

import com.enigma.bookStore.Entity.Book;
import com.enigma.bookStore.Entity.Member;
import com.enigma.bookStore.Entity.MemberhasBooks;
import com.enigma.bookStore.Repository.MemberRepository;
import com.enigma.bookStore.dto.RequestBook;
import com.enigma.bookStore.dto.RequestTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository repository;

    @Autowired
    BookService serviceBook;

    @Autowired
    TransactionsService serviceTrx;

    @Override
    public Member signUp(Member member) {
        return repository.save(member);
    }

    @Override
    public Member signIn(String email, String password) throws FileNotFoundException {
        Member searchEmail = repository.findByEmailEqualsAndPasswordEquals(email, password);
        if (searchEmail!=null && searchEmail.getStatus().equals(0)){
            return searchEmail;
        } else {
            throw new FileNotFoundException("Account not found");
        }
    }

    @Override
    public List<Member> getAllMember() {
        return repository.findAll();
    }

    @Override
    public void deleteMember(Integer id, Integer status) {
        repository.deleteMember(id, status);
    }

    @Override
    public Member getMemberById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void buyBooks(Integer id, RequestTransactions trx) throws FileNotFoundException {
        MemberhasBooks transactions = new MemberhasBooks();
        Member member = getMemberById(id);
        if(member != null && member.getStatus() == 0){
           for (RequestBook book: trx.getBuys()) {
              Integer totalPrice;
              Book books = serviceBook.getBookById(book.getBookId());
              if (books != null){
                  totalPrice = book.getQty() * books.getPrice();
                  transactions.setMember(member);
                  transactions.setBook(books);
                  transactions.setQuantity(book.getQty());
                  transactions.setTotalPrice(totalPrice);
                  books.setPurchaseAmount(books.getPurchaseAmount()+book.getQty());
                  serviceBook.updateBook(book.getBookId(),books);
              } else {
                  throw new FileNotFoundException("Book not found");
              }
           }
        } else {
            throw new FileNotFoundException("Member not found");
        }
        serviceTrx.create(transactions);
    }


}
