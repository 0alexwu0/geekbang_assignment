package com.alex.demo;

import com.alex.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoApplicationRunner implements ApplicationRunner {

    @Autowired
    private RedisService redisService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        redisService.subscribeOrder();
    }
}
