package com.ljc.test;

import com.ljc.pojo.Users;
import com.ljc.service.userService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void testUser(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext_service.xml");
        userService userService = (com.ljc.service.userService) ac.getBean("userServiceImpl");
        int num=userService.insert(new Users(100,"张三","123"));
        System.out.println(num);
    }
}
