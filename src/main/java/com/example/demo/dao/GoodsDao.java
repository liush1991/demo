package com.example.demo.dao;

import com.example.demo.entry.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {
    /**
     * 新增商品
     */
    public int insert(Goods Goods);

    /**
     * 删除商品(根据id)
     */
    public int delete(Long id);

    /**
     * 修改商品信息(根据id修改其他属性值)
     */
    public int update(Goods Goods);

    /**
     * 查询商品信息(根据id查询单个商品信息)
     */
    public Goods selectOne(Long id);

    /**
     * 查询商品列表
     */
    public List<Goods> selectAll();
    /**
     * 查询商品信息(根据id查询单个商品信息)
     */
    public Goods selectForUpdate(Long id);

}
