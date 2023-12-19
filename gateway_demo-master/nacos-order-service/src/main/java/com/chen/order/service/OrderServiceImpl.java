package com.chen.order.service;

import com.chen.order.UserProxy;
import com.chen.order.entiy.Order;
import com.chen.order.entiy.User;
import com.chen.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserProxy userProxy;

    @Override
    public Order queryOrderById(int orderId) {
        //1. 查询订单
        Order order = orderMapper.findById(orderId);
        //2. 查询用户
        List<User> userList = userProxy.query(order.getUserId());
        order.setUser(userList);

        return order;
    }
}
