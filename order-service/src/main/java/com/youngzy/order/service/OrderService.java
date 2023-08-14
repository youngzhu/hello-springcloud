package com.youngzy.order.service;

import com.youngzy.feign.client.UserClient;
import com.youngzy.feign.pojo.User;
import com.youngzy.order.mapper.OrderMapper;
import com.youngzy.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        // 2. 利用FeignClient发起HTTP请求，获取用户信息
        User user = userClient.findById(order.getUserId());
        // 3. set user
        order.setUser(user);

        // 4.返回
        return order;
    }

//    @Autowired
//    private RestTemplate restTemplate;
//
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//
//        // 2. 利用RestTemplate发起HTTP请求，获取用户信息
////        String url = "http://localhost:8081/user/" + order.getUserId();
//        String url = "http://userservice/user/" + order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
//        // 3. set user
//        order.setUser(user);
//
//        // 4.返回
//        return order;
//    }
}
