package com.xucan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xucan.domain.BookInfo;
import com.xucan.domain.Order;
import com.xucan.domain.OrderDetail;
import com.xucan.mapper.OrderMapper;
import com.xucan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    //    添加订单
    @Override
    public void insertOrder(Order order) {
        orderMapper.insertOrder(order);
    }
    //    添加订单详情
    @Override
    public void insertOrderDetail(OrderDetail orderDetail) {
        orderMapper.insertOrderDetail(orderDetail);
    }
    //    更新订单状态
    @Override
    public void updateOrderStatus(String oid) {
        orderMapper.updateOrderStatus(oid);
    }
    //    获取所有订单根据open_id
    @Override
    public List<Order> findAllOrder(String open_id) {
       return orderMapper.findAllOrder(open_id);
    }

    /**
     * @Author 11355
     * @Description 根据oid删除 订单 ，两张表都删除
     * @Date 17:45 2021/8/26
     * @Param [java.lang.String]
     * @return void
     **/
    @Override
    public void deletedOrder(String oid) {
        orderMapper.deleteOrderDetail(oid);
//        List<OrderDetail> allOrderDetailByOid = orderMapper.findAllOrderDetailByOid(oid);
        orderMapper.deletedOrder(oid);
    }
    /**
     * @Author 11355
     * @Description 分页查询
     * @Date 17:46 2021/8/26
     * @Param [java.lang.String, java.lang.Integer, java.lang.Integer]
     * @return com.github.pagehelper.PageInfo<com.xucan.domain.BookInfo>
     **/
    @Override
    public PageInfo<BookInfo> findOrderPage(String oid, Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->{
            orderMapper.findOrderPage(oid);
        });
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {
        orderMapper.updateOrderDetail(orderDetail);
    }
}
