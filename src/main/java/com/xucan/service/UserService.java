package com.xucan.service;

import com.github.pagehelper.PageInfo;
import com.xucan.domain.User;
import com.xucan.domain.bookCategory;
import com.xucan.domain.bookCategory1;

import java.util.List;
import java.util.Map;

/**
 * @autor xucan
 * @create 2021-06-25-10:44
 */
public interface UserService {
   //    查询所有用户
   List<User> findAll();
   //    根据id查用户
   User findUserById(Integer uid);
   //    分页查询所有用户
   PageInfo<User> FindUserPage(String uname, int pageNum, int pageSize);
   //    插入新用户
   void insertUser(User user);
   //  根据ID删除用户
   void deleteUser(Integer uid);
   //    更新用户信息
   void updateUser(User user);

   User login(User user);
}
