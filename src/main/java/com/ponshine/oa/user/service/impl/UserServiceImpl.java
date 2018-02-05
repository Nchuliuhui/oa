package com.ponshine.oa.user.service.impl;

import com.ponshine.oa.user.dao.UserRepository;
import com.ponshine.oa.user.entity.User;
import com.ponshine.oa.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @date
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        User user = userRepository.findByUsername(username);
        return user;

    }
}
