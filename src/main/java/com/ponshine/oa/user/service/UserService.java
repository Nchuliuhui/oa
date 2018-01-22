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
    public ResponseResult register(User user){
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



    @Transactional(readOnly=true)
    public User findByUsername(String userName) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userRepository.findByUsername(userName);
    }
}
