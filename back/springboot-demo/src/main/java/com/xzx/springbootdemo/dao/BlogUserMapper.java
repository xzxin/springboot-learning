package com.xzx.springbootdemo.dao;

import com.xzx.springbootdemo.entity.BlogUser;

import java.util.List;

public interface BlogUserMapper {
    List<BlogUser> queryAllUsers();

    BlogUser queryUserById(Integer id);

    int addUser(BlogUser user);

    int updateUser(BlogUser user);

    int deleteUserById(Integer id);
}
