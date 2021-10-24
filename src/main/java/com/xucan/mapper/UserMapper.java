package com.xucan.mapper;

import com.xucan.domain.User;
import com.xucan.domain.bookCategory;
import com.xucan.domain.bookCategory1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @autor xucan
 * @create 2021-06-20-10:01
 */
@Mapper
public interface UserMapper {
//    查询所有用户
//    @Select("select * from user")
    List<User> findAll();

//    根据id查用户
    @Select("select * from user where uid=#{uid}")
    User findUserById(Integer uid);

//    分页查询所有用户
    List<User> FindUserPage(String uname);

//    插入新用户
    void insertUser(User user);

//  根据ID删除用户
    void deleteUser(Integer uid);

//    更新用户信息
    void updateUser(User user);

    User login(User user);
}
