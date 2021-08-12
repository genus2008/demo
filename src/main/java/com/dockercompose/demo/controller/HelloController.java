package com.dockercompose.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/hello")
    public String hello() {
        Long views = stringRedisTemplate.opsForValue().increment("views");
        return "hello ,thank you .views:" + views;
    }
}
