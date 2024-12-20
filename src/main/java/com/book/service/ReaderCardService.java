package com.book.service;

import com.book.dao.ReaderCardDao;
import com.book.domain.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 定义一个ReaderCardService类，用于处理读者证的业务逻辑
@Service
public class ReaderCardService {
    // 定义一个ReaderCardDao对象
    private ReaderCardDao readerCardDao;

    // 使用@Autowired注解自动注入ReaderCardDao对象
    @Autowired
    public void setReaderCardDao(ReaderCardDao readerCardDao) {
        this.readerCardDao = readerCardDao;
    }
    // 添加读者证
    public boolean addReaderCard(ReaderInfo readerInfo){
        // 调用ReaderCardDao的addReaderCard方法，传入ReaderInfo对象，返回结果大于0表示添加成功
        return  readerCardDao.addReaderCard(readerInfo)>0;
    }
    // 更新读者证密码
    public boolean updatePasswd(int readerId,String passwd){
        // 调用ReaderCardDao的rePassword方法，传入读者证ID和密码，返回结果大于0表示更新成功
        return readerCardDao.rePassword(readerId,passwd)>0;
    }
    // 更新读者证姓名
    public boolean updateName(int readerId,String name){
        // 调用ReaderCardDao的updateName方法，传入读者证ID和姓名，返回结果大于0表示更新成功
        return readerCardDao.updateName(readerId,name)>0;
    }

}
