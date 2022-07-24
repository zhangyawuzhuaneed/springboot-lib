package com.example.controller;


import com.example.pojo.Book;
import com.example.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {


    @Autowired
    BookServiceImpl bookService;

    @GetMapping("/test1")
    @ResponseBody
    public List<Book> index1() {
        List<Book> byId = bookService.queryAllBook();
        System.out.println(byId);

        return byId;
    }


    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping("/1")
    public String iii() {
        return "1";
    }

//    @GetMapping("/add")
//    public String add(){
//        return  "user/add";
//    }
//
//
//
//    @RequestMapping("/list")
//    public String list(){
//        return  "user/list";
//    }

//    @GetMapping("/update")
//    public String update(){
//        return  "user/update";
//    }
//    @GetMapping("/register")
//    public String register(){
//        return  "user/register";
//    }

}
