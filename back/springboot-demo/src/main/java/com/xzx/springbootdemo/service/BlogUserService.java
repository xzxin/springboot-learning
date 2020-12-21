package com.xzx.springbootdemo.service;

import com.xzx.springbootdemo.entity.BlogUser;

import java.util.List;

public interface BlogUserService {
    public List<BlogUser> queryAllUser();

    public BlogUser queryUserById(Integer id);

    public int updateUser(BlogUser user);

    public int addUser(BlogUser user);

    public int deleteUserById(Integer id);
}
