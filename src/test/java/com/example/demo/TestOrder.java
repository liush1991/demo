package com.example.demo;

import com.example.demo.service.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        System.out.println("affectRows "+affectRows);
    }
}
