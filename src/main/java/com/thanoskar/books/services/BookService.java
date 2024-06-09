package com.thanoskar.books.services;

import com.thanoskar.books.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    boolean bookExists(Book book);

    void save(Book book);

    Optional<Book> findById(String isbn);

    List<Book> listBooks();

    void deleteBookById(String isbn);

}
