package com.book.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

// 定义一个Book类，实现Serializable接口，用于序列化
public class Book implements Serializable{

    // 图书ID
    private long bookId;
    // 图书名称
    private String name;
    // 作者
    private String author;
    // 出版社
    private String publish;
    // ISBN号
    private String isbn;
    // 简介
    private String introduction;
    // 语言
    private String language;
    // 价格
    private BigDecimal price;
    // 出版日期
    private Date pubdate;
    // 分类ID
    private int classId;
    // 压缩标记
    private int pressmark;
    // 状态
    private int state;

    // 设置图书名称
    public void setName(String name) {
        this.name = name;
    }

    // 设置作者
    public void setAuthor(String author) {
        this.author = author;
    }

    // 设置分类ID
    public void setClassId(int classId) {
        this.classId = classId;
    }

    // 设置语言
    public void setLanguage(String language) {
        this.language = language;
    }

    // 设置ISBN号
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // 设置图书ID
    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    // 设置出版日期
    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    // 设置出版社
    public void setPublish(String publish) {
        this.publish = publish;
    }

    // 设置简介
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    // 设置价格
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // 设置压缩标记
    public void setPressmark(int pressmark) {
        this.pressmark = pressmark;
    }

    // 设置状态
    public void setState(int state) {
        this.state = state;
    }

    // 获取图书名称
    public String getName() {
        return name;
    }

    // 获取价格
    public BigDecimal getPrice() {
        return price;
    }

    // 获取图书ID
    public long getBookId() {
        return bookId;
    }

    // 获取分类ID
    public int getClassId() {
        return classId;
    }

    // 获取出版日期
    public Date getPubdate() {
        return pubdate;
    }

    // 获取作者
    public String getAuthor() {
        return author;
    }

    // 获取简介
    public String getIntroduction() {
        return introduction;
    }

    // 获取压缩标记
    public int getPressmark() {
        return pressmark;
    }

    // 获取ISBN号
    public String getIsbn() {
        return isbn;
    }

    // 获取语言
    public String getLanguage() {
        return language;
    }

    // 获取状态
    public int getState() {
        return state;
    }

    // 获取出版社
    public String getPublish() {
        return publish;
    }

    // 重写toString方法，返回图书信息
    @Override
    public String toString() {
        return "这本书的信息为"+pressmark+pubdate+bookId+name+author+publish+isbn+introduction+language+price+classId+state;
    }
}
