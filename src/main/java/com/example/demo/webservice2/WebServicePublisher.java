package com.example.demo.webservice2;

import com.example.demo.webservice2.Impl.CalculatorServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WebServicePublisher {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringBus.class);
        context.refresh();

        Bus bus = context.getBean(SpringBus.class);

        CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, calculatorServiceImpl);
        endpoint.publish("/CalculatorService");

        System.out.println("Web Service已发布，地址: http://localhost:8080/CalculatorService");
    }
}