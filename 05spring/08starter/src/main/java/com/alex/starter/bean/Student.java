package com.alex.starter.bean;

import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.alex.student")
public class Student {

    private String id;
    private String name;

    public void test() {
        System.out.println("Student id:"+id);
        System.out.println("Student name:"+name);
        System.out.println("time:"+new Date());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
