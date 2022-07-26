package com.example.book.controller;

import com.example.book.model.BorrowBook;
import com.example.book.service.BookService;
import com.example.book.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowBookService borrowBookService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("list", bookService.findAll());
        return "list";
    }

    @GetMapping("/borrow/{id}")
    public String showBorrow(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("code", borrowBookService.randomCode());
        return "borrow";
    }

    @PostMapping("/borrow")
    public String borrow(int code, int book) {
        BorrowBook borrowBook = new BorrowBook(code, bookService.findById(book));
        borrowBookService.save(borrowBook);
        bookService.borrow(borrowBook.getBook().getId());
        return "redirect:/list";
    }

    @GetMapping("/pay")
    public String pay(@RequestParam int code) throws Exception {
        boolean temp = borrowBookService.delete(code);
        if (temp==false){
            throw new Exception();
        }
        BorrowBook borrowBook = borrowBookService.findById(code);
        bookService.pay(borrowBook.getBook().getId());
        return "redirect:/list";
    }
}
