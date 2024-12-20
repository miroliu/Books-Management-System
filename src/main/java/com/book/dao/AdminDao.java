package com.book.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

    // 定义JdbcTemplate对象
    private JdbcTemplate jdbcTemplate;

    // 使用@Autowired注解自动注入JdbcTemplate对象
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // 定义查询管理员密码的SQL语句
    private static final String MATCH_ADMIN_SQL="SELECT COUNT(*) FROM admin where admin_id = ? and password = ? ";
    // 定义更新管理员密码的SQL语句
    private static final String RE_PASSWORD_SQL="UPDATE admin set password = ? where admin_id = ? ";
    // 定义查询管理员密码的SQL语句
    private static final String GET_PASSWD_SQL="SELECT password from admin where admin_id = ?";

    // 根据管理员ID和密码查询管理员密码
    public int getMatchCount(int adminId,String password){
        // 使用JdbcTemplate对象的queryForObject方法执行查询语句，并返回查询结果
        return jdbcTemplate.queryForObject(MATCH_ADMIN_SQL,new Object[]{adminId,password},Integer.class);
    }

    // 根据管理员ID和新的密码更新管理员密码
    public int rePassword(int adminId,String newPasswd){
        // 使用JdbcTemplate对象的update方法执行更新语句，并返回更新结果
        return jdbcTemplate.update(RE_PASSWORD_SQL,new Object[]{newPasswd,adminId});
    }
    // 根据管理员ID查询管理员密码
    public String getPasswd(int id){
        // 使用JdbcTemplate对象的queryForObject方法执行查询语句，并返回查询结果
        return jdbcTemplate.queryForObject(GET_PASSWD_SQL,new Object[]{id},String.class);
    }

}
