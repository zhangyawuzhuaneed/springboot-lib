package com.example.service;

import com.example.pojo.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xiang
 * Date: 2021/9/28 0:58
 */
public interface UserService {
    //登录验证
    User logincheck(User user);

    //注册
    void register(User user);


    //检查是否用户存在
    String checkUserName(String username);

    List<User> getAllUser();

    User getUserByName(String name);

    //条件查询
    List<User> conditionQuery(User user);


}

