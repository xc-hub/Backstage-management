package com.xucan.service;

import com.xucan.domain.BookInfo;

import java.util.List;

/**
 * @author 11355
 * @date 2021/8/27 16:28
 */
public interface DataService {
    List<BookInfo> findAllByClick();
}
