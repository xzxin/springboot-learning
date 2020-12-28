package com.xzx.springbootdemo.service.Impl;

import com.xzx.springbootdemo.dao.BlogMetaMapper;
import com.xzx.springbootdemo.entity.BlogMeta;
import com.xzx.springbootdemo.service.BlogMetaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BlogMetaServiceImpl implements BlogMetaService {
    @Resource
    BlogMetaMapper blogMetaMapper;

    @Override
    public int createBlog(BlogMeta blogMeta) {
        return blogMetaMapper.createBlog(blogMeta);
    }

    @Override
    public int updateBlogMeta(BlogMeta blogMeta) {
        return blogMetaMapper.updateBlogMeta(blogMeta);
    }

    @Override
    public int deleteBlog(Integer blogId) {
        return blogMetaMapper.deleteBlog(blogId);
    }

    @Override
    public BlogMeta queryBlogMetaById(Integer blogId) {
        return blogMetaMapper.queryBlogMetaById(blogId);
    }

    @Override
    public List<BlogMeta> queryBlogMetaByAuthorId(Integer userId) {
        return blogMetaMapper.queryBlogMetaByAuthorId(userId);
    }

    @Override
    public List<BlogMeta> queryAllBlogs() {
        return blogMetaMapper.queryAllBlogs();
    }

    @Override
    public void deleteAllBlogMeta() {
        blogMetaMapper.deleteAllBlogMeta();
    }
}
