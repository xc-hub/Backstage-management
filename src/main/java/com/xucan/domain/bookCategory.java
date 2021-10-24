package com.xucan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @autor xucan
 * @create 2021-06-30-10:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class bookCategory {
    private Integer id;
    private String name;
    private String deleted;
    private Integer level;
    private List<bookCategory1> children;
}
