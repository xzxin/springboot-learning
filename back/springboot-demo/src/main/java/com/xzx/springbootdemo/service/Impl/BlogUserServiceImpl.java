package com.xzx.springbootdemo.service.Impl;

import com.xzx.springbootdemo.dao.BlogUserMapper;
import com.xzx.springbootdemo.entity.BlogUser;
import com.xzx.springbootdemo.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogUserServiceImpl implements BlogUserService {
    @Resource
    BlogUserMapper blogUserMapper;

    @Override
    public List<BlogUser> queryAllUser() {
        return blogUserMapper.queryAllUsers();
    }

    @Override
    public BlogUser queryUserById(Integer id) {
        return blogUserMapper.queryUserById(id);
    }

    @Override
    public int updateUser(BlogUser user) {
        return blogUserMapper.updateUser(user);
    }

    @Override
    public int addUser(BlogUser user) {
        return blogUserMapper.addUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return blogUserMapper.deleteUserById(id);
    }

    @Override
    public void deleteAllBlogUser() {
        blogUserMapper.deleteAllBlogUsers();
    }
}
