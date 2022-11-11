package com.ljc.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

public class mybatis01test {
    public static void main(String[] args) {

//        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession=null;
        try {
            // 1. 创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 2. 创建SqlSessionFactory对象
            //InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            // 3. 创建SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
            // 4. 执⾏sql
            int count = sqlSession.insert("insertCar"); // 这个"insertCar"必须是sql的id
            System.out.println("插⼊⼏条数据：" + count);
            // 5. 提交（mybatis默认采⽤的事务管理器是JDBC，默认是不提交的，需要⼿动提 交。）
            sqlSession.commit();
        } catch (IOException e) {
            if(sqlSession !=null){
                sqlSession.rollback();
            }
            e.printStackTrace();
        }finally {
            // 6. 关闭资源（只关闭是不会提交的）
            if(sqlSession !=null){
                sqlSession.close();
            }

        }




    }
}
