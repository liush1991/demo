package com.example.demo;

import com.example.demo.service.Impl.GoodsServiceImpl;
import com.example.demo.service.Impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootTest
public class TestOrder {
    @Autowired
    private OrderServiceImpl orderService;

    /**
     * 新增一个商品
     */
    @Test
    void testCreateOrder() {
        // 购买id为1的商品1份
        int affectRows = orderService.createOrder(4L, 1L);
        System.out.println("affectRows " + affectRows);
    }

    /**
     * 打开浏览器测试
     */
    @Test
    void testcc() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("C:\\Users\\ASUS\\AppData\\Local\\SogouExplorer\\SogouExplorer.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    ApplicationContext applicationContext;
    @Test
    public void getBean(){
        String[] beans=applicationContext.getBeanDefinitionNames();
        int n= applicationContext.getBeanDefinitionCount();
        System.out.println(n);
        for(String bean:beans){
            System.out.println(bean);
        }
    }
@org.junit.Test
        public void test(){
            GoodsServiceImpl goodsService=new GoodsServiceImpl();
            goodsService.getGoodsList();
        }

}
