package com.xzx.springbootdemo.dao;

public interface BlogDetailMapper {
    Integer getBlogThumbsUp(Integer blogId);
    Integer setBlogThumbsUp(Integer blogId, Integer thumbsUp);
    Integer setBlogComments(Integer blogId, String blogComments);
}
