package edu.soft2.controller;

import edu.soft2.controller.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("json")
public class jsonController {
    @RequestMapping("/getUser")
    @ResponseBody //将java对象转为json格式数据
    public User getUser(){
  User user=new User();
  user.setUsername("peter");
  user.setBirthday(new Date());
  return user;
    }
}
