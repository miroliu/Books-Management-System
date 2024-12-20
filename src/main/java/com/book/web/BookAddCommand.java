package com.book.web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookAddCommand {


    //书籍名称
    private String name;
    //作者
    private String author;
    //出版社
    private String publish;
    //ISBN号
    private String isbn;
    //书籍简介
    private String introduction;
    //语言
    private String language;
    //价格
    private BigDecimal price;
    //出版日期
    private Date pubdate;
    //分类ID
    private int classId;
    //出版社编号
    private int pressmark;
    //状态
    private int state;

    //设置书籍名称
    public void setName(String name) {
        this.name = name;
    }

    //设置作者
    public void setAuthor(String author) {
        this.author = author;
    }

    //设置分类ID
    public void setClassId(int classId) {
        this.classId = classId;
    }

    //设置语言
    public void setLanguage(String language) {
        this.language = language;
    }

    //设置ISBN号
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }



    //设置出版日期
    public void setPubdate(String pubdate) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        try{
            java.util.Date date=sdf.parse(pubdate);
            this.pubdate=date;
        }catch (ParseException e){
            e.printStackTrace();
        }

    }

    //设置出版社
    public void setPublish(String publish) {
        this.publish = publish;
    }

    //设置书籍简介
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    //设置价格
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //设置出版社编号
    public void setPressmark(int pressmark) {
        this.pressmark = pressmark;
    }

    //设置状态
    public void setState(int state) {
        this.state = state;
    }

    //获取书籍名称
    public String getName() {
        return name;
    }

    //获取价格
    public BigDecimal getPrice() {
        return price;
    }


    //获取分类ID
    public int getClassId() {
        return classId;
    }

    //获取出版日期
    public Date getPubdate() {
        return pubdate;
    }

    //获取作者
    public String getAuthor() {
        return author;
    }

    //获取书籍简介
    public String getIntroduction() {
        return introduction;
    }

    //获取出版社编号
    public int getPressmark() {
        return pressmark;
    }

    //获取ISBN号
    public String getIsbn() {
        return isbn;
    }

    //获取语言
    public String getLanguage() {
        return language;
    }

    //获取状态
    public int getState() {
        return state;
    }

    //获取出版社
    public String getPublish() {
        return publish;
    }



}
