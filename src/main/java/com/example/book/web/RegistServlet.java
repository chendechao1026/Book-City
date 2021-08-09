package com.example.book.web;

import com.example.book.pojo.User;
import com.example.book.servlet.UserService;
import com.example.book.servlet.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        
       // 2.检查验证码是否正确  写死验证码 要求验证码为abcde
       if("abcde".equalsIgnoreCase(code)){
            //       正确 ：
           //        3.检查 用户名是否可用
           
           if(userService.existsUsername(username)){
               //不可用
               //    跳回注册页面
               System.out.println("用户名["+username+"]不可用");
               req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
           }else{
               //            可用  
               //             调用Sservice保存到数据库
               //             跳到注册成功页面 regist_success.html
               userService.registUser(new User(1,username,password,email));
               req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);
           }
       }else {
           System.out.println("验证码[" + code + "]错误");
           //不正确   跳回注册页面
           req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
       }
       
       
    }
}
