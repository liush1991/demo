package com.example.demo.service.Impl;

import com.example.demo.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl extends BaseService {
    public List<Goods> getGoodsList(){
        List<Goods> goodsList= new ArrayList<Goods>();
        Goods goods= new Goods();
        goods.setId("1");
        goods.setName("pingguo");
        goods.setPrice("44");
        goods.setPic("ff.jpg");
        goodsList.add(goods);
        Goods goods1= new Goods();
        goods1.setId("2");
        goods1.setName("pingguo111");
        goods1.setPrice("4433");
        goods1.setPic("f22f.jpg");
        goodsList.add(goods1);
     //   List list= dao.selectList("test.getAll");

     //   System.out.println(list);
        System.out.println("21212");
        return goodsList;
    }
    public Goods getGoodsById(Long id){
        Goods goods= new Goods();
      //  goods.setId(getSequences("id"));
        goods.setId(String.valueOf(id));
        goods.setName("pingguo333");
        goods.setPrice("44222222");
        goods.setPic("ff33333333.jpg");

        return goods;

    }

    /**
     * 通过sqlSession查询数据
     */
    public void testSelect(){
        Map map= new HashMap();
        map.put("name","2");
        List list= dao.selectList("test.ddd",map);
        System.out.println(list);
        System.out.println("33");
    }


    public void getSequence(){
        String str= getSequences("id");
        System.out.println(str);
    }
    public void getSequence2(){
        String str=getSequences2("id");

        System.out.println(str);
    }
}
