package com.example.book.repository;

import com.example.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Modifying
    @Query(value = "update book set amount = (amount-1) where id=:id", nativeQuery = true)
    void borrow(@Param("id") int id);

    @Modifying
    @Query(value = "update book set amount = (amount+1) where id=:id", nativeQuery = true)
    void pay(@Param("id") int id);
}
