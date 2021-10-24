package com.xucan.mapper;

import com.xucan.domain.BookInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    //    分页查询全部书籍
    List<BookInfo> FindBookPage(String book_name);
    //    插入书籍
    void insertBook(BookInfo book);
    //    根据book_id查询书籍
    BookInfo findBookById(Integer book_id);
    //修改书籍
    void updateBook(BookInfo book);
    //    根据book_id删除书籍
    void deleteBook(Integer book_id);
    //    直接查询所有书籍
    List<BookInfo> findAll(String book_name);
    //    根据类别查询书籍
    List<BookInfo> findByCategory(String book_category);
}
