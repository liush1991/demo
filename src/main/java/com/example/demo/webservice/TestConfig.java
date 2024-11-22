package com.example.demo.webservice;


import com.example.demo.webservice.Impl.UserServiceImpl;
import com.example.demo.webservice.Impl.WebServiceImplTest;
import com.example.demo.webservice2.CalculatorService;
import com.example.demo.webservice2.Impl.CalculatorServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;



@Configuration
public class TestConfig {
//    @Autowired
//    private WebServiceTest webServiceTest ;
    @Bean
    public ServletRegistrationBean dispatcherServlet1() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public WebServiceTest testService() {
        return new WebServiceImplTest();
    }
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }

    @Bean
    public CalculatorService calculatorService(){
        return new CalculatorServiceImpl();
    }
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(),testService());
        endpoint.publish("/webServiceTest");
        return endpoint;
    }
    @Bean
    public Endpoint endpoint2(){
        EndpointImpl endpoint= new EndpointImpl(springBus(),userService());
        endpoint.publish("/userService");
        return endpoint;
    }


    @Bean
    public Endpoint calculatorEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), calculatorService());
        endpoint.publish("/CalculatorService");
        return endpoint;
    }
}
