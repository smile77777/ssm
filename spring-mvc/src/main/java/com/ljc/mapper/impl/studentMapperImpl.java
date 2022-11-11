package com.ljc.mapper.impl;

import com.ljc.mapper.studentMapper;
import com.ljc.pojo.Student;
import org.springframework.stereotype.Repository;

@Repository
public class studentMapperImpl implements studentMapper {
    @Override
    public int insert(Student student) {
        System.out.println("插入成功"+student);
        return 1;
    }
}
