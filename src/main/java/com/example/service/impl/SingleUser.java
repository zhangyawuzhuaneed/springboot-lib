package com.example.service.impl;

import com.example.mapper.SingleMapper;
import com.example.pojo.Book;
import com.example.pojo.User;
import com.example.service.SingleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SingleUser implements SingleUserService {

    @Autowired
    private SingleMapper bookMapper;

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBook(int bookId) {
        return bookMapper.deleteBook(bookId);
    }

    @Override
    public int updateUser(User user) {
        return bookMapper.updateUser(user);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public List<Book> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public Book queryBookById(int bookId) {
        return bookMapper.queryBookById(bookId);
    }

    @Override
    public List<Book> conditionQuery(Book book) {
        return bookMapper.conditionQuery(book);
    }


    @Override
    public List<Book> ListQuery(String value) {
        return bookMapper.ListQuery(value);
    }

    @Override
    public int addBookNum(String BookName) {
        return bookMapper.addBookNum(BookName);
    }

    @Override
    public User queryUserByName(String username) {
        return bookMapper.queryUserByName(username);
    }

    @Override
    public int deleteBookNum(String BookName) {
        return bookMapper.deleteBookNum(BookName);
    }

    @Override
    public int updateBookNum(String BookName) {
        return bookMapper.updateBookNum(BookName);
    }


}