package com.chen.order.controller;

import com.chen.order.entiy.Order;
import com.chen.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId")@RequestBody Integer orderId) {
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }
}