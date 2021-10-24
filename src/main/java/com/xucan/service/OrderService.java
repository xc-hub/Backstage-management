package com.xucan.service;

import com.github.pagehelper.PageInfo;
import com.xucan.domain.BookInfo;
import com.xucan.domain.Order;
import com.xucan.domain.OrderDetail;

import java.util.List;

public interface OrderService {
    //    添加订单
    void insertOrder(Order order);
    //    添加订单详情
    void insertOrderDetail(OrderDetail orderDetail);
    //    更新订单状态
    void updateOrderStatus(String oid);
    //    获取所有订单根据open_id
    List<Order> findAllOrder(String open_id);
    //    删除订单
    void deletedOrder(String oid);
    //    分页查询所有订单
    PageInfo<BookInfo> findOrderPage(String oid, Integer pageNum, Integer pageSize);

    void updateOrderDetail(OrderDetail orderDetail);
}
