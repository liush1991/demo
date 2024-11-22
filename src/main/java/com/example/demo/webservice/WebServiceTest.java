package com.example.demo.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
//@WebService(name="WebServiceTest")
@WebService(targetNamespace = "http://webservice.dome.example.com")
//@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface WebServiceTest {
    @WebMethod
    public String testMethed(@WebParam(name="str")String str);
    @WebMethod
    public String testMethed2(@WebParam(name="Input")String Input,@WebParam(name="id") String id);

}
