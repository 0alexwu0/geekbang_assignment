package com.alex.starter;

import com.alex.starter.bean.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AlexApplication {

    @Autowired
    private AutoConfiguration config;

    public static void main(String[] args) {
        SpringApplication.run(AlexApplication.class, args);
    }

    @RequestMapping("/index")
    public School index() {
        return config.AutoConfiguration();
    }
}
