package com.youngzy.order.service;

import com.youngzy.order.mapper.OrderMapper;
import com.youngzy.order.pojo.Order;
import com.youngzy.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        // 2. 利用RestTemplate发起HTTP请求，获取用户信息
//        String url = "http://localhost:8081/user/" + order.getUserId();
        String url = "http://userservice/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        // 3. set user
        order.setUser(user);

        // 4.返回
        return order;
    }
}
