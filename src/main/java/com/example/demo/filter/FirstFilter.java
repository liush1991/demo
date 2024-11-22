package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.xml.ws.WebFault;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 整合Filter方式一
 * 需要在DemoAppliction上加@ServletComponentScan
 */
@WebFilter(filterName = "FirstFiiter",urlPatterns = "/first")
//@WebFilter(filterName = "FirstFiiter",urlPatterns = {"*.do","*.jsp"})
public class FirstFilter implements javax.servlet.Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFiiter  进入");
        String param = servletRequest.getParameter("param");
        PrintWriter pw= servletResponse.getWriter();
        if(param!=""&&param!=null&&param.indexOf("f")!=-1){
            System.out.println("参数中包含'f'");
            pw.println("参数中包含'f'");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
        System.out.println("FirstFiiter  离开");
    }

    @Override
    public void destroy() {

    }
}
