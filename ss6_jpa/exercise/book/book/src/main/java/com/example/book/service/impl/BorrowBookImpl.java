package com.example.book.service.impl;

import com.example.book.model.BorrowBook;
import com.example.book.repository.BorrowBookRepository;
import com.example.book.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowBookImpl implements BorrowBookService {
    @Autowired
    private BorrowBookRepository borrowBookRepository;

    @Override
    public boolean delete(int code) {
        List<BorrowBook> list = borrowBookRepository.findAll();
        boolean flag = false;
        for (BorrowBook item: list) {
            if (item.getCode()==code){
                borrowBookRepository.remove(code);
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public BorrowBook findById(int code) {
        return borrowBookRepository.findById(code).get();
    }

    @Override
    public int randomCode() {
        List<BorrowBook> borrowBookList = borrowBookRepository.findAll();
        do {
            boolean flag = true;
            String temp = "";
            for (int i = 0; i < 5; i++) {
                int number = (int) (Math.random() * 10);
                temp += number;
            }
            int result = Integer.parseInt(temp);
            for (BorrowBook item : borrowBookList) {
                if (item.getCode() == result) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return result;
            }
        } while (true);
    }

    @Override
    public void save(BorrowBook borrowBook) {
        borrowBookRepository.save(borrowBook);
    }
}
