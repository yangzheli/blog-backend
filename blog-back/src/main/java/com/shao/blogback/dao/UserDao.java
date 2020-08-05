package com.shao.blogback.dao;

import com.shao.blogback.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM user WHERE username = #{username} ")
    User getByUserName(String username);

    @Select("INSERT INTO user (username,password) VALUES (#{username},#{password})")
    void addUser(String username,String password);

    @Select("UPDATE user SET username = #{username}, avatar = #{avatar}, sex = #{sex}, email = #{email} where userId = #{userId}")
    void updateUserInfo(User user);
}
