package com.bike.cloud.controller;

import com.bike.cloud.entities.User;
import com.bike.cloud.resp.ResultData;
import com.bike.cloud.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "用户管理微服务模块",description = "这是用户管理接口")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/add")
    @Operation(summary = "新增",description = "创建新用户")
    public ResultData<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResultData.success("新用户创建成功");
    }

    @GetMapping(value = "/user/getById/{id}")
    @Operation(summary = "按照id查用户",description = "查询用户的方法")
    public ResultData<User> getUserById(@PathVariable("id")Integer id){
        User user = userService.getUserById(id);
        return ResultData.success(user);
    }

    @GetMapping(value = "/user/getByName/{name}")
    @Operation(summary = "按照id查用户",description = "查询用户的方法")
    public ResultData<User> getUserByName(@PathVariable("name")String username){
        User user = userService.getUserByName(username);
        return ResultData.success(user);
    }

    @PostMapping(value = "/user/updateAvatar/{id}")
    @Operation(summary = "更新用户头像",description = "更新用户信息的方法")
    public ResultData<String> updateAvatar(@PathVariable("id")Integer id, String url){
        userService.updateAvatar(id,url);
        return ResultData.success("更新头像成功");
    }

    @PostMapping(value = "/user/updatePwd/{id}")
    @Operation(summary = "更新密码",description = "更新用户信息方法")
    public ResultData<String> updatePwd(@PathVariable("id") Integer id, String password){
        userService.updatePwd(id,password);
        return ResultData.success("修改密码成功");
    }
}
