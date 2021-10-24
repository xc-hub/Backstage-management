package com.xucan.service;

import com.github.pagehelper.PageInfo;
import com.xucan.domain.bookCategory;
import com.xucan.domain.bookCategory1;

import java.util.List;

public interface MenuService {
    //    直接查询二级级联菜单
    List<bookCategory> bookMenu();
    //    分页查询二级级联菜单
    PageInfo<bookCategory> bookCategory(int pageNum, int pageSize);
    //    分页查询二级菜单中子查询，根据parent查询孩子结点
    List<bookCategory1> findMenuByParent(String parent);
    //   不分页查询一级菜单
    List<bookCategory> bookMenu1();
    //   不分页查询二级菜单
    List<bookCategory> bookMenu2();
    //   插入菜单
    void insertCategory(bookCategory1 b);
    //   修改分类信息
    void updateCategory(bookCategory b);

    //    删除分类信息
    void deleteCategory(bookCategory b);
}
