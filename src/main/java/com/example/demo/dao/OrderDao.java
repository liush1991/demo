package com.example.demo.dao;

import com.example.demo.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    /**
     * 新增订单
     */
    public int insert(Order order);
}
