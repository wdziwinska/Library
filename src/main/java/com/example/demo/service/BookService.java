package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.Collection;

public interface BookService {
    Book create(Book book);
    Collection<Book> list(int limit);
    Book get(Long id);
    Book update(Book book);
    Boolean delete(Long id);
}
