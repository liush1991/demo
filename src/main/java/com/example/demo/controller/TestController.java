package com.example.demo.controller;

import com.example.demo.entity.Goods;
import com.example.demo.service.Impl.GoodsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/testController")
public class TestController {
    @Resource
    private GoodsServiceImpl goodsService;
    @RequestMapping("/login.do")
    public String login(Model model) {
        model.addAttribute("login", "欢迎登陆!!!");
        System.out.println("testController/login.do");
        return "login";
    }

    @RequestMapping("/Ajax.do")
    @ResponseBody
    public Map TestAjax(String param) {
        System.out.println("Ajax.do");
        System.out.println(param);
        Map map = new HashMap();
        map.put("sss", "fff");
        return map;
    }
    @RequestMapping("/getOne.do")
    public Goods getOne(Long id) {

        return goodsService.getGoodsById(id);
    }
}
