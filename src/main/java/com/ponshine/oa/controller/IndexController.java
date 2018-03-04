package com.ponshine.oa.controller;

import com.ponshine.oa.user.entity.User;
import com.ponshine.oa.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @date 2018/01/29
 */
@Controller
public class IndexController {

    private Logger log_ = Logger.getLogger(IndexController.class.getName());

    @Autowired
    private UserService userService;

    /**
     * 跳转初始页面
     * @return
     */
    @RequestMapping({ "/", "index" })
    public String index() {
        User user  = (User)SecurityUtils.getSubject().getPrincipal();
        return "pages/index";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/404" , method = RequestMethod.GET)
    public String to404(){
        return "404";
    }

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

    /**
     * 登录
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String login(HttpServletRequest request , Map<String , Object> map){
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        if(exception != null){
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -->帐号不存在：");
                msg = "UnknownAccountException -->帐号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg" , msg);
        return "/login";
    }

    /**
     * 注册用户
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String register(HttpServletRequest request , Map<String , Object> map){
        System.out.println("UserController.register");
        User user = new User();
        String userName = request.getParameter("username");
        if(userService.findByUsername(userName) != null){
            String msg = "用户名已经存在";
            map.put("msg" , msg);
            return "/register";
        }
        user.setUserName(userName);
        user.setSex(request.getParameter("sex"));
        String password = request.getParameter("password");
        String algorithmName = "md5";
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex(); //加密的盐
        SimpleHash hash = new SimpleHash(algorithmName,password, userName+salt, 2);
        String encodedPassword = hash.toHex();//散列后的密码存储在数据库里
        user.setPassword(encodedPassword);
        user.setSalt(salt);
        userService.register(user);
        return "/login";

    }

    /**
     * 登出，注销用户然后跳转到登出页面
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        log_.info("退出成功，已销毁用户信息，需要重新登录");
        return "/logout";
    }
}
