package com.example.demo.service.implementation;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Random;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    @Override
    public Book create(final Book book) {
        log.info("Saving new book: {}", book.getTitle());
        book.setImageUrl(setBookImageUrl());
        return bookRepo.save(book);
    }

    @Override
    public Collection<Book> list(final int limit) {
        log.info("Fetching all book");
        return bookRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Book get(final Long id) {
        log.info("Fetching book by id: {}", id);
        return bookRepo.findById(id).get();
    }

    @Override
    public Book update(final Book book) {
        log.info("Updating new book: {}", book.getTitle());
        return bookRepo.save(book);
    }

    @Override
    public Boolean delete(final Long id) {
        log.info("Deleting book by id: {}", id);
        bookRepo.deleteById(id);
        return Boolean.TRUE;
    }

    private String setBookImageUrl() {
        String[] imageNames = {"book1.png, book2.png, book3.png, book4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/library/image" + imageNames[new Random().nextInt(4)]).toUriString();
    }
}
