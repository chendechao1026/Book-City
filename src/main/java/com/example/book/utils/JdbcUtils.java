package com.example.book.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

  private static DruidDataSource dataSource;
  static {
    try {
    //读取jdbc.propertise属性，
    InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
      Properties properties = new Properties();
      //重流中加载数据
    properties.load(inputStream);
    //创建数据库连接池
      dataSource =(DruidDataSource)DruidDataSourceFactory.createDataSource(properties);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  

  // 获取数据库中连接池中的连接


  public static Connection getConnection() {
    Connection conn = null;
    try {
      conn = dataSource.getConnection();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return conn;
  }

  //关闭连接，放回数据库连接池
  public static void close(Connection conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }

}
