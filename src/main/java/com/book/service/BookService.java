package com.book.service;

import com.book.dao.BookDao;
import com.book.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// 定义一个BookService类，用于处理图书相关的业务逻辑
@Service
public class BookService {
    // 定义一个BookDao对象，用于操作数据库
    private BookDao bookDao;

    // 使用@Autowired注解，自动注入BookDao对象
    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    // 根据搜索关键字查询图书
    public ArrayList<Book> queryBook(String searchWord){
        return  bookDao.queryBook(searchWord);
    }

    // 获取所有图书
    public ArrayList<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }

    // 根据图书ID删除图书
    public int deleteBook(long bookId){
        return bookDao.deleteBook(bookId);
    }

    // 根据搜索关键字匹配图书
    public boolean matchBook(String searchWord){
        return bookDao.matchBook(searchWord)>0;
    }

    // 添加图书
    public boolean addBook(Book book){
        return bookDao.addBook(book)>0;
    }

    // 根据图书ID获取图书
    public Book getBook(Long bookId){
        Book book=bookDao.getBook(bookId);
        return book;
    }
    // 编辑图书
    public boolean editBook(Book book){
        return bookDao.editBook(book)>0;
    }

}
