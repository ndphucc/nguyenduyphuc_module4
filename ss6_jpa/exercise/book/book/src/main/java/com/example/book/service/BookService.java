package com.example.book.service;

import com.example.book.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(int id);
    void pay(int id);
    void borrow(int id);
}
