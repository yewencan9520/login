package com.qianfeng.login.service.Impl;

import com.qianfeng.login.dao.UserDao;
import com.qianfeng.login.exception.PasswordException;
import com.qianfeng.login.exception.UnknowUsernameException;
import com.qianfeng.login.model.User;
import com.qianfeng.login.service.UserDaoService;
import com.qianfeng.login.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserDaoServiceImpl implements UserDaoService {

    @Autowired
    private UserDao userDao;

    public User Login(String username, String password) throws Exception {
        //判断用户名是否为空或null
        if(username.equals("")||username==null){
            throw new UnknowUsernameException();
        }
        User user = userDao.selectUserByUsername(username);
        if(user==null){
            throw new UnknowUsernameException();
        }
        String str = MD5Utils.md5(password, user.getSalt());
        if(!user.getPassword().equals(str)){
            throw new PasswordException();
        }
        return user;
    }
}
