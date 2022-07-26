package com.example.book.repository;

import com.example.book.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface BorrowBookRepository extends JpaRepository<BorrowBook,Integer> {
    @Modifying
    @Query(value = "delete from borrow_book where code=:code",nativeQuery = true)
    void remove(@Param("code") int code);
}
