package com.youngzy.user.web;

import com.youngzy.user.config.PatternProperties;
import com.youngzy.user.pojo.User;
import com.youngzy.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope
public class UserController {
    @Autowired
    private UserService userService;

    // Value 注解读取配置
//    @Value("${pattern.dateformat}")
//    private String dateformat;
    @Autowired
    private PatternProperties properties;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    @GetMapping("now")
    public String now() {
//        return "现在时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
        return "当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }

    @GetMapping("prop")
    public PatternProperties properties() {
        return properties;
    }
}
