package com.xucan.controller;

import com.github.pagehelper.PageInfo;
import com.xucan.domain.BookInfo;
import com.xucan.domain.Order;
import com.xucan.domain.OrderDetail;
import com.xucan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
//import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {
    @Autowired
    private OrderService orderService;

    //    添加订单
    @PostMapping("order")
    public void insertOrder(@RequestBody Order order){
//        //        生产订单id
//        int machineId = 1;//最大支持1-9个集群机器部署
//        int hashCodev = UUID.randomUUID().toString().hashCode();
//        if(hashCodev < 0){
//            //有可能是负数
//            hashCodev = -hashCodev;
//        }
//        order.setOid(machineId + String.format("%015d", hashCodev));
        //        生成创建时间
        final Date date = new Date();
        order.setCreate_time(date);
        //        设置状态
        order.setStatus("待支付");
//        System.out.println(order);
        orderService.insertOrder(order);
    }
    //    添加订单详情
    @PostMapping("orderDetail")
    public void insertOrderDetail(@RequestBody OrderDetail orderDetail){
        orderService.insertOrderDetail(orderDetail);
    }
    //    更新订单状态
    @PutMapping("order/{oid}")
    public void updateOrderStatus(@PathVariable("oid")String oid){
        orderService.updateOrderStatus(oid);
    }
    //    获取所有订单根据open_id
    @GetMapping("order/{open_id}")
    public List<Order> findAllOrder(@PathVariable("open_id")String open_id){
        return orderService.findAllOrder(open_id);
    }
    @DeleteMapping("order/{oid}")
    public void deletedOrder(@PathVariable("oid") String oid){
        orderService.deletedOrder(oid);
    }
    //    分页查询所有订单
    @RequestMapping("order")
    public PageInfo<BookInfo> findAllPage(@RequestParam String oid, @RequestParam(defaultValue ="1") Integer pageNum, @RequestParam(defaultValue = "2") Integer pageSize){
        return orderService.findOrderPage(oid,pageNum,pageSize);
    }
    @PutMapping("orderDetail")
    public void updateOrderDetail(@RequestBody OrderDetail orderDetail){
        orderService.updateOrderDetail(orderDetail);
    }
}
