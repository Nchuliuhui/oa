package com.ponshine.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Brave on 16/10/9.
 *
 * 注意:
 *      这里要使用@Controller注解
 *      而不要使用@RestController
 *      否则return "hello";不能跳转到hello.html
 */
@Controller
public class HelloController {

//    @ResponseBody
//    @RequestMapping("/hello")
//    public String hello() {
//        return "Hello World";
//    }
//
//    @RequestMapping("/index")
//    public String index(ModelMap map) {
//        //map.addAttribute("hello", "hello Thymeleaf!");
//        return "index";
//    }
//    @RequestMapping("/register")
//    public String register(ModelMap map) {
//        //map.addAttribute("hello", "hello Thymeleaf!");
//        return "login/create-account";
//    }
//    @RequestMapping(value = "/login1")
//    public String login(ModelMap map) {
//        //map.addAttribute("hello", "hello Thymeleaf!");
//        System.out.print("hahahah");
//        return "index/login";
//    }
//    @RequestMapping("/login")
//    public String login1(ModelMap map) {
//        //map.addAttribute("hello", "hello Thymeleaf!");
//        return "login";
//    }
}


