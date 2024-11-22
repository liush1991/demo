package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取applicationContext的两种方式
 * 1.实现 ApplicationContextAware
 * 2.直接注入  @Autowired
 */
@SpringBootTest
public class TestApplicationContext implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    /**
     * 获取springboot
     */
    @Test
    public void getBean(){
        String[] beans=applicationContext.getBeanDefinitionNames();
        int n= applicationContext.getBeanDefinitionCount();
        System.out.println(n);
        for(String bean:beans){
            System.out.println(bean);
        }
    }
}
