package com.alex.jdbcdemo.controller;

import com.alex.jdbcdemo.entity.User;
import com.alex.jdbcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public User save() {
        User user = new User();
        int id = new Random().nextInt(10000);
        user.setUsername(id+"");

        this.userService.insert(user);
        return user;
    }

    @RequestMapping("/getById")
    @ResponseBody
    public User getById(Integer id) {
        User user = this.userService.getById(id);
        return user;
    }

    @RequestMapping("/update")
    public void update() {
        User user = new User();
        user.setId(1);
        user.setUsername("1234");
        this.userService.update(user);
    }

    @RequestMapping("/delete")
    public void deleteById(Integer id) {
        int result = this.userService.delete(id);
        System.out.println(result);
    }
}
