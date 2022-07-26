package com.example.book.model;

import javax.persistence.*;

@Entity
public class BorrowBook {
    @Id
    private int code;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    public BorrowBook() {
    }

    public BorrowBook(int code, Book book) {
        this.code = code;
        this.book = book;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
