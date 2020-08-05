package com.shao.blogback.model;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String username;
    private String password;
    private String avatar;//用户头像URL
    private String sex;
    private String email;
}
