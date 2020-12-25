package com.example.demo.service;

import com.example.demo.dao.GoodsDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.entry.Goods;
import com.example.demo.entry.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class OrderServiceImpl {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private OrderDao orderDao;

    /**
     * 下单
     *
     * @param goodsId 购买商品id
     * @param count   购买商品数量
     * @return 生成订单数
     */
    @Transactional // 实现事务
    public int createOrder(Long goodsId, Long count) {
        // 锁定商品库存
        Goods goods = goodsDao.selectForUpdate(goodsId);
        // 扣减库存
        Long newNum = goods.getNum() - count;
        goods.setNum(newNum);
        goodsDao.update(goods);
        // 生成订单
        Order order = new Order();
        order.setGoodsId(goodsId);
        order.setCount(count);
        int affectRows = orderDao.insert(order);
        return affectRows;
    }
}
