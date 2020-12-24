package com.xzx.springbootdemo.service;

public interface BlogDetailService {
    boolean thumbsUpToBlog(int blogId);
    boolean setCommentsToBlog(int blogId, String comments);
}
