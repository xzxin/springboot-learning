package com.xzx.springbootdemo.controller;

import com.xzx.springbootdemo.common.Result;
import com.xzx.springbootdemo.entity.BlogUser;
import com.xzx.springbootdemo.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogUserController {
    @Autowired
    BlogUserService blogUserService;

    @GetMapping("/blogUser/queryAll")
    @ResponseBody
    public Result<List<BlogUser>> querryAllUsers() {
        Result<List<BlogUser>> result = new Result<>();
        result.setResultCode(0);
        result.setMessage("Query suceessfully");
        result.setData(blogUserService.queryAllUser());
        return result;
    }

    @GetMapping("/blogUser/getUser")
    @ResponseBody
    public Result<BlogUser> getUserById(@RequestParam("userId") Integer id) {
        Result<BlogUser> result = new Result<>();
        result.setResultCode(0);
        result.setMessage("Query suceessfully");
        result.setData(blogUserService.queryUserById(id));
        return result;
    }

    @PostMapping("/blogUser/addUser")
    @ResponseBody
    public Result<BlogUser> addUser(@RequestBody BlogUser user) {
        Result<BlogUser> result = new Result<>();
        if (blogUserService.addUser(user) > 0) {
            result.setResultCode(0);
            result.setMessage("Add user suceessfully. User id is " + user.getUserId());
            result.setData(user);
        } else {
            result.setResultCode(-1);
            result.setMessage("Add user failed");
        }
        return result;
    }

    @PostMapping("/blogUser/updateUser")
    @ResponseBody
    public Result updateUser(@RequestBody BlogUser user) {
        Result result = new Result<>();
        if (blogUserService.updateUser(user) > 0) {
            result.setResultCode(0);
            result.setMessage("Update user suceessfully");
        } else {
            result.setResultCode(-1);
            result.setMessage("Update user failed");
        }
        return result;
    }

    @DeleteMapping("/blogUser/{id}")
    @ResponseBody
    public Result deleteUser(@PathVariable("id") Integer id) {
        Result result = new Result<>();
        if (blogUserService.deleteUserById(id) > 0) {
            result.setResultCode(0);
            result.setMessage("Delete user suceessfully");
        } else {
            result.setResultCode(-1);
            result.setMessage("Delete user failed");
        }
        return result;
    }

    @DeleteMapping("/blogUser/all")
    @ResponseBody
    public Result<Boolean> deleteAllBlogDetail() {
        blogUserService.deleteAllBlogUser();
        Result<Boolean> result = new Result<>();
        result.setMessage("Delete all blog users successfully");
        return result;
    }
}
