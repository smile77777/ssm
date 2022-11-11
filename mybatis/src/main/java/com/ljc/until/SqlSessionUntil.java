package com.ljc.until;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUntil {
    private SqlSessionUntil(){};
    private static SqlSessionFactory sqlsessionFactory=null;
    static {
        try {
            sqlsessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession openSession(){
        return sqlsessionFactory.openSession();
    }
}
