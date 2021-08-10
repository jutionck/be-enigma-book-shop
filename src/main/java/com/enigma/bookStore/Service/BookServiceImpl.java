package com.enigma.bookStore.Service;

import com.enigma.bookStore.Entity.Book;
import com.enigma.bookStore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository repository;


    @Override
    public Book addBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book getBookById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Book getBookByName(String name) {
        return repository.findBookByTitle(name);
    }

    @Override
    public List<Book> getAllBook() {
        return repository.findAll();
    }

    @Override
    public void deleteBook(Integer id) throws Exception {
        Book book = getBookById(id);
        if (book.getPurchaseAmount() == 0){
            repository.removeBook(id);
        } else {
            throw new Exception("Purchase Amount 0");
        }
    }
}
