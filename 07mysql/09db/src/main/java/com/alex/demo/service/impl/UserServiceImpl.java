package com.alex.demo.service.impl;

import com.alex.demo.db.Read;
import com.alex.demo.dto.UserDto;
import com.alex.demo.mapping.UserMapper;
import com.alex.demo.service.UserService;
import com.alex.demo.utils.BeanConvertUtils;
import com.alex.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Read
    @Override
    public UserDto getUserByUserId(String userId){
        if(StringUtils.isBlank(userId)){
            return new UserDto();
        }

        return userMapper.findUserByUserId(userId);
    }

    @Override
    public int changeUser(UserVo vo){
        if(vo == null){
            return 0;
        }

        UserDto dto = BeanConvertUtils.beanToBean(vo,UserDto.class);
        return userMapper.updateUser(dto);
    }
}
