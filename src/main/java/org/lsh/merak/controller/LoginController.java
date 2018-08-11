package org.lsh.merak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: java类的类型
 * @Author: lsh
 * @CreateDate: 2018/8/11 15:19
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
