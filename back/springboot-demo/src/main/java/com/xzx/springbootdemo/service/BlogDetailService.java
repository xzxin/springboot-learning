package com.xzx.springbootdemo.service;

public interface BlogDetailService {
    boolean createBlogDetailItem(int blogId);
    boolean thumbsUpToBlog(int blogId);
    boolean setCommentsToBlog(int blogId, String comments);
    void deleteAllBlogDetail();
}
