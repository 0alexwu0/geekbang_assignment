package com.alex.demo.controller;

import com.alex.demo.dto.UserDto;
import com.alex.demo.service.UserService;
import com.alex.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestBody UserVo vo) {
        if(userService.changeUser(vo) > 0){
            return "YES";
        }else{
            return "NO";
        }
    }

    @RequestMapping("/getById")
    @ResponseBody
    public UserDto getById(@RequestBody UserVo vo) {
        return userService.getUserByUserId(vo.getUserId());
    }
}
