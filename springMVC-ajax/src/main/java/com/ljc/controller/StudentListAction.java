package com.ljc.controller;

import com.ljc.pojo.student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentListAction {
    @RequestMapping("/list.action")
    @ResponseBody
    public List<student> list(){
        List<student> list=new ArrayList<>();
        student stu1=new student("zhangsan",12);
        student stu2=new student("lisi",13);
        student stu3=new student("star",14);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        return list;
    }
}
