package com.qianfeng.login.dao;


import com.qianfeng.login.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    User selectUserByUsername(String username);

}
