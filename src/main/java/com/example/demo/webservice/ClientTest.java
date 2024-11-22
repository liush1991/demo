package com.example.demo.webservice;

import com.example.demo.entity.User;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class ClientTest {

    public static void main(String[] args) {
     //   test1();
   //   test2();
        test3();


    }

        public static void test1(){
            try {
                // 接口地址
                String address = "http://127.0.0.1:8081/demo/services/webServiceTest?wsdl";
                // 代理工厂
                JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
                // 设置代理地址
                jaxWsProxyFactoryBean.setAddress(address);
                // 设置接口类型
                jaxWsProxyFactoryBean.setServiceClass(WebServiceTest.class);
                // 创建一个代理接口实现
                WebServiceTest us = (WebServiceTest) jaxWsProxyFactoryBean.create();
                // 数据准备
                String userId = "maple";
                // 调用代理接口的方法调用并返回结果
                String result = us.testMethed2("xingrenjie","222");
                System.out.println("返回结果:" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    public static void test2() {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://127.0.0.1:8081/demo/services/userService?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // QName qName= new QName("http://webservice.demo.example.com","testmethed");
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("getUser", "2");
            System.out.println("返回数据:" + objects[0].getClass());
            System.out.println(objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void test3(){
        try {
            // 接口地址
            String address = "http://127.0.0.1:8081/demo/services/userService?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(UserService.class);
            // 创建一个代理接口实现
            UserService us = (UserService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String userId = "maple";
            // 调用代理接口的方法调用并返回结果
            User user = us.getUser("2");
            System.out.println("返回结果:" + user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
