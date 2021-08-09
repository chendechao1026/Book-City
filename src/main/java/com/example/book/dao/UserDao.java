package com.example.book.dao;

import com.example.book.pojo.User;
/*
* 
* */
public interface UserDao {
    
    
    
    //根据用户名查询用户信息  username用户， 如果返回null说明没有这个用户反之亦然
    public User queryUserByUsername(String username);
    
    //保存用户信息

    /**
     * 根据用户名和密码查询用
     * @param username
     * @param password
     * @return 如果返回null说明用户名或密码错误，反之亦然
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);
}
