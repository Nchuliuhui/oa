package com.ponshine.oa.user.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SysRoleDaoTest {

    @Autowired
    private SysRoleDao sysRoleDao;


    @Test
    public void findByUserId() throws Exception {

        System.out.println(sysRoleDao.findByUserId(1L));
    }

}