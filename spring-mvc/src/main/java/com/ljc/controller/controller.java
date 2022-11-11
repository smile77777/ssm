package com.ljc.controller;

import com.ljc.pojo.School;
import com.ljc.pojo.Student;
import com.ljc.service.impl.userServiceImpl;
import com.ljc.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class controller {
    @Autowired
    userService userService;//=new userServiceImpl();

    public void setUserService(com.ljc.service.userService userService) {
        this.userService = userService;
    }

    public void insertStudent(Student student){
        userService.insertStudent(student);
        System.out.println("界面层");
    }
    public void insertSchool(School school){
        userService.insertSchool(school);
        System.out.println("界面层school");
    }
}
