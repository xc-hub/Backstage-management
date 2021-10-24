package com.xucan.controller;

import com.github.pagehelper.PageInfo;
import com.xucan.domain.User;
import com.xucan.domain.bookCategory;
import com.xucan.domain.bookCategory1;
import com.xucan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

/**
 * @autor xucan
 * @create 2021-06-19-15:25
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

//  不分页查询所有用户
    @RequestMapping("/user")
    public List<User> findAll(){
       return userService.findAll();
    }

//    分页查询所有用户
    @GetMapping("/userPage")
    public PageInfo<User> findAllPage(@RequestParam String uname,@RequestParam(defaultValue ="1") Integer pageNum, @RequestParam(defaultValue = "2") Integer pageSize){
        return userService.FindUserPage(uname,pageNum,pageSize);
    }

//  根据id查询用户
    @RequestMapping("/userById/{uid}")
    public User findUserById(@PathVariable("uid") Integer uid){
        return userService.findUserById(uid);
    }

//  插入用户信息
    @PostMapping("/user")
    public void insertUser(@RequestBody User user){
//        System.out.println(user);
        userService.insertUser(user);
    }

//  根据id删除用户
    @DeleteMapping("/user/{uid}")
    public void deleteUser(@PathVariable("uid") Integer uid){

        userService.deleteUser(uid);
    }

    //更新用户信息
    @CrossOrigin(origins = "*",maxAge = 3600)
    @PutMapping("/user")
    public void updateUser(@RequestBody User user){
//        System.out.println(user);
        userService.updateUser(user);
    }

}
