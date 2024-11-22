package com.example.demo.webservice2.Impl;

import com.example.demo.webservice2.CalculatorService;
import org.apache.cxf.feature.Features;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@WebService(serviceName = "CalculatorService",
        targetNamespace = "http://webservice2.demo.example.com",
        endpointInterface = "com.example.demo.webservice2.CalculatorService")
@Service
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }
}