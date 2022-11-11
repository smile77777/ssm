package com.ljc.service.impl;

import com.ljc.mapper.userMapper;
import com.ljc.pojo.Users;
import com.ljc.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class userServiceImpl implements userService {

    @Autowired
    userMapper userMapper;

    @Override
    public int insert(Users users) {
        System.out.println("service层执行了");
        return userMapper.insert(users);
    }
}
