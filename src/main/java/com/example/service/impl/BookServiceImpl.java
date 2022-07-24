package com.example.service.impl;

import com.example.mapper.BookMapper;
import com.example.pojo.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xiang
 * Date: 2021/9/28 0:59
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBook(int bookId) {
        return bookMapper.deleteBook(bookId);
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
    public List<Book> queryBookByName(String BookName) {
        return bookMapper.queryBookByName(BookName);
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
    public int deleteBookNum(String BookName) {
        return bookMapper.deleteBookNum(BookName);
    }

    @Override
    public int updateBookNum(String BookName) {
        return bookMapper.updateBookNum(BookName);
    }


}

