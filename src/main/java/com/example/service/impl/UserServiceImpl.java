package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.Book;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xiang
 * Date: 2021/9/28 0:59
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User logincheck(User user) {
        return userMapper.logincheck(user);

    }

    @Override
    public void register(User user) {
        userMapper.register(user);

    }

    @Override
    public String checkUserName(String username) {
        return userMapper.checkUserName(username);
    }


    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }


    @Override
    public List<User> conditionQuery(User user) {
        return userMapper.conditionQuery(user);
    }

//    @Override
//    public List<Book> conditionQuery(Book book) {
//        return bookMapper.conditionQuery(book);
//    }


}

