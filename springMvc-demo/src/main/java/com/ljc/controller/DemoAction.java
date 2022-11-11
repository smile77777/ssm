package com.ljc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoAction {
    /**
     * action中所有的方法都用来实现功能
     * action功能有规范
     * 1）访问权限public
     * 2）返回值 任意
     * 3）方法名称任意不用写 doget，dopost
     * 4）参数任意
     * 5）要使用@RequestMapping声明路径
     */
    @RequestMapping("/demo.action")
    public String demo(){
        System.out.println("服务器被访问到了");
        return "main";//可以直接跳到/admin/main.jsp
    }

    @RequestMapping("/one.action")
    public String demo1(String name,int age){
        System.out.println("name="+name+"age="+(age+1000));
        return "main";
    }
}
