package com.example.book.servlet;

import com.example.book.pojo.User;
import com.example.book.servlet.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(1,"cdc1","123456","1532483511@qq.com"));
        userService.registUser(new User(1,"cdc2","123456","1532483511@qq.com"));
        userService.registUser(new User(1,"cdc3","123456","1532483511@qq.com"));
        userService.registUser(new User(1,"cdc4","123456","1532483511@qq.com"));

    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(1,"cdc1","123456","1532483511@qq.com")));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("cdc123")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }
    }
}