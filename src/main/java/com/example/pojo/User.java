package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: xiang
 * Date: 2021/9/28 0:58
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * id       int not null primary key auto_increment,
     * username varchar(12), --用户名
     * password varchar(12)  -- 密码
     */
    private int id;
    private String username;
    private String password;
    private Double money;
}

