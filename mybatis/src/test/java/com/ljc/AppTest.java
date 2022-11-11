package com.ljc;

import static org.junit.Assert.assertTrue;

import com.ljc.until.SqlSessionUntil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void SqlUntilTest(){
        SqlSession sqlSession= SqlSessionUntil.openSession();
        int count =sqlSession.insert("insertCar");
        System.out.println("成功插入"+count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
