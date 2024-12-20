package com.book.service;

import com.book.dao.LendDao;
import com.book.domain.Lend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// 定义一个LendService类，用于处理借书和还书的业务逻辑
@Service
public class LendService {
    // 定义一个LendDao对象，用于操作数据库
    private LendDao lendDao;

    // 使用@Autowired注解，将LendDao对象注入到LendService类中
    @Autowired
    public void setLendDao(LendDao lendDao) {
        this.lendDao = lendDao;
    }

    // 定义一个bookReturn方法，用于还书
    public boolean bookReturn(long bookId){
        // 调用LendDao对象的bookReturnOne和bookReturnTwo方法，返回还书的结果
        return lendDao.bookReturnOne(bookId)>0 && lendDao.bookReturnTwo(bookId)>0;
    }

    // 定义一个bookLend方法，用于借书
    public boolean bookLend(long bookId,int readerId){
        // 调用LendDao对象的bookLendOne和bookLendTwo方法，返回借书的结果
        return lendDao.bookLendOne(bookId,readerId)>0 && lendDao.bookLendTwo(bookId)>0;
    }

    // 定义一个lendList方法，用于获取所有借书记录
    public ArrayList<Lend> lendList(){
        // 调用LendDao对象的lendList方法，返回所有借书记录
        return lendDao.lendList();
    }
    // 定义一个myLendList方法，用于获取指定用户的借书记录
    public ArrayList<Lend> myLendList(int readerId){
        // 调用LendDao对象的myLendList方法，返回指定用户的借书记录
        return lendDao.myLendList(readerId);
    }

}
