package com.xucan;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xucan.domain.User;
import com.xucan.domain.bookCategory;
import com.xucan.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;
import java.util.Map;

/**
 * @autor xucan
 * @create 2021-06-20-10:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
      List<User> user = userMapper.findAll();
      System.out.println(user);
    }

    @Test
    public void testFindUserById(){
        User user = userMapper.findUserById(2);
        System.out.println(user);
    }

    @Test
    public void testFindUserPage(){
//        方式一
//        PageHelper.startPage(1, 5);
//        List<User> list = userMapper.FindUserPage();
//        PageInfo<User> pageInfo = new PageInfo<>(list);
        String name = "sad";
        PageInfo<User> pageInfo =PageHelper.startPage(1, 5).doSelectPageInfo(()->{
            userMapper.FindUserPage(name);
        });
        System.out.println(pageInfo);
    }
//    测试不分页查询二级菜单
    @Test
    public void bookMenu(){
//        List<bookCategory> user = userMapper.bookMenu();
//        System.out.println(user);
    }
//    测试分页查询二级菜单
    @Test
    public void bookCategroy(){
//        List<bookCategory> user = userMapper.bookCategory();
//        System.out.println(user);
    }
}
