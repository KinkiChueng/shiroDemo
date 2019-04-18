package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lasia on 2019/4/12.
 */
@Controller
public class LoginController {


    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping("/")
    public String loginWeb() {
        return "login";
    }

    @RequestMapping("/login")
    public String login() {
        return "index";
    }
}
