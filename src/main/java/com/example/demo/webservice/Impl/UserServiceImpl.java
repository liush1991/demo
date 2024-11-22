package com.example.demo.webservice.Impl;

import com.example.demo.entity.User;
import com.example.demo.webservice.UserService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(serviceName="UserService",//对外发布的服务名
        targetNamespace="http://service.demosxt.sxt.com",//指定你想要的名称空间，通常使用使用包名反转
        endpointInterface="com.example.demo.webservice.UserService")//服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
@Component
public class UserServiceImpl implements UserService {

    private Map<String, User> userMap = new HashMap<String, User>();
    public UserServiceImpl() {
        System.out.println("向实体类插入数据");
        User user = new User();
        user.setUserId("1");
        user.setUsername("mracale01");
        user.setEmail("mracale01@163.xom");
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("2");
        user.setUsername("mracale02");
        user.setEmail("mracale02@163.xom");
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("3");
        user.setUsername("mracale03");
        user.setEmail("mracale03@163.xom");
        userMap.put(user.getUserId(), user);
    }
    @Override
    public String getUserName(String userId) {
        return "userId为：" + userId;
    }
    @Override
    public User getUser(String userId) {
        System.out.println("userMap是:"+userMap.get(userId));
        System.out.println(userMap.get(userId).getClass());
        return userMap.get(userId);
    }

}
