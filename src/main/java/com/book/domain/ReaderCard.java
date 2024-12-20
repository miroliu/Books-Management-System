package com.book.domain;

import java.io.Serializable;

// 定义一个读者卡类，实现Serializable接口
public class ReaderCard implements Serializable{

    // 读者ID
    private int readerId;
    // 读者姓名
    private String name;
    // 读者密码
    private String passwd;
    // 读者卡状态
    private int cardState;

    // 设置读者卡状态
    public void setCardState(int cardState) {
        this.cardState = cardState;
    }

    // 设置读者姓名
    public void setName(String name) {
        this.name = name;
    }

    // 设置读者密码
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    // 设置读者ID
    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    // 获取读者ID
    public int getReaderId() {
        return readerId;
    }

    // 获取读者卡状态
    public int getCardState() {
        return cardState;
    }

    // 获取读者姓名
    public String getName() {
        return name;
    }

    // 获取读者密码
    public String getPasswd() {
        return passwd;
    }
}
