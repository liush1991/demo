package com.example.demo.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 整合Filter方式二
 * 需要配置类FilterConfig
 *
 */
public class SecondFilter implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SecondFilter  进入");
        String param = servletRequest.getParameter("param");
        PrintWriter pw= servletResponse.getWriter();
        if(param!=""&&param!=null&&param.indexOf("f")!=-1){
            System.out.println("参数中包含'f'");
            pw.println("参数中包含'f'");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }

        System.out.println("SecondFilter  离开");
    }

    @Override
    public void destroy() {

    }
}
