package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.annotation.PostConstruct;
@SpringBootApplication
@MapperScan("com.example.demo.dao")
@ServletComponentScan
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);



	}
	@PostConstruct
	public void test(){
		System.out.println("qidong");

//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(SpringBus.class);
//		context.refresh();
//
//		Bus bus = context.getBean(SpringBus.class);
//
//		CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl();
//		EndpointImpl endpoint = new EndpointImpl(bus, calculatorServiceImpl);
//		endpoint.publish("/CalculatorService");
//
//		System.out.println("Web Service已发布，地址: http://localhost:8081/CalculatorService");
	}


}
