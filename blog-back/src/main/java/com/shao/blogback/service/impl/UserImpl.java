package com.shao.blogback.service.impl;

import com.shao.blogback.common.JwtUtils;
import com.shao.blogback.dao.UserDao;
import com.shao.blogback.model.ResponseBase;
import com.shao.blogback.model.User;
import com.shao.blogback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public ResponseBase login(String username, String password) {
        if (userDao.getByUserName(username) == null) {
            return new ResponseBase(0, "该用户不存在", null);
        }
        User user = userDao.getByUserName(username);
        //其它数据以map形式放在token中
        Map<String, Object> map = new HashMap<>();
        String token = new JwtUtils().generateToken(user, map);
        if (password.equals(user.getPassword())) {
            return new ResponseBase(ResponseBase.SUCCESS, "登录成功", user, token);
        }
        return new ResponseBase(ResponseBase.ERROR, "密码错误，登录失败", null);
    }

    @Override
    public ResponseBase addUser(String username, String password) {
        if (userDao.getByUserName(username) != null) {
            return new ResponseBase(0, "该用户名已存在", null);
        }
        userDao.addUser(username, password);
        User user = userDao.getByUserName(username);
        //其它数据以map形式放在token中
        Map<String, Object> map = new HashMap<>();
        String token = new JwtUtils().generateToken(user, map);
        return new ResponseBase(ResponseBase.SUCCESS, "注册成功", user, token);
    }

    @Override
    public ResponseBase updateUserInfo(User user) {
        if (exists(user)) {
            return new ResponseBase(ResponseBase.ERROR, "用户名已经存在，更新失败", null);
        }
        userDao.updateUserInfo(user);
        return new ResponseBase(ResponseBase.SUCCESS, "更新个人信息成功", null);
    }

    /**
     * 判断用户名是否已经被其它用户使用
     */
    private Boolean exists(User user) {
        User res = userDao.getByUserName(user.getUsername());
        return res.getUsername().equals(user.getUsername()) && res.getUserId() != user.getUserId();
    }
}
