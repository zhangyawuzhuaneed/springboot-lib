package com.example.controller;

import com.example.pojo.User;
import com.example.service.SingleUserService;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.pojo.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * book: xiang
 * Date: 2021/9/28 1:01
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookServiceImpl;
    @Autowired
    private UserService userService;


    //查询所有并分页显示
    @GetMapping("/user/list")
    public String queryAllbook(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            Model model,
            HttpServletRequest request) {
        //获取指定页数据，每页显示5条数据
        PageHelper.startPage(page, 5);
        //紧跟的第一个select方法被分页
        List<Book> books = bookServiceImpl.queryAllBook();
        model.addAttribute("books", books);
        //使用PageInfo包装数据 navigatePages表示导航标签的数量
        PageInfo pageInfo = new PageInfo(books, 5);
        model.addAttribute("pageInfo", pageInfo);
        //显示用户信息
        HttpSession session = request.getSession();
        String username = (String) request.getSession().getAttribute("UserSession");
        User user = userService.getUserByName(username);
//        User user = userService.getUserByName("user");
        System.out.println(user);
        model.addAttribute("user", user);
        return null;
    }


    //查询所有并分页显示
    @GetMapping("/user/tolist")
    public String touserlist(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            Model model) {

        return "redirect:/user/list";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";  // redirect 重定向/跳转
    }

    @GetMapping("/admin/toadd")
    public String toaddbook() {
        return "admin/add";  // redirect 重定向/跳转
    }


    @PostMapping("/admin/add")
    public String addbook(Book book) {
        int i = bookServiceImpl.addBook(book);
        return "redirect:/admin/list";  // redirect 重定向/跳转
    }

    @GetMapping("/queryBookById/{bookId}")
    public String querybookById(@PathVariable("bookId") int bookId, Model model) {
        Book book = bookServiceImpl.queryBookById(bookId);
        model.addAttribute("book", book);
        return "user/update";  //转发（默认为）
    }

    @PostMapping("/user/update")
    public String queryBookById(Book book) {
        System.out.println(book);
        int i = bookServiceImpl.updateBook(book);
        return "redirect:/user/list";
    }


    @GetMapping("/user/delete/{bookId}")
    public String deletebook(@PathVariable("bookId") int bookId) {
        int i = bookServiceImpl.deleteBook(bookId);
        return "redirect:/user/list";
    }

    @GetMapping("/conditionQuery")
    public String conditionQuery(Book book, Model model) {
        List<Book> books = bookServiceImpl.conditionQuery(book);
        model.addAttribute("books", books);
        return "user/list";
    }



}
