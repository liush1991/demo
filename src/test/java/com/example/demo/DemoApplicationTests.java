package com.example.demo;

import com.example.demo.dao.GoodsDao;
import com.example.demo.entity.Goods;
import com.example.demo.service.Impl.BaseService;
import com.example.demo.service.Impl.GoodsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsServiceImpl goodsService;

    @Test
    void contextLoads() {
        Goods goods = new Goods();
        goods.setName("手机");
        goods.setPic("phone.jpg");
        goods.setPrice("2000");
        int count = goodsDao.insert(goods);
    }

    /**
     * 更新商品信息
     */
    @Test
    @Transactional
    void test_02() {
        Goods goods = new Goods();
        goods.setId(goodsService.getSequences("id"));
        goods.setName("手机1");
        goods.setPic("phone1.jpg");
        goods.setPrice("3000");
     //   int count = goodsDao.update(goods);
        goodsService.getDao().insert("com.example.demo.dao.GoodsDao.insert",goods);
    }

    /**
     * 获取商品信息
     */
    @Test
    void test_03() {
        Goods goods = goodsDao.selectOne(3L);

        System.out.println(goods);

    }

    /**
     * 删除商品
     */
    @Test
    void test_04() {
        int count = goodsDao.delete(3L
        );//此处应为delete(1L)
    }

    /**
     * 获取商品信息列表
     */
    @Test
    void test_05() {
        List<Goods> goodsList = goodsDao.selectAll();
        System.out.println(goodsList.toString());

    }

    /**
     * 测试通过sqlSession查询数据
     */
    @Test
    public void test(){
        goodsService.testSelect();
    }

    /**
     * 通过xml加载bean
     */
    @Test
    public void test1(){

        ApplicationContext applicationContext1= new FileSystemXmlApplicationContext("classpath:bean.xml");
        String[] beans=applicationContext1.getBeanDefinitionNames();
        for(String bean:beans){
            System.out.println(bean);
        }
        BaseService service= (BaseService) applicationContext1.getBean("baseService");
        System.out.println(service.getClass());
    }

    /**
     * 测试获取序列
     */
    @Test
    public void getSequences(){
        String str= goodsService.getSequences("id");
        System.out.println(str);
    }
    @Test
    public void getSequences2(){
        String str= goodsService.getSequences2("id");
        System.out.println(str);
    }


    @Test
    public void testMap(){


    }

}
