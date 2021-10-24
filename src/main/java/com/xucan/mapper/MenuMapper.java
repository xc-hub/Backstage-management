package com.xucan.mapper;

import com.xucan.domain.bookCategory;
import com.xucan.domain.bookCategory1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MenuMapper {
    //    直接查询二级级联菜单
    List<bookCategory> bookMenu();

    //    分页查询二级级联菜单
    List<bookCategory> bookCategory();

    //    分页查询二级菜单中子查询，根据parent查询孩子结点
    List<bookCategory1> findMenuByParent(String parent);
    //    直接查询一级菜单
    List<bookCategory> bookMenu1();
    //    直接查询二级菜单
    List<bookCategory> bookMenu2();
    //插入一级菜单
    void insertCategory(bookCategory1 b);
    //插入二级菜单
    void insertCategory1(bookCategory1 b);
    //    修改一级菜单名称
    void updateCategroy(bookCategory b);
    //    修改二级菜单名称
    void updateCategroy1(bookCategory b);
    //    删除一级菜单
    void deleteCategory(bookCategory b);
    //    删除二级菜单
    void deleteCategory1(Integer id);
    String bookMenuById(Integer id);
    List<bookCategory1> findMenuByParent1(String parent);
}
