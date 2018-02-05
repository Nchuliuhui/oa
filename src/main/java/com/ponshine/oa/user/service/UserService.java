package com.ponshine.oa.user.service;

import com.ponshine.oa.user.entity.User;

public interface UserService {
    /**
     * 注册
     *
     * @param user
     * @return
     */
    public void  register(User user);

    /**
     * 登录验证
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
