package com.xzx.springbootdemo.controller;

import com.xzx.springbootdemo.common.Result;
import com.xzx.springbootdemo.entity.BlogMeta;
import com.xzx.springbootdemo.service.BlogDetailService;
import com.xzx.springbootdemo.service.BlogMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BlogMetaController {
    @Autowired
    BlogMetaService blogMetaService;
    @Autowired
    BlogDetailService blogDetailService;

    @GetMapping("/blogMeta/queryAll")
    @ResponseBody
    public Result<List<BlogMeta>> querryAllUsers() {
        Result<List<BlogMeta>> result = new Result<>();
        result.setResultCode(0);
        result.setMessage("Query suceessfully");
        result.setData(blogMetaService.queryAllBlogs());
        return result;
    }

    @GetMapping("/blogMeta/findBlogById")
    @ResponseBody
    public Result<BlogMeta> findBlogById(@RequestParam("blogId") Integer id) {
        Result<BlogMeta> result = new Result<>();
        BlogMeta blogMeta = blogMetaService.queryBlogMetaById(id);
        if (blogMeta != null) {
            result.setResultCode(0);
            result.setMessage("Query suceessfully");
            result.setData(blogMeta);
        } else {
            result.setResultCode(-1);
            result.setMessage("Query blog by id failed");
        }
        return result;
    }

    @GetMapping("/blogMeta/findBlogByAuthorId")
    @ResponseBody
    public Result<List<BlogMeta>> findBlogsByAuthorId(@RequestParam("authorId") Integer userId) {
        Result<List<BlogMeta>> result = new Result<>();
        List<BlogMeta> blogMetas = blogMetaService.queryBlogMetaByAuthorId(userId);
        if (blogMetas.size() > 0) {
            result.setResultCode(0);
            result.setMessage("Query blogs by author id successfully");
            result.setData(blogMetas);
        } else {
            result.setResultCode(-1);
            result.setMessage("Query blogs by author id failed");
        }
        return result;
    }

    @PostMapping("/blogMeta/createBlog")
    @ResponseBody
    public Result createBlog(@RequestBody BlogMeta blogMeta) {
        Result result = new Result();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        blogMeta.setBlogCreateDate(df.format(new Date()));
        blogMeta.setBlogLastModifyDate(df.format(new Date()));
        if (blogMetaService.createBlog(blogMeta) > 0) {
            blogDetailService.createBlogDetailItem(blogMeta.getBlogId());
            result.setResultCode(0);
            result.setMessage("Create successfully");
        } else {
            result.setResultCode(-1);
            result.setMessage("Create blog failed");
        }
        return result;
    }

    @PostMapping("/blogMeta/updateBlog")
    @ResponseBody
    public Result updateBlogMeta(@RequestBody BlogMeta blogMeta) {
        Result result = new Result();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        blogMeta.setBlogLastModifyDate(df.format(new Date()));
        Integer blogId = blogMeta.getBlogId();
        BlogMeta blogMetaObj = blogMetaService.queryBlogMetaById(blogId);
        if (blogMeta.getBlogAuthorId() == null) {
            blogMeta.setBlogAuthorId(blogMetaObj.getBlogAuthorId());
        }
        blogMeta.setBlogCreateDate(blogMetaObj.getBlogCreateDate());
        if (blogMetaService.updateBlogMeta(blogMeta) > 0) {
            result.setResultCode(0);
            result.setMessage("Update blog successfully");
        } else {
            result.setResultCode(-1);
            result.setMessage("Update blog failed");
        }
        return result;
    }

    @DeleteMapping("/blogMeta/{id}")
    @ResponseBody
    public Result deleteBlogMeta(@PathVariable("id") Integer id) {
        Result result = new Result();
        if (blogMetaService.deleteBlog(id) > 0) {
            result.setResultCode(0);
            result.setMessage("Delete blog successfully");
        } else {
            result.setResultCode(-1);
            result.setMessage("Delete blog failed");
        }
        return result;
    }

    @DeleteMapping("/blogMeta/all")
    @ResponseBody
    public Result<Boolean> deleteAllBlogDetail() {
        blogDetailService.deleteAllBlogDetail();
        blogMetaService.deleteAllBlogMeta();
        Result<Boolean> result = new Result<>();
        result.setMessage("Delete all blog detail items successfully");
        return result;
    }
}
