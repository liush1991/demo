package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 启动自动执行
 * 启动自动打开浏览器
 */
@Component
public class MyCommandRunner implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(MyCommandRunner.class);
 //   private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${spring.web.loginUrl}")
    private String loginUrl;
    @Value("${spring.web.browserUrl}")
    private String browserUrl;
    @Value("${spring.web.isOpen}")
    private boolean isOpen;
    @Override
    public void run(String... args) throws Exception {
        if(isOpen){
            String cmd = browserUrl+" "+loginUrl;
            Runtime runtime= Runtime.getRuntime();

            try {
                runtime.exec(cmd);
                logger.debug("打开浏览器成功");
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }

        }
    }
}
