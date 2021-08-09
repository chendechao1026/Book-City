package com.example.book.dao.impl;

import com.example.book.web.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //使用DbUtils
    private QueryRunner queryRunner = new QueryRunner();
    
    // update()方法用来执行 Insert update Delete 语句
    public int update(String sql,Object ...args){
        Connection connt = JdbcUtils.getConnection();
        try {
          return   queryRunner.update(connt,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connt);
        }
        //如果返回-1表示失败  返回其他表示影响的行数
        return -1;
    }
    //查询返回一条JavaBean的语句
    // <T>返回类型为泛型 type返回的对象类型 sql 执行sql语句 args sql对应的参数值
     public <T> T queryForOne(Class<T>type, String  sql,Object ...args){
        Connection con  = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(con);
        }
        return null;
    }
    //查询返回多条-JavaBean语句
    public <T> List<T> queryList(Class<T>type,String sql,Object ...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
    
    public Object queryForSingleValue(String sql,Object ...args){
        Connection co = JdbcUtils.getConnection();
        try {
            return queryRunner.query(co,sql,new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(co);
        }
        return null;
    }
}
