package com.example.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 上下文监听器
 * 整合方式一 需要在DemoAppliction上加@ServletComponentScan
 *
 */
@WebListener
public class FirstContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("FirstContextListener....Destroyed....上下文监听器销毁....");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("FirstContextListener....init....上下文监听器初始化....");
    }

}
