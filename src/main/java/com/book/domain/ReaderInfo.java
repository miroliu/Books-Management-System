package com.book.domain;

import java.io.Serializable;
import java.util.Date;

// 定义一个读者信息类，实现Serializable接口，用于序列化
public class ReaderInfo implements Serializable{

    // 读者ID
    private int readerId;
    // 读者姓名
    private String name;
    // 读者性别
    private String sex;
    // 读者出生日期
    private Date birth;
    // 读者地址
    private String address;
    // 读者电话号码
    private String telcode;

    // 设置读者姓名
    public void setName(String name) {
        this.name = name;
    }

    // 设置读者ID
    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    // 设置读者地址
    public void setAddress(String address) {
        this.address = address;
    }

    // 设置读者性别
    public void setSex(String sex) {
        this.sex = sex;
    }

    // 设置读者出生日期
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    // 设置读者电话号码
    public void setTelcode(String telcode) {
        this.telcode = telcode;
    }

    // 获取读者姓名
    public String getName() {
        return name;
    }

    // 获取读者ID
    public int getReaderId() {
        return readerId;
    }

    // 获取读者出生日期
    public Date getBirth() {
        return birth;
    }

    // 获取读者地址
    public String getAddress() {
        return address;
    }

    // 获取读者性别
    public String getSex() {
        return sex;
    }

    // 获取读者电话号码
    public String getTelcode() {
        return telcode;
    }
}
