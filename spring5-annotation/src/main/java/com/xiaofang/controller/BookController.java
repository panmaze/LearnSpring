package com.xiaofang.controller;

import com.xiaofang.service.BookService;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    private BookService bookService;


    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
