package com.xzx.springbootdemo.service.Impl;

import com.xzx.springbootdemo.dao.BlogDetailMapper;
import com.xzx.springbootdemo.service.BlogDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BlogDetailServiceImpl implements BlogDetailService {
    @Resource
    BlogDetailMapper blogDetailMapper;

    @Override
    public boolean thumbsUpToBlog(int blogId) {
        Integer blogThumbsUpNum = blogDetailMapper.getBlogThumbsUp(blogId);
        return blogDetailMapper.setBlogThumbsUp(blogId, blogThumbsUpNum + 1) > 0;
    }

    @Override
    public boolean setCommentsToBlog(int blogId, String comments) {
        return blogDetailMapper.setBlogComments(blogId, comments) > 0;
    }
}
