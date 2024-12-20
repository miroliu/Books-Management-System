package com.book.domain;

// 定义一个Admin类，用于表示管理员
public class Admin {

    // 管理员ID
    private int adminId;
    // 管理员密码
    private String password;


    // 设置管理员密码
    public void setPassword(String password) {
        this.password = password;
    }

    // 设置管理员ID
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    // 获取管理员密码
    public String getPassword() {
        return password;
    }

    // 获取管理员ID
    public int getAdminId() {
        return adminId;
    }
}
