package com.example.service;

import com.example.pojo.Book;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xiang
 * Date: 2021/9/28 0:58
 */
public interface BookService {
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


    // 根据name查一个
    List<Book> queryBookByName(String BookName);


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

