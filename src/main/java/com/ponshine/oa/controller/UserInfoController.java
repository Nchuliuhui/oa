package com.ponshine.oa.controller;

import com.ponshine.oa.user.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @date
 */
@Controller
public class UserInfoController {

    @RequestMapping(value = "/userInfoPage")
    public ModelAndView toUserInfoPage(){
        ModelAndView modelAndView = new ModelAndView();
        User user  = (User) SecurityUtils.getSubject().getPrincipal();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("users/userInfo");
        return modelAndView;
    }

    /**
     * 权限配置
     * @return
     */
    @RequestMapping(value = "/PermissionConfiguration")
    public String PermissionConfiguration(){
        return "users/permissionConfiguration";
    }
}
