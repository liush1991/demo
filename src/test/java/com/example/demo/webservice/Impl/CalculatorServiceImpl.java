package com.example.demo.webservice.Impl;

import com.example.demo.webservice2.CalculatorService;
import org.apache.cxf.feature.Features;

import javax.jws.WebService;

@WebService(endpointInterface = "com.example.demo.webservice.CalculatorService")
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