package com.example.demo.webservice.Impl;

import com.example.demo.webservice.WebServiceTest;
import org.apache.cxf.feature.Features;
import org.springframework.stereotype.Component;
import javax.jws.WebService;

@WebService(serviceName = "WebServiceTest",
        targetNamespace = "http://webservice.demo.example.com",
        endpointInterface = "com.example.demo.webservice.WebServiceTest")
@Component
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class WebServiceImplTest implements WebServiceTest {
    @Override
    public String testMethed(String str) {
        System.out.println(str);
        return "str..........";
    }

    @Override
    public String testMethed2(String Input, String id) {
        System.out.println("2...............");
        return Input+"11111";
    }

}
