package com.xucan.controller;


import com.github.pagehelper.PageInfo;
import com.xucan.domain.BookInfo;
import com.xucan.domain.User;
import com.xucan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookController {
    @Autowired
    private BookService bookService;
    //    直接查询所有书籍
    @GetMapping("/book")
    public List<BookInfo> findAll(@RequestParam String book_name){
        return bookService.findAll(book_name);
    }
    //    根据类别查询书籍
    @RequestMapping("/bookCategory/{book_category}")
    public List<BookInfo> findByCategory(@PathVariable("book_category") String book_category){
        return bookService.findByCategory(book_category);
    }
    //    分页查询所有书籍
    @RequestMapping("/bookPage")
    public PageInfo<BookInfo> findAllPage(@RequestParam String book_name, @RequestParam(defaultValue ="1") Integer pageNum, @RequestParam(defaultValue = "2") Integer pageSize){
        return bookService.FindBookPage(book_name,pageNum,pageSize);
    }
    //  插入书籍book
    @PostMapping("/book")
    public void insertUser(@RequestBody BookInfo book){
        bookService.insertBook(book);
    }
    //  根据book_id查询书籍
    @RequestMapping("/book/{book_id}")
    public BookInfo findBookById(@PathVariable("book_id") Integer book_id){
        return bookService.findBookById(book_id);
    }
    //    修改书籍
    @PutMapping("/book")
    public void upateBook(@RequestBody BookInfo book){
        bookService.updateBook(book);
    }
    //    根据id删除书籍
    @DeleteMapping("/book/{book_id}")
    public void deleteBook(@PathVariable("book_id") Integer book_id){
        bookService.deleteBook(book_id);
    }
}
