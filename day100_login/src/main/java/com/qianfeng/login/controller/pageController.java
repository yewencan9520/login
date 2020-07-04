package com.qianfeng.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pages")
public class pageController {

    @RequestMapping("index")
    public String tologin(){
        return "index";
    }
}
