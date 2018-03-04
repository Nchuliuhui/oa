package com.ponshine.oa.user.dao;

import com.alibaba.fastjson.JSONObject;
import com.ponshine.oa.user.query.UserPageQuery;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findByUsername() throws Exception {
        System.out.println(userDao.findByUsername("admin"));
    }

    @Test
    public void test1(){
        String str= "{\n" +
                "    \"end\": 2,\n" +
                "    \"pageNumber\": 1,\n" +
                "    \"pageSize\": 2,\n" +
                "    \"rows\": [\n" +
                "        {\n" +
                "            \"address\": \"南昌\",\n" +
                "            \"credentialsSalt\": \"admin8d78869f470951332959580424d4bf4f\",\n" +
                "            \"password\": \"d3c59d25033dbf980d29554025c23a75\",\n" +
                "            \"salt\": \"8d78869f470951332959580424d4bf4f\",\n" +
                "            \"state\": 0,\n" +
                "            \"userId\": 1,\n" +
                "            \"userName\": \"admin\",\n" +
                "            \"username\": \"admin\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"address\": \"南昌\",\n" +
                "            \"credentialsSalt\": \"nullnull\",\n" +
                "            \"email\": \"122@qq.com\",\n" +
                "            \"password\": \"123\",\n" +
                "            \"userId\": 2\n" +
                "        }\n" +
                "    ],\n" +
                "    \"start\": 0,\n" +
                "    \"total\": 4\n" +
                "}";

        UserPageQuery query = JSONObject.parseObject(str,UserPageQuery.class);
        System.out.println(query);
    }

}