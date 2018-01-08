package com.ponshine.oa.user.dao;


import com.ponshine.oa.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

     User findByUserId(String name);
    /*
     * @class_name: UserRepository
     * @describe: TODO  根据邮箱和密码查询用户，登录使用
     * @author: liuhui
     * @date: 2017/12/28
     **/
    User findByEmailAndPassword(String email,String password);

    /**
     * @class_name: UserRepository
     * @describe: TODO  根据邮箱查询用户
     * @author: liuhui
     * @date: 2017/12/29
     **/
    User findByEmail(String email);

}

