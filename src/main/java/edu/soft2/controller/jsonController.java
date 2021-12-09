package edu.soft2.controller;

import edu.soft2.controller.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("json")
public class jsonController {
    @RequestMapping(value = "getUser")
    @ResponseBody
public User getUser(){
    User user=new User();
    user.setUsername("Peter");
    user.setBirthday(new Date());
        System.out.println("user"+user);
    return user;
    }
    @RequestMapping(value = "getJsonRegInfot")
    public void getJsonRegInfo(@RequestBody User user){
        System.out.println("接收到注册信息"+user);
    }
}
