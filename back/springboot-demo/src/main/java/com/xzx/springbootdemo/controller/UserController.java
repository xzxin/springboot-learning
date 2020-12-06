package com.xzx.springbootdemo.controller;

import com.xzx.springbootdemo.common.Result;
import com.xzx.springbootdemo.dao.UserMapper;
import com.xzx.springbootdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Resource
    UserMapper userMapper;

  @GetMapping("/user/queryAll")
  @ResponseBody
  public Result<List<User>> queryAll() {
      return new Result(0, "success", userMapper.findAllUsers());
  }

  @PostMapping("/user/insert")
  @ResponseBody
  public Result insert(@RequestBody User user) {
    if (userMapper.insertUser(user) > 0) {
      return new Result(0, "success");
    } else {
      return new Result(-1, "fail");
    }
  }

  @PutMapping("/user/update")
  @ResponseBody
  public Result update(@RequestBody User user) {
    if (userMapper.updateUser(user) > 0) {
      return new Result(0, "success");
    } else {
      return new Result(-1, "fail");
    }
  }

  @DeleteMapping("/user/delete/{id}")
  @ResponseBody
  public Result delete(@PathVariable("id") Integer id) {
    if (userMapper.deleteUser(id) > 0) {
      return new Result(0, "success");
    } else {
      return new Result(-1, "fail");
    }
  }
}
