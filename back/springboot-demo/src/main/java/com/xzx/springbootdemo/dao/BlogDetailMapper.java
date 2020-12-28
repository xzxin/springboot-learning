package com.xzx.springbootdemo.dao;

public interface BlogDetailMapper {
    Integer createBlogDetail(Integer blogId);
    Integer getBlogThumbsUp(Integer blogId);
    Integer setBlogThumbsUp(Integer blogId, Integer thumbsUp);
    Integer setBlogComments(Integer blogId, String blogComments);
    Integer deleteAllBlogDetail();
}
