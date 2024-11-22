package com.example.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过配置文件
 */
@SpringBootTest
public class TestSqlSession {

    private static SqlSessionFactory sessionFactory1;
    static {
        InputStream inputStream=TestSqlSession.class.getClassLoader().getResourceAsStream("mapper/base.xml");
        System.out.println(inputStream);
        sessionFactory1=new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sessionFactory1);
    }
    public static SqlSession getSqlSession(){
        return sessionFactory1.openSession();
    }
    @Test
    public void testSqlSession(){
        SqlSession sqlSession= TestSqlSession.getSqlSession();
        Map map= sqlSession.selectOne("base.getSeq",new HashMap().put("SEQNAME","seq_id.Nextval"));
        System.out.println(map);
    }




}
