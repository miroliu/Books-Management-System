package com.book.domain;

import java.io.Serializable;
import java.util.Date;

// 实现序列化接口
public class Lend implements Serializable {

    // 唯一标识
    private long sernum;
    // 图书ID
    private long bookId;
    // 读者ID
    private int readerId;
    // 借出日期
    private Date lendDate;
    // 归还日期
    private Date backDate;

    // 设置读者ID
    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    // 设置图书ID
    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    // 设置归还日期
    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    // 设置借出日期
    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    // 设置唯一标识
    public void setSernum(long sernum) {
        this.sernum = sernum;
    }

    // 获取读者ID
    public int getReaderId() {
        return readerId;
    }

    // 获取图书ID
    public long getBookId() {
        return bookId;
    }

    // 获取归还日期
    public Date getBackDate() {
        return backDate;
    }

    // 获取借出日期
    public Date getLendDate() {
        return lendDate;
    }

    // 获取唯一标识
    public long getSernum() {
        return sernum;
    }
}
