package com.example.book.service;

import com.example.book.model.BorrowBook;

public interface BorrowBookService {
    boolean delete(int code);
    BorrowBook findById(int code);

    int randomCode();

    void save(BorrowBook borrowBook);
}
