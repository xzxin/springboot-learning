package com.xzx.springbootdemo.dao;

import com.xzx.springbootdemo.entity.BlogMeta;

import java.util.List;

public interface BlogMetaMapper {
    int createBlog(BlogMeta blogMeta);
    int updateBlogMeta(BlogMeta blogMeta);
    int deleteBlog(Integer blogId);
    BlogMeta queryBlogMetaById(Integer blogId);
    List<BlogMeta> queryBlogMetaByAuthorId(Integer userId);
    List<BlogMeta> queryAllBlogs();
    Integer deleteAllBlogMeta();
}
