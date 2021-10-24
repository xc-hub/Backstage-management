package com.xucan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SCminineed {
    private Integer book_id;
    private String book_name;
    private String book_price;
    private String book_image;
    private Integer shopping_id;
    private Integer count;
    private boolean checked;
}
