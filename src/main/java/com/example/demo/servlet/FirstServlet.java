package com.example.demo.servlet;

import org.springframework.http.HttpRequest;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 整合servlet方式一  需要在DemoAppliction上加@ServletComponentScan
 */
@WebServlet(name="FirstServlet" ,urlPatterns = "/first")
public class FirstServlet  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("FirstServlet.........");
    }


}
