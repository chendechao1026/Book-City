package com.example.book.web;

import com.example.book.pojo.User;
import com.example.book.servlet.UserService;
import com.example.book.servlet.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用userService.login()处理业务
        User loginUser = userService.login(new User(1, username, password, null));
        //如果等于null说明登录失败；
        if (loginUser == null) {
            System.out.println("登录失败");
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        }else{
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
        }
    }
}
