package com.thanoskar.books.services.impl;

import com.thanoskar.books.domain.Book;
import com.thanoskar.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thanoskar.books.services.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(final BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean bookExists(Book book) {
        return bookRepository.existsById(book.getIsbn());
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(String isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public List<Book> listBooks() {
         return bookRepository.findAll();
    }

    @Override
    public void deleteBookById(String isbn) {
        bookRepository.deleteById(isbn);
    }
}
