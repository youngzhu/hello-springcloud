package com.youngzy.order;

import com.youngzy.feign.client.UserClient;
import com.youngzy.feign.config.FeignConfig;
import com.youngzy.feign.pojo.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("com.youngzy.order.mapper")
@SpringBootApplication
@EnableFeignClients(defaultConfiguration = FeignConfig.class, clients = UserClient.class)
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}