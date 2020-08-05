package com.shao.blogback.controller;

import com.shao.blogback.model.ResponseBase;
import com.shao.blogback.model.User;
import com.shao.blogback.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "用户管理相关接口")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户登录接口")
    @PostMapping("user/login")
    public ResponseBase login(@RequestParam("username") String username, @RequestParam("password") String password,
                              @RequestParam("validateCode") String validateCode, HttpServletRequest request) {
        //将session中的字符串与用户输入的字符串进行比较
        String res = (String) request.getSession().getAttribute("ValidateCode");
        if (!validateCode.equalsIgnoreCase(res)) {
            return new ResponseBase(ResponseBase.ERROR, "验证码错误", null);
        }
        return userService.login(username, password);
    }

    @ApiOperation("用户登录接口")
    @PostMapping("user/addUser")
    public ResponseBase addUser(String username, String password) {
        return userService.addUser(username, password);
    }

    @ApiOperation("更新用户信息接口")
    @PostMapping("user/updateUserInfo")
    public ResponseBase updateUserInfo(User user) {
        return userService.updateUserInfo(user);
    }
}
