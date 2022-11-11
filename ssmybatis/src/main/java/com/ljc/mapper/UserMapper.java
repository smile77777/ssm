package com.ljc.mapper;

import com.ljc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *     private String userId;
 *     private String cardType;
 *     private String cardNo;
 *     private String userName;
 *     private String userSex;
 *     private String userAge;
 *     private String userRole;
 */
public interface UserMapper {
   List<User> selectUserPage(@Param("userName")
                             String userName,
                             @Param("userSex")
                             String userSex,
                             @Param("startRow")
                             int startRow);
   int createUser(User user);
   int deleteUserById(String userId);
   int getRowCount(@Param("userName")
                   String userName,
                   @Param("userSex")
                   String userSex);
}
