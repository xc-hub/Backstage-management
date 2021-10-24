package com.xucan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * @autor xucan
 * @create 2021-06-30-10:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInfo {
    private Integer book_id;
    private String book_isbn;
    private String book_category;
    private String book_name;
    private String book_image;
    private String book_author;
    private String book_price;//设置成String前端和数据库自动转换（设置成double前端出现问题）验证规则没有小数类型
    private String book_press;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date book_press_time;
    private int book_press_num;
    private int click;
}
