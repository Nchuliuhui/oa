package com.ponshine.oa.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @date
 */
@Controller
public class UserController {

    @RequestMapping(value = "/login")
    public String tologin(ModelMap map){
        return "index/login";
    }
}

