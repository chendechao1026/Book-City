package com.example.book.test;

import com.example.book.web.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {

  @Test
  public void testJdbcUtils(){
    Connection conn = JdbcUtils.getConnection();
    System.out.println(conn);
    JdbcUtils.close(conn);
    for (int i=0;i<100;i++){
      System.out.println(conn);
    }
  }
  
    
  } 

