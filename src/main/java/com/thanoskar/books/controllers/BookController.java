package com.thanoskar.books.controllers;

import com.thanoskar.books.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.thanoskar.books.services.BookService;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService){
        this.bookService = bookService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/books/{isbn}")
     void createBook(
            @PathVariable final String isbn,
            @RequestBody final Book book){
        book.setIsbn(isbn);
        bookService.save(book);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/books/{isbn}")
    void updateBook(
            @PathVariable final String isbn,
            @RequestBody final Book book){
        bookService.save(book);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping(path = "/books")
    public List<Book> listBooks(){
        return bookService.listBooks();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/books/{isbn}")
    public Optional<Book> retrieveBook(@PathVariable String isbn){
        Optional<Book> book = bookService.findById(isbn);
        if(book.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return bookService.findById(isbn);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/books/{isbn}")
    public void deleteBook(@PathVariable String isbn){
        bookService.deleteBookById(isbn);
    }


}
























