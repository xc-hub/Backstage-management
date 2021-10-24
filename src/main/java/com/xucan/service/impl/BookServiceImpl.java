package com.xucan.service.impl;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.xucan.domain.BookInfo;
import com.xucan.mapper.BookMapper;
import com.xucan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    //    分页查询所有书籍
    @Override
    public PageInfo<BookInfo> FindBookPage(String book_name, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->{
            bookMapper.FindBookPage(book_name);
        });
    }
    //    插入书籍
    @Override
    public void insertBook(BookInfo book) {
        bookMapper.insertBook(book);
    }
    //    根据book_id查询书籍
    @Override
    public BookInfo findBookById(Integer book_id) {
        return bookMapper.findBookById(book_id);
    }
    //    修改书籍
    @Override
    public void updateBook(BookInfo book) {
        bookMapper.updateBook(book);
    }
    //    根据book_id删除书籍
    @Override
    public void deleteBook(Integer book_id) {
        bookMapper.deleteBook(book_id);
    }
    //    直接查询所有书籍
    @Override
    public List<BookInfo> findAll(String book_name) {
        return bookMapper.findAll(book_name);
    }
    //    根据类别查询书籍
    @Override
    public List<BookInfo> findByCategory(String book_category) {
        return bookMapper.findByCategory(book_category);
    }
}
