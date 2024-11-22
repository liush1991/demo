package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
@Service
public class TestTransactionService extends BaseService {
    @Transactional
    public void insertAa()  {
        Map map1 = new HashMap();
        map1.put("aaa001", "1");
        map1.put("aaa002", "2");
        getDao().insert("test.insertAa01", map1);

     //   int i=1/0;
        getDao().insert("test.insertAa02", map1);
    }
}
