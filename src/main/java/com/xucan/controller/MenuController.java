package com.xucan.controller;

import com.github.pagehelper.PageInfo;
import com.xucan.domain.bookCategory;
import com.xucan.domain.bookCategory1;
import com.xucan.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class MenuController {
    @Autowired
    private MenuService menuService;
    //  不分页查询二级级联菜单
    @RequestMapping("/category")
    public List<bookCategory> bookMenu(){
        return menuService.bookMenu();
    }
    //  分页查询二级级联菜单
    @RequestMapping("/categoryPage")
    public PageInfo<bookCategory> bookCategory(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
//        System.out.println(pageNum);
        return menuService.bookCategory(pageNum,pageSize);
    }
    //    不分页查询一级菜单
    @RequestMapping("/category1")
    public List<bookCategory> bookMenu1(){
        return menuService.bookMenu1();
    }
    //    不分页查询二级菜单
    @RequestMapping("/category2")
    public List<bookCategory> bookMenu2(){
        return menuService.bookMenu2();
    }
    //插入菜单
    @PostMapping("/category")
    public void insertCategory(@RequestBody bookCategory1 b){
        menuService.insertCategory(b);
    }
    //修改菜单
    @PutMapping("/category")
    public void updateCategory(@RequestBody bookCategory b)
    {
        menuService.updateCategory(b);
    }
    @DeleteMapping("/category")
    public void deleteCategory(@RequestBody bookCategory b)
    {
        menuService.deleteCategory(b);
    }
}
