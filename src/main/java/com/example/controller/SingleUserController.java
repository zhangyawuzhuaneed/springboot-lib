package com.example.controller;

import com.example.pojo.Book;
import com.example.pojo.User;
import com.example.service.BookService;
import com.example.service.SingleUserService;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.security.WSeedGenerator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class SingleUserController {
    @Autowired
    private SingleUserService bookServiceImpl;


    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookLib;

    //查询所有并分页显示
    @GetMapping("/single_user/list")
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


    // 多表协同
    @RequestMapping("/single_user/queryBookById/{bookId}")
    @ResponseBody
    public String borrow1(@PathVariable("bookId") int bookId) {

        System.out.println("test");
        bookServiceImpl.queryBookById(bookId);


        return "testT";  // redirect 重定向/跳转
    }




    @RequestMapping("/single_user/queryBookByName/{BookName}")
    public String borrow4(@PathVariable("BookName") String BookName) {

        System.out.println("queryBookByName");
//        List<Book> books = new ArrayList<Book>();
        List<Book> books = bookLib.queryBookByName(BookName);
        Book book = books.get(0);
        bookServiceImpl.addBook(book);
//        SingleUserController s = new SingleUserController();
        return "redirect:/single_user/list"; // redirect 重定向/跳转
    }


//bug图书购买功能
    @RequestMapping("/single_user/purchase/{BookName}")
    public String purchase(@PathVariable("BookName") String BookName,
                           Model model,
                           HttpServletRequest request) {
        System.out.println("purchase");
        List<Book> books = bookLib.queryBookByName(BookName);
        Book book = books.get(0);
        System.out.println(book);
         HttpSession session = request.getSession();
        String username = (String) request.getSession().getAttribute("UserSession");
        User user = userService.getUserByName(username);
        System.out.println(user);
        model.addAttribute("user", user);
        System.out.println("before purchar" + user.getMoney());
        Double last_money = user.getMoney() - book.getPrice();
        if (last_money > 0) {
            user.setMoney(last_money);
            bookServiceImpl.updateUser(user);
            System.out.println("after purchar" + user.getMoney());
//            SingleUserController singleUserController = new SingleUserController();
//            singleUserController.borrow4(book.getName());
            bookServiceImpl.addBook(book);

        } else {

            String msgM = "没有钱！";
            model.addAttribute("msgM", msgM);
            System.out.println(msgM);
        }
        model.addAttribute("user", user);

        return "redirect:/single_user/list";
    }


//


    @RequestMapping("/single_user/recharge")
    public String recharge(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String username = (String) request.getSession().getAttribute("UserSession");
        System.out.println("recharge");
        User user = userService.getUserByName(username);
        bookServiceImpl.queryUserByName(user.getUsername());
        user.getMoney();
        List<Book> books = bookLib.queryBookByName(username);
        Book book = books.get(0);
        bookServiceImpl.addBook(book);
//        SingleUserController s = new SingleUserController();
        return "redirect:/single_user/list"; // redirect 重定向/跳转
    }

    @RequestMapping("/user/torecharge")
    public String torecharge() {
        return "user/recharge";
    }


    // 多表协同
    @RequestMapping("/single_user/borrow/{bookId}")
    @ResponseBody
    public String borrow3(@PathVariable("bookId") int bookId) {
        Book book = bookLib.queryBookById(bookId);
        System.out.println(book);
        Book newBook = new Book();
        newBook.setBookId(10);
        newBook.setAuthor(book.getAuthor());
        newBook.setName(book.getName());
        newBook.setPress(book.getPress());
        newBook.setPrice(book.getPrice());
        System.out.println(newBook);
        System.out.println("test");
        bookServiceImpl.addBook(newBook);

        return "redirect:/single_user/list";  // redirect 重定向/跳转
    }


    @GetMapping("/single_user/delete/{bookId}")
    public String deletebook(@PathVariable("bookId") int bookId) {
        int i = bookServiceImpl.deleteBook(bookId);
        return "redirect:/single_user/list";
    }


}
