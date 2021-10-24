package com.xucan.service;

import com.github.pagehelper.PageInfo;
import com.xucan.domain.BookInfo;

import java.util.List;

public interface BookService {
    //    分页查询所有书籍
    PageInfo<BookInfo> FindBookPage(String book_name, int pageNum, int pageSize);
    //    插入书籍
    void insertBook(BookInfo book);
    //    根据book_id查询书籍
    BookInfo findBookById(Integer book_id);
    //修改书籍
    void updateBook(BookInfo book);
    //    根据book_id删除书籍
    void deleteBook(Integer book_id);
    //直接查询所有书籍
    List<BookInfo> findAll(String book_name);
    //    根据类别查询书籍
    List<BookInfo> findByCategory(String book_category);
}
