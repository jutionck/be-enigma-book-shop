package com.enigma.bookStore.Service;

import com.enigma.bookStore.Entity.Book;

import java.util.List;

public interface BookService {

    public Book addBook(Book book);
    public Book getBookById(Integer id);
    public Book getBookByName(String name);
    public List<Book> getAllBook();
    public void deleteBook(Integer id) throws Exception;
}
