package com.alex.jdbcdemo.dto;

import com.alex.jdbcdemo.entity.User;

public interface UserDao {
    int insert(User user);

    int delete(int id);

    int update(User user);

    User getById(int id);
}
