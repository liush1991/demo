package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/indexController")
public class IndexController {

    @RequestMapping("/index.do")
    public String GetPage(){

        return "index";
    }
    @RequestMapping("/GetUserInfo.do")
    @ResponseBody
    public User GetUserInfo(){
        User user=new User();
        user.setUsername("刘少华1");
        user.setAccount("liush");
        return user;
    }
    @RequestMapping("/Login.do")
    @ResponseBody
    public Map Login(User user){
        System.out.println("22222222");
        System.out.println(user);
        Map result=new HashMap();
        result.put("name","liush");

      return result;
    }
}
