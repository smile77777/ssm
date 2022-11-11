package com.ljc.bank.untils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * mybatis工具类
 */
public class SqlSessionUntil {
    private SqlSessionUntil(){};
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ThreadLocal<SqlSession> local=new ThreadLocal<>();

    public static SqlSession openSession(){
        SqlSession sqlSession = local.get();
        if(sqlSession==null){
            sqlSession=sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }

    public static void close(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
            local.remove();
        }

    }
}
