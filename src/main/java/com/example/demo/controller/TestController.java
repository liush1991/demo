package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testController")
public class TestController {
    @RequestMapping("/login.do")
    public String login(Model model){
        model.addAttribute("login","欢迎登陆!!!");

        return "login";
    }

}
