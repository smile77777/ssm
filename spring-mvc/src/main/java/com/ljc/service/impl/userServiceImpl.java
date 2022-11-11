package com.ljc.service.impl;

import com.ljc.mapper.impl.schoolMapperImpl;
import com.ljc.mapper.impl.studentMapperImpl;
import com.ljc.mapper.schoolMapper;
import com.ljc.mapper.studentMapper;
import com.ljc.pojo.School;
import com.ljc.pojo.Student;
import com.ljc.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {

    @Autowired
    studentMapper studentMapper;//=new studentMapperImpl();
    schoolMapper schoolMapper;//=new schoolMapperImpl();

    /**
     * 使用注解开发之后可以不用set注入
     * @param student
     */
    /*public void setStudentMapper(com.ljc.mapper.studentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public void setSchoolMapper(com.ljc.mapper.schoolMapper schoolMapper) {
        this.schoolMapper = schoolMapper;
    }*/

    @Override
    public void insertStudent(Student student) {
        studentMapper.insert(student);
        System.out.println("service student ok");
    }

    @Override
    public void insertSchool(School school) {
        schoolMapper.insert(school);
        System.out.println("service school ok");
    }
}
