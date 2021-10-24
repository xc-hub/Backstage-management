package com.xucan.service.impl;

import com.xucan.domain.BookInfo;
import com.xucan.mapper.DataMapper;
import com.xucan.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 11355
 * @date 2021/8/27 16:29
 */
@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataMapper dataMapper;
    @Override
    public List<BookInfo> findAllByClick() {
        return dataMapper.findAllByClick();
    }
}
