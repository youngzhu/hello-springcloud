package com.youngzy.order.client;

import com.youngzy.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author youngzy
 * @since 2023-08-11
 */
@FeignClient("userservice") // 服务名
public interface UserClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
