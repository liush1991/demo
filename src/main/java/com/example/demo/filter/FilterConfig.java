package com.example.demo.filter;

import com.example.demo.filter.SecondFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 整合Filter方式二,配置文件
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean bean= new FilterRegistrationBean(new SecondFilter());
        bean.addUrlPatterns("/second");
        return bean;

    }
}
