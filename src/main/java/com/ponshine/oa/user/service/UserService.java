package com.ponshine.oa.user.service;

import com.ponshine.oa.common.dto.ResultResponse;
import com.ponshine.oa.user.dao.UserRepository;
import com.ponshine.oa.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO   用户业务层
 * @date
 */
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private ResultResponse resultResponse;

    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    public User login(String  email , String password){

        return userRepository.findByEmailAndPassword(email,password);

    }

    /**
     * 注册
     * @param user
     * @return
     */
    public ResultResponse register(User user){
        User userUsed = userRepository.findByEmail(user.getEmail());
        if(userUsed.getUserId() != 0){
            resultResponse.setResult(0);
            resultResponse.setResultInfo("邮箱已被注册");
        }else{
            userRepository.save(user);
            resultResponse.setResult(1);
            resultResponse.setResultInfo("注册成功");
        }
        return resultResponse;
    }
}
