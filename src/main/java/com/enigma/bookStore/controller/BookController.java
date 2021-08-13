package com.enigma.bookStore.controller;

import com.enigma.bookStore.Entity.Book;
import com.enigma.bookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService service;

    @PostMapping
    public Book add(@RequestBody Book book){
        return service.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id,@RequestBody Book book) throws FileNotFoundException {return service.updateBook(id,book);}

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        return service.getBookById(id);
    }

    @GetMapping("/title")
    public Book getBookByTitle(@RequestParam String name){
        return service.getBookByName(name);
    }

    @DeleteMapping("/{id}")
    public void removeBookById(@PathVariable Integer id) throws Exception {
        service.deleteBook(id);
    }

    @GetMapping
    public List<Book> getAllBook(){
        return service.getAllBook();
    }
}
