package com.shao.blogback.service;

import com.shao.blogback.model.ResponseBase;
import com.shao.blogback.model.User;

public interface UserService {
    ResponseBase login(String username, String password);

    ResponseBase addUser(String username, String password);

    ResponseBase updateUserInfo(User user);
}
