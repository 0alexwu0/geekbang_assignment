package com.alex.jdbcdemo.service;

import com.alex.jdbcdemo.entity.User;

public interface UserService {
    int insert(User user);

    int delete(Integer id);

    int update(User user);

    User getById(Integer id);
}
