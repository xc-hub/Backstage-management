package com.xucan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;

import java.util.List;

/**
 * @autor xucan
 * @create 2021-06-30-10:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class bookCategory1 {
    private Integer id;
    private String parent;
    private String name;
    private String deleted;
    private Integer level;
//    private List<BookInfo> children;
}
