package com.ponshine.oa.user.service;

import com.ponshine.oa.common.dto.ResponseResult;
import com.ponshine.oa.user.dao.UserRepository;
import com.ponshine.oa.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO   用户业务层
 * @date
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private ResponseResult resultResponse = new ResponseResult();

//    /**
//     * 登录
//     * @param email
//     * @param password
//     * @return
//     */
//    public User login(String  email , String password){
//
//        return userRepository.findByEmailAndPassword(email,password);
//
//    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    public void  register(User user) {
       userRepository.save(user);
    }


    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        User user = userRepository.findByUsername(username);
        return user;
    }
}
