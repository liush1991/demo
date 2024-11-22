package com.example.demo.webservice2;


import com.example.demo.webservice2.Impl.CalculatorServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.Endpoint;

//@Configuration
public class CXFConfig {

//    @Bean
//    public Bus cxfBus() {
//        return new SpringBus();
//    }

//    @Bean
//    public Endpoint calculatorEndpoint(CalculatorServiceImpl calculatorServiceImpl, Bus bus) {
//        EndpointImpl endpoint = new EndpointImpl(bus, calculatorServiceImpl);
//        endpoint.publish("/CalculatorService");
//        return endpoint;
//    }

//    @Bean
//    public Endpoint calculatorEndpoint() {
//        EndpointImpl endpoint = new EndpointImpl(new SpringBus(), new CalculatorServiceImpl());
//        endpoint.publish("/CalculatorService");
//        return endpoint;
//    }
@Bean
public CalculatorService calculatorService1(){
    return new CalculatorServiceImpl();
}
@Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus1() {
        return new SpringBus();
    }

    @Bean
    public Endpoint calculatorEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus1(), calculatorService1());
        endpoint.publish("/CalculatorService");
        return endpoint;
    }
}