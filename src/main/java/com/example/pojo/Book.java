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
public class Book {
    /**
     * bookId int not null primary key auto_increment, --图书id
     * name   varchar(50),                             --图书名
     * author varchar(50),                             --图书作者
     * press  varchar(50),                             --图书出版社
     * price  double(6, 2                              --图书单价
     */
    private int bookId;
    private String name;
    private String author;
    private String press;
    private double price;
    private int bootNum;
}

