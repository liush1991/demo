package com.example.demo.service;

import com.example.demo.entry.Goods;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl {
    public List<Goods> getGoodsList(){
        List<Goods> goodsList= new ArrayList<Goods>();
        Goods goods= new Goods();
        goods.setId(1);
        goods.setName("pingguo");
        goods.setPrice("44");
        goods.setPic("ff.jpg");
        goodsList.add(goods);
        Goods goods1= new Goods();
        goods1.setId(2);
        goods1.setName("pingguo111");
        goods1.setPrice("4433");
        goods1.setPic("f22f.jpg");
        goodsList.add(goods1);
        return goodsList;
    }
    public Goods getGoodsById(Long id){
        Goods goods= new Goods();
        goods.setId(id);
        goods.setName("pingguo333");
        goods.setPrice("44222222");
        goods.setPic("ff33333333.jpg");
        return goods;
    }


}
