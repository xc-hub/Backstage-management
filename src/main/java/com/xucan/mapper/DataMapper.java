package com.xucan.mapper;

import com.xucan.domain.BookInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 11355
 * @date 2021/8/27 16:31
 */
@Mapper
public interface DataMapper {
    List<BookInfo> findAllByClick();
}
