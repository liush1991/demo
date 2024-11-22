package com.example.demo.webservice2;


import com.example.demo.webservice2.Impl.CalculatorServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CXFConfig {

//    @Bean
//    public Bus cxfBus() {
//        return new SpringBus();
//    }

    @Bean
    public Endpoint calculatorEndpoint(CalculatorServiceImpl calculatorServiceImpl, Bus bus) {
        EndpointImpl endpoint = new EndpointImpl(bus, calculatorServiceImpl);
        endpoint.publish("/CalculatorService");
        return endpoint;
    }
}