package com.qianfeng.login.controller;

import com.qianfeng.login.model.User;
import com.qianfeng.login.service.UserDaoService;
import com.qianfeng.login.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @RequestMapping("login")
    @ResponseBody
    public JsonResult login(String username, String password, HttpSession session){
        JsonResult jsonResult = new JsonResult();
        try {
            User user = userDaoService.Login(username, password);
            session.setAttribute("user",user);
            jsonResult.setJsonCode(0);
            jsonResult.setObj("pages/index");
        } catch (Exception e) {
            jsonResult.setJsonCode(1);
            jsonResult.setObj("账号或密码错误");
        }
        return jsonResult;
    }


}
