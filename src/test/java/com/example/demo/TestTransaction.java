package com.example.demo;

import com.example.demo.service.Impl.OrderServiceImpl;
import com.example.demo.service.Impl.TestTransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestTransaction {
    @Autowired
    protected TestTransactionService testTransactionService;
    @Autowired
    OrderServiceImpl orderService;
    @Test
    public void insertAa() throws Exception {
        testTransactionService.insertAa();
    }
    @org.junit.Test
    public void test(){
       int affectRows= orderService.createOrder(4L,1L);
       System.out.println(affectRows);
    }
}
