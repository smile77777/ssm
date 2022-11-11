package com.ljc.controller;

import com.ljc.pojo.User;
import com.ljc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/user")
@CrossOrigin//支持跨域访问
public class userController {

    @Autowired
    UserService userService;

    public static final int PAGE_SIZE=5;

    @RequestMapping("/selectUserPage")
    @ResponseBody
    public List<User> selectUserPage(String userName,String userSex,Integer page){
        //根据页码计算起始行
        int startRow=0;
        if(page!=null){
            startRow=(page-1)*PAGE_SIZE;
        }
        return userService.selectUserPage(userName,userSex,startRow);
    }

    @RequestMapping("/getRowCount")
    @ResponseBody
    public int getRowCount(String userName,String userSex){
        return userService.getRowCount(userName,userSex);
    }

    @RequestMapping("/deleteUserById")
    @ResponseBody
    public int deleteUserById(String userId){
        return userService.deleteUserById(userId);
    }

    @RequestMapping("createUser")
    @ResponseBody
    public int createUser(User user){
        String userId=System.currentTimeMillis()+"";
        user.setUserId(userId);
        return userService.createUser(user);
    }
}
