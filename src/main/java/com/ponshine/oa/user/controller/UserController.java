package com.ponshine.oa.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ponshine.oa.common.dto.PageDTO;
import com.ponshine.oa.user.entity.User;
import com.ponshine.oa.user.query.UserPageQuery;
import com.ponshine.oa.user.service.impl.UserServiceImpl;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @date
 */
@Controller
//@RequestMapping("user")
public class UserController {
    @Autowired
    private  UserServiceImpl userServiceImpl ;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userInfo")
    //@RequiresPermissions("user:view")//权限管理;
    public String userInfo(){
        return "pages/form";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("user:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }
    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("user:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }


    @RequestMapping(value ="/findAllUser")
    @ResponseBody
    public UserPageQuery findAll(@ModelAttribute UserPageQuery query) throws JsonProcessingException {
        query = userServiceImpl.findUserPageByQuery(query);

        logger.info(JSONObject.toJSONString(query));
        return query;
    }


}

