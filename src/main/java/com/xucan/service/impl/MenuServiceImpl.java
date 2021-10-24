package com.xucan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xucan.domain.bookCategory;
import com.xucan.domain.bookCategory1;
import com.xucan.mapper.MenuMapper;
import com.xucan.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    //    直接查询二级级联菜单
    @Override
    public List<bookCategory> bookMenu() {
        return menuMapper.bookMenu();
    }
    //    分页查询二级级联菜单
    @Override
    public PageInfo<bookCategory> bookCategory(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);//这句话必须在第一句（必须在要分页对象声明之前）
        List<bookCategory> bookCategory1 = menuMapper.bookCategory();
//        System.out.println(bookCategory1.size());
        for(int i=0;i<bookCategory1.size();i++) {//调用子查询
            bookCategory1.get(i).setChildren(findMenuByParent(bookCategory1.get(i).getName()));
        }
        PageInfo<bookCategory> page = new PageInfo<>(bookCategory1);
        return page;
    }
    //    分页查询二级菜单中子查询，根据parent查询孩子结点
    @Override
    public List<bookCategory1> findMenuByParent(String parent) {
        return menuMapper.findMenuByParent(parent);
    }
    //    不分页查询一级菜单
    @Override
    public List<bookCategory> bookMenu1() {
        return menuMapper.bookMenu1();
    }
    //    不分页查询二级菜单
    @Override
    public List<bookCategory> bookMenu2() {
        return menuMapper.bookMenu2();
    }

    //    插入分类
    @Override
    public void insertCategory(bookCategory1 b) {
        if(b.getParent().equals(""))
            menuMapper.insertCategory(b);//插入一级菜单
        else
            menuMapper.insertCategory1(b);//插入二级菜单
    }
    //    更新分类信息
    @Override
    public void updateCategory(bookCategory b) {
        if(b.getLevel()==1)
            menuMapper.updateCategroy(b);
        else
            menuMapper.updateCategroy1(b);
    }
    //    删除分类信息
    @Override
    public void deleteCategory(bookCategory b) {
        if(b.getLevel()==1){
            String name =menuMapper.bookMenuById(b.getId());
             List<bookCategory1> list= menuMapper.findMenuByParent1(name);
            System.out.println(list);
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i).getId());
                menuMapper.deleteCategory1(list.get(i).getId());
            }
            menuMapper.deleteCategory(b);
        }else{
            menuMapper.deleteCategory1(b.getId());
        }
    }
}
