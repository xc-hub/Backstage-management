package com.xucan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xucan.domain.User;
import com.xucan.domain.bookCategory;
import com.xucan.domain.bookCategory1;
import com.xucan.mapper.UserMapper;
import com.xucan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @autor xucan
 * @create 2021-06-25-10:46
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    //    查询所有用户
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
    //    根据id查用户
    @Override
    public User findUserById(Integer uid) {
        return userMapper.findUserById(uid);
    }
    //    分页查询所有用户
    @Override
    public PageInfo<User> FindUserPage( String uname, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->{
            userMapper.FindUserPage(uname);
        });
    }
    //    插入新用户
    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
    //  根据ID删除用户
    @Override
    public void deleteUser(Integer uid) {
        userMapper.deleteUser(uid);
    }
    //    更新用户信息
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
