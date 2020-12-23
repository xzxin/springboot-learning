package com.xzx.springbootdemo.service;

import com.xzx.springbootdemo.entity.BlogUser;

import java.util.List;

public interface BlogUserService {
    List<BlogUser> queryAllUser();

    BlogUser queryUserById(Integer id);

    int updateUser(BlogUser user);

    int addUser(BlogUser user);

    int deleteUserById(Integer id);
}
