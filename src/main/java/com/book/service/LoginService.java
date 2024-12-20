package com.book.service;

import com.book.dao.AdminDao;
import com.book.dao.ReaderCardDao;
import com.book.dao.ReaderInfoDao;
import com.book.domain.ReaderCard;
import com.book.domain.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 登录服务类
@Service
public class LoginService {

    // 读者证数据访问对象
    private ReaderCardDao readerCardDao;
    // 读者信息数据访问对象
    private ReaderInfoDao readerInfoDao;
    // 管理员数据访问对象
    private AdminDao adminDao;
    // 自动注入读者证数据访问对象
    @Autowired
    public void setReaderCardDao(ReaderCardDao readerCardDao) {
        this.readerCardDao = readerCardDao;
    }

    // 自动注入读者信息数据访问对象
    @Autowired
    public void setReaderInfoDao(ReaderInfoDao readerInfoDao) {
        this.readerInfoDao = readerInfoDao;
    }

    // 自动注入管理员数据访问对象
    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    // 判断读者证密码是否匹配
    public boolean hasMatchReader(int readerId,String passwd){
        return  readerCardDao.getMatchCount(readerId, passwd)>0;
    }

    // 根据读者证号查找读者证信息
    public ReaderCard findReaderCardByUserId(int readerId){
        return readerCardDao.findReaderByReaderId(readerId);
    }
    // 根据读者证号查找读者信息
    public ReaderInfo findReaderInfoByReaderId(int readerId){
        return readerInfoDao.findReaderInfoByReaderId(readerId);
    }

    // 判断管理员密码是否匹配
    public boolean hasMatchAdmin(int adminId,String password){
        return adminDao.getMatchCount(adminId,password)==1;
    }

    // 修改管理员密码
    public boolean adminRePasswd(int adminId,String newPasswd){
        return adminDao.rePassword(adminId,newPasswd)>0;
    }
    // 获取管理员密码
    public String getAdminPasswd(int id){
        return adminDao.getPasswd(id);
    }



}
