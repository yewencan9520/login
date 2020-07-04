package com.qianfeng.login.service;

import com.qianfeng.login.model.User;

public interface UserDaoService {

    User Login(String username, String password) throws Exception;
}
