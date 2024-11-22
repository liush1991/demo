package com.example.demo.service.Impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class BaseService {
    @Autowired
    protected SqlSessionFactory factory;
    @Autowired
    protected SqlSession dao;

    public SqlSession getDao() {
        return dao;
    }

    public void setDao(SqlSession dao) {
        this.dao = dao;
    }

    public SqlSessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SqlSessionFactory factory) {
        this.factory = factory;
    }


    /**
     * 获取seq
     * 通过存储过程获取
     */
    public String getSequences(String seqName){
        Map map= new HashMap();
        map.put("SEQNAME",seqName);
      //  map.put("SEQUENCE","");
        dao.selectList("base.getSequences",map);
        return (String) map.get("SEQUENCE");
    }

    /**
     * 获取seq
     * 通过xml直接执行sql获取
     * @param seqName
     * @return
     */
    public String getSequences2(String seqName){
        seqName="seq_"+seqName+".Nextval";
        Map map= new HashMap();
        map.put("SEQNAME",seqName);
        Map map1= dao.selectOne("base.getSeq",map);
        return  map1.get("SEQUENCE").toString();
    }
}
