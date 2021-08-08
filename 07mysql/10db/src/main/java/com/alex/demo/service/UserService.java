package com.alex.demo.service;

import com.alex.demo.dto.UserDto;
import com.alex.demo.vo.UserVo;

public interface UserService {

    UserDto getUserByUserId(String userId);

    int changeUser(UserVo vo);
}
