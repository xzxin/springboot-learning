package com.xzx.springbootdemo.controller;

import com.xzx.springbootdemo.common.Result;
import com.xzx.springbootdemo.dao.BlogDetailMapper;
import com.xzx.springbootdemo.entity.BlogDetail;
import com.xzx.springbootdemo.service.BlogDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
public class BlogDetailController {
    @Autowired
    BlogDetailService blogDetailService;

    @GetMapping("/blogDetail/thumbsUp")
    @ResponseBody
    public Result<Boolean> thumbsUpBlog(@RequestParam("blogId") Integer blogId) {
        Result<Boolean> result = new Result<>();
        if (blogDetailService.thumbsUpToBlog(blogId)) {
            result.setResultCode(0);
            result.setMessage(String.format(Locale.ENGLISH, "Thumbs up to blog %s successfully", blogId));
        } else {
            result.setResultCode(-1);
            result.setMessage(String.format(Locale.ENGLISH, "Thumbs up to blog %s failed", blogId));
        }
        return result;
    }

    @PostMapping("/blogDetail/setComments")
    @ResponseBody
    public Result<Boolean> setCommentsToBlog(@RequestBody BlogDetail blogDetail) {
        Result<Boolean> result = new Result<>();
        if (blogDetailService.setCommentsToBlog(blogDetail.getBlogId(), blogDetail.getBlogComments())) {
            result.setResultCode(0);
            result.setMessage(String.format(Locale.ENGLISH, "Set comments to blog %s successfully", blogDetail.getBlogId()));
        } else {
            result.setResultCode(-1);
            result.setMessage(String.format(Locale.ENGLISH, "Set comments to blog %s failed", blogDetail.getBlogId()));
        }
        return result;
    }

}
