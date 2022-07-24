package com.example.mapper;

import com.example.pojo.Book;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SingleMapper {
    /**
     * * bookId int not null primary key auto_increment, --图书id
     * * name   varchar(50),                             --图书名
     * * author varchar(50),                             --图书作者
     * * press  varchar(50),                             --图书出版社
     * * price  double(6, 2                              --图书单价
     *
     * @param
     * @return
     */


    // 改
    int updateUser(User user);

    // 增
    int addBook(Book book);

    // 删
    int deleteBook(int bookId);

    // 改
    int updateBook(Book book);

    // 查所有
    List<Book> queryAllBook();

    // 根据id查一个
    Book queryBookById(int bookId);

    // 根据id查一个
    User queryUserByName(String username);


    //条件查询
    List<Book> conditionQuery(Book book);

    //模糊查询
    List<Book> ListQuery(String value);

    //the number of Book
    // 增
    int addBookNum(String BookName);

    // 删
    int deleteBookNum(String BookName);

    // 改
    int updateBookNum(String BookName);

}

