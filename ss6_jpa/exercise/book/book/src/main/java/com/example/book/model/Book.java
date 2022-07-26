package com.example.book.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Book {
    @Id
    private int id;
    private String name;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<BorrowBook> getBorrowBookSet() {
        return borrowBookSet;
    }

    public void setBorrowBookSet(Set<BorrowBook> borrowBookSet) {
        this.borrowBookSet = borrowBookSet;
    }

    @OneToMany(mappedBy = "book")
    private Set<BorrowBook> borrowBookSet;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
