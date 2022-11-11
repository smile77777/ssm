package com.ljc.service;

import com.ljc.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectUserPage(String userName,String userSex,int startRow);
    int createUser(User user);
    int deleteUserById(String userId);
    int getRowCount(String userName,String userSex);
}
