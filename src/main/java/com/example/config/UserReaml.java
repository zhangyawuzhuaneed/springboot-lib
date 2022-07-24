package com.example.config;


import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserReaml extends AuthorizingRealm {


    @Autowired
    UserServiceImpl userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //打印一个提示
        System.out.println("执行了授权方法");
        return null;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //打印一个提示
        System.out.println("执行了认证方法");

        // 用户名密码(暂时先自定义一个做测试)


        //通过参数获取登录的控制器中生成的 令牌
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        User user = userService.getUserByName(token.getUsername());

        //用户名认证
//        if (user != null) {
        if (user != null) {
//            if (user.getUsername() == "root"){
////                return "/admin/list";
////            }else{
////
////            }
            //密码认证， Shiro 自己做，为了避免和密码的接触
            //最后返回一个 AuthenticationInfo 接口的实现类，这里选择 SimpleAuthenticationInfo
            // 三个参数：获取当前用户的认证 ； 密码 ； 认证名
            return new SimpleAuthenticationInfo("", user.getPassword(), "");
        } else {
            // return null 就抛出没有该用户的异常
            return null;
        }
    }

}
//登录验证
//    @RequestMapping("/login")
//    public String login(@RequestParam("username") String username,
//                        @RequestParam("password") String password, Model model, HttpServletRequest request, User user) {
//        HttpSession session = request.getSession();
//        session.setAttribute("UserSession", user);
//
//        user.setUsername(username);
//        user.setPassword(password);
//        if (userService.logincheck(user) != null) {
//            model.addAttribute("username", username);
//            return "redirect:/user/list";
//        } else {
//            model.addAttribute("error", "账号或密码错误");
//            return "index";
//        }
//    }


//        if (!token.getUsername().equals(name)){
//            // return null 就表示控制器中抛出的相关异常
//            return null;
//        }
//        //密码认证， Shiro 自己做，为了避免和密码的接触
//        //最后返回一个 AuthenticationInfo 接口的实现类，这里选择 SimpleAuthenticationInfo
//        // 三个参数：获取当前用户的认证 ； 密码 ； 认证名
//        return new SimpleAuthenticationInfo("", password, "");
//    }


