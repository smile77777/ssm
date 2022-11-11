package com.ljc.mapper.impl;

import com.ljc.mapper.schoolMapper;
import com.ljc.pojo.School;

public class schoolMapperImpl implements schoolMapper {
    @Override
    public int insert(School school) {
        System.out.println("school插入成功"+school);
        return 1;
    }
}
