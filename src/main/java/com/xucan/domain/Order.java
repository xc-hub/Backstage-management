package com.xucan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String oid;
    private String open_id;
    private String price;
    private Integer count;
    private Date create_time;
    private String status;
    private List<OrderDetail> children;
}
