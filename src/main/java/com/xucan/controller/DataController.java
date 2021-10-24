package com.xucan.controller;

import com.xucan.domain.BookInfo;
import com.xucan.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 11355
 * @date 2021/8/27 16:26
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class DataController {
    @Autowired
    private DataService dataService;
    @GetMapping("hotBook")
    public List<BookInfo> findAllByClick(){
        return dataService.findAllByClick();
    }
}
