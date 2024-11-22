package com.example.test;

import com.example.demo.service.Impl.GoodsServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class test2 {
    @Resource
    private GoodsServiceImpl goodsService;

    public static void main(String[] args) {
//       new GoodsServiceImpl().testSelect();
       new test2().test2();
        new test2().testSql();
    }

    public void testSql(){
        goodsService.getGoodsById(Long.valueOf("1"));
    }

    public void test1(){

        System.out.println("222");
        TestAbstract testAbstract=  new TestAbstract(){
            @Override
            public void test1(String s) {
                System.out.println("1111111111");
            }

        };
        System.out.println( 1000 /60);
        System.out.println(String.valueOf(10 * 100 /60));

    }


    public void test2(){
       System.out.println("1".compareTo("2"));
       System.out.println("sfs");
    }
}
