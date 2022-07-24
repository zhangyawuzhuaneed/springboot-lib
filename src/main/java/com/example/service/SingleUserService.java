package com.example.service;

import com.example.pojo.Book;
import com.example.pojo.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xiang
 * Date: 2021/9/28 0:58
 */
public interface SingleUserService {
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

    //条件查询
    List<Book> conditionQuery(Book book);


    // 根据username查一个
    User queryUserByName(String username);

    //模糊查询
    List<Book> ListQuery(String value);

    // 改
    int updateUser(User user);

    //the number of Book
    // 增
    int addBookNum(String BookName);

    // 删
    int deleteBookNum(String BookName);

    // 改
    int updateBookNum(String BookName);
}

