package com.xucan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor xucan
 * @create 2021-06-20-9:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uid;
    private String uname;
    private String password;
    private String address;
    private String email;
    private String tel;
    private String character1;
}
