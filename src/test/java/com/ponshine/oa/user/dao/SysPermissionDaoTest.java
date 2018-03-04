package com.ponshine.oa.user.dao;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SysPermissionDaoTest {

    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Test
    public void findByRoleId() throws Exception {
        System.out.println(sysPermissionDao.findByRoleId(1L));
    }

}