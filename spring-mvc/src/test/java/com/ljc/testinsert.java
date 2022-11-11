package com.ljc;

import com.ljc.controller.controller;
import com.ljc.pojo.School;
import com.ljc.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testinsert {
    @Test
    public void testInsertStudent(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        controller con=(controller) ac.getBean("controller");
        con.insertStudent((Student) ac.getBean("student"));
    }
}
