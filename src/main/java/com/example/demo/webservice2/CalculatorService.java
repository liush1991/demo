package com.example.demo.webservice2;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(targetNamespace = "http://webservice2.dome.example.com")
public interface CalculatorService {

    @WebMethod
    int add(int num1, int num2);

    @WebMethod
    int subtract(int num1, int num2);
}