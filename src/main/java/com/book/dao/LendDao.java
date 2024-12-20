package com.book.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import com.book.domain.Lend;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
@Repository
public class LendDao {

    // 注入JdbcTemplate
    private JdbcTemplate jdbcTemplate;
    // 定义日期格式
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 定义还书SQL语句1
    private final static String BOOK_RETURN_SQL_ONE="UPDATE lend_list SET back_date = ? WHERE book_id = ? AND back_date is NULL";

    // 定义还书SQL语句2
    private final static String BOOK_RETURN_SQL_TWO="UPDATE book_info SET state = 1 WHERE book_id = ? ";

    // 定义借书SQL语句1
    private final static String BOOK_LEND_SQL_ONE="INSERT INTO lend_list (book_id,reader_id,lend_date) VALUES ( ? , ? , ? )";

    // 定义借书SQL语句2
    private final static String BOOK_LEND_SQL_TWO="UPDATE book_info SET state = 0 WHERE book_id = ? ";

    // 定义借书列表SQL语句
    private final static String LEND_LIST_SQL="SELECT * FROM lend_list";

    // 定义我的借书列表SQL语句
    private final static String MY_LEND_LIST_SQL="SELECT * FROM lend_list WHERE reader_id = ? ";

    // 还书操作1
    public int bookReturnOne(long bookId){
        return  jdbcTemplate.update(BOOK_RETURN_SQL_ONE,new Object[]{df.format(new Date()),bookId});
    }
    // 还书操作2
    public int bookReturnTwo(long bookId){
        return jdbcTemplate.update(BOOK_RETURN_SQL_TWO,new Object[]{bookId});
    }
    // 借书操作1
    public int bookLendOne(long bookId,int readerId){
        return  jdbcTemplate.update(BOOK_LEND_SQL_ONE,new Object[]{bookId,readerId,df.format(new Date())});
    }
    // 借书操作2
    public int bookLendTwo(long bookId){
        return  jdbcTemplate.update(BOOK_LEND_SQL_TWO,new Object[]{bookId});
    }

    // 获取借书列表
    public ArrayList<Lend> lendList(){
        final ArrayList<Lend> list=new ArrayList<Lend>();

        jdbcTemplate.query(LEND_LIST_SQL, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Lend lend=new Lend();
                    lend.setBackDate(resultSet.getDate("back_date"));
                    lend.setBookId(resultSet.getLong("book_id"));
                    lend.setLendDate(resultSet.getDate("lend_date"));
                    lend.setReaderId(resultSet.getInt("reader_id"));
                    lend.setSernum(resultSet.getLong("sernum"));
                    list.add(lend);
                }
            }
        });
        return list;
    }

    // 获取我的借书列表
    public ArrayList<Lend> myLendList(int readerId){
        final ArrayList<Lend> list=new ArrayList<Lend>();

        jdbcTemplate.query(MY_LEND_LIST_SQL, new Object[]{readerId},new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Lend lend=new Lend();
                    lend.setBackDate(resultSet.getDate("back_date"));
                    lend.setBookId(resultSet.getLong("book_id"));
                    lend.setLendDate(resultSet.getDate("lend_date"));
                    lend.setReaderId(resultSet.getInt("reader_id"));
                    lend.setSernum(resultSet.getLong("sernum"));
                    list.add(lend);
                }
            }
        });
        return list;

    }
}
