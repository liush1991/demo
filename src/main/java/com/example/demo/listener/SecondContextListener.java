package com.example.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 整合Listener 方式二 需要ListenerConfig
 */
public class SecondContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SecondContextListener....init....上下文监听器初始化....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("SecondContextListener....Destroyed....上下文监听器销毁....");
    }
}
