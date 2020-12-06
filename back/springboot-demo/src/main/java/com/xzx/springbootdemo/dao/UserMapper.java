package com.xzx.springbootdemo.dao;

import com.xzx.springbootdemo.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> findAllUsers();

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);
}
