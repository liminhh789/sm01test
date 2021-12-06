package edu.soft2.controller.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String username;
    String pwd;
    int age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date birthday;//springmvc进行类型转换
    Address address;//自定义对象类型
}
