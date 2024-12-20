package com.book.service;

import com.book.dao.ReaderInfoDao;
import com.book.domain.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// 定义一个ReaderInfoService类，用于处理读者信息相关的业务逻辑
@Service
public class ReaderInfoService {

    // 定义一个ReaderInfoDao对象，用于操作读者信息的数据
    private ReaderInfoDao readerInfoDao;
    // 使用@Autowired注解，将ReaderInfoDao对象注入到ReaderInfoService类中
    @Autowired
    public void setReaderInfoDao(ReaderInfoDao readerInfoDao) {
        this.readerInfoDao = readerInfoDao;
    }
    // 定义一个方法，用于获取所有读者信息
    public ArrayList<ReaderInfo> readerInfos(){
        return readerInfoDao.getAllReaderInfo();
    }

    // 定义一个方法，用于删除指定id的读者信息
    public boolean deleteReaderInfo(int readerId){
        return readerInfoDao.deleteReaderInfo(readerId)>0;
    }

    // 定义一个方法，用于根据id获取读者信息
    public ReaderInfo getReaderInfo(int readerId){
        return readerInfoDao.findReaderInfoByReaderId(readerId);
    }
    // 定义一个方法，用于编辑读者信息
    public boolean editReaderInfo(ReaderInfo readerInfo){
        return readerInfoDao.editReaderInfo(readerInfo)>0;
    }
    // 定义一个方法，用于添加读者信息
    public boolean addReaderInfo(ReaderInfo readerInfo){
        return  readerInfoDao.addReaderInfo(readerInfo)>0;
    }
}
