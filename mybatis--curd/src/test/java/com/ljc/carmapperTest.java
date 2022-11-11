package com.ljc;

import com.ljc.mybatisUntil.SqlSessionUntil;
import com.ljc.pojo.Car;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class carmapperTest {
    @Test
    public void insertTest(){

        Map<String, Object> map = new HashMap<>();
        map.put("carNum", "103");
        map.put("brand", "奔驰E300L");
        map.put("guidePrice", 50.3);
        map.put("produceTime", "2020-10-01");
        map.put("carType", "燃油车");

        SqlSession sqlSession= SqlSessionUntil.sqlSessionOpen();
        int count=sqlSession.insert("insertCar",map);
        System.out.println("插入了"+count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertTestByPojo(){
        Car car=new Car(null,"3333","比亚迪",43.50,"2020-11-11","燃油车");
        SqlSession sqlSession=SqlSessionUntil.sqlSessionOpen();
        int count=sqlSession.insert("insertCar",car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteByIdTest(){
        SqlSession sqlSession=SqlSessionUntil.sqlSessionOpen();
        int count = sqlSession.delete("deleteByCarId",181);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateCarByPOJO(){
        // 准备数据
        Car car=new Car(182L,"3333","比亚迪",43.50,"2020-11-11","燃油车");
//        Car car = new Car();
//        car.setId(182L);
//        car.setCarNum("2222");
//        car.setBrand("比亚迪汉");
//        car.setGuidePrice(30.23);
//        car.setProduceTime("2018-09-10");
//        car.setCarType("电车");
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUntil.sqlSessionOpen();
        // 执行SQL语句
        int count = sqlSession.update("updateCarByPOJO", car);
        System.out.println("更新了几条记录：" + count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByidTest(){
        SqlSession sqlSession=SqlSessionUntil.sqlSessionOpen();
        Car car= sqlSession.selectOne("selectById", 182L);

        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectAllTest(){
        SqlSession sqlSession=SqlSessionUntil.sqlSessionOpen();
        List<Car> cars = sqlSession.selectList("selectAll");
        cars.forEach(car -> System.out.println("car"));
        sqlSession.close();
    }
}
