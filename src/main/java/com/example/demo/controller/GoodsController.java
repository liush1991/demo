package com.example.demo.controller;

import com.example.demo.entry.Goods;
import com.example.demo.service.GoodsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@Api(tags = "商品API") // 类文档显示内容
@RestController
public class GoodsController {
    @Resource
    private GoodsServiceImpl goodsService;
    @ApiOperation(value = "根据id获取商品信息") // 接口文档显示内容
    @RequestMapping("/getOne.do")
    public Goods getOne(Long id){

        return goodsService.getGoodsById(id);
    }
    @ApiOperation(value = "获取商品列表") // 接口文档显示内容
    @RequestMapping("/getGoodsList.do")
    public List<Goods> getGoodsList(){

        return goodsService.getGoodsList();
    }
}
