package com.example.controller;

import com.example.pojo.Book;
import com.example.pojo.User;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: xiang
 * Date: 2021/9/28 1:00
 */
@Controller
public class UserController {

    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate;


    @Autowired
    private UserService userService;

    @GetMapping("/admin/conditionQuery")
    public String conditionQuery(User user, Model model) {
        List<User> users = userService.conditionQuery(user);
        System.out.println(user);
        model.addAttribute("users", users);
        return "admin/list";
    }


    @ResponseBody
    @RequestMapping("/conditionQuery123")
    public String conditionQuery(User user) {
        User user1 = new User();
        user1.setUsername("xiang");
        List<User> users = userService.conditionQuery(user1);
        System.out.println(user1);

        return "users";
    }

    @ResponseBody
    @RequestMapping("/conditionQuery12")
    public String conditionQuery1(User user) {
        User user1 = new User();
        user1.setUsername("xiang");
//        List<User> users = userService.conditionQuery(user1);
        System.out.println(user1);

        return "users";
    }





    @ResponseBody
    @GetMapping("/redis/{username}")
    public String redis(HttpServletRequest request,
                        @RequestParam("username") String username) {
//        List<User> users = userService.conditionQuery(user1);
        HttpSession session = request.getSession();
        session.setAttribute("UserSession1", username);
        System.out.println("1");
//        redisTemplate.opsForValue().set("123", "234");
        String password = (String) redisTemplate.opsForValue().get(username);
//        System.out.println(password);
        System.out.println(password);
        System.out.println("2");
        String username1 = (String) redisTemplate.opsForValue().get("username");
        System.out.println(username1);
        return password;
    }


    //登录验证
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpServletRequest request, User user) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        redisTemplate.opsForValue().set(username, password);
        redisTemplate.opsForValue().set("username", username);

        HttpSession session = request.getSession();
        session.setAttribute("UserSession", username);
        System.out.println(username);
        System.out.println(session);

        try {
            subject.login(token);
            model.addAttribute("username", username);
            if (("admin").equals(username)) {
                return "redirect:/admin/list";
            } else {
                return "redirect:/user/list";
            }

        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名错误");
            return "index";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "index";
        }

    }


    //注册
    @RequestMapping("/registering")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        User user = new User();
        String s = userService.checkUserName(username);
        if (s == null) {
            user.setUsername(username);
            user.setPassword(password);
            userService.register(user);
            return "redirect:/user/list";
        } else {
            model.addAttribute("fail", "该用户存在");
            System.out.println("该用户存在");
            return "register";
        }
    }

    //注销
    @RequestMapping(value = "/logout")
    public String getLogout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.removeAttribute("UserSession");
        }
        return "index";

    }

}

