package com.example.controller;

import com.example.pojo.Book;
import com.example.pojo.User;
import com.example.service.BookService;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class AdminController {
    @Autowired
    private BookService bookServiceImpl;

    @Autowired
    private UserService userService;

    //查询所有user并分页显示
    @GetMapping("/users/list")
    public String queryAllUser(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            Model model) {
        //获取指定页数据，每页显示5条数据
        PageHelper.startPage(page, 5);
        //紧跟的第一个select方法被分页
        List<User> users = userService.getAllUser();
        System.out.println(users);
        model.addAttribute("users", users);
        //使用PageInfo包装数据 navigatePages表示导航标签的数量
        PageInfo pageInfo = new PageInfo(users, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/Usermanager";
    }

//    @GetMapping("/admin/Usermanager")
//    public String Usermanager(){
//        return "/admin/Usermanager";
//    }

    //查询所有并分页显示
    @GetMapping("/admin/list")
    public String queryAllbook(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            Model model) {
        //获取指定页数据，每页显示5条数据
        PageHelper.startPage(page, 5);
        //紧跟的第一个select方法被分页
        List<Book> books = bookServiceImpl.queryAllBook();
        model.addAttribute("books", books);
        //使用PageInfo包装数据 navigatePages表示导航标签的数量
        PageInfo pageInfo = new PageInfo(books, 5);
        model.addAttribute("pageInfo", pageInfo);
        return null;
    }


    @GetMapping("/admin/delete/{bookId}")
    public String deletebook(@PathVariable("bookId") int bookId) {
        int i = bookServiceImpl.deleteBook(bookId);
        return "redirect:/admin/list";
    }


//    @PostMapping("/user/add")
//    public String addbook(Book book) {
//        int i = bookServiceImpl.addBook(book);
//        return "redirect:/user/list";  // redirect 重定向/跳转
//    }

    @RequestMapping("/admin/userShow")
    public String register() {
        return "/admin/userShow";  // redirect 重定向/跳转
    }


}

