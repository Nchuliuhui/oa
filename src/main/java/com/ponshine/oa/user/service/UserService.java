package com.ponshine.oa.user.service;

import com.ponshine.oa.common.dto.PageDTO;
import com.ponshine.oa.user.entity.User;
import com.ponshine.oa.user.query.UserPageQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    /**
     * 注册
     *
     * @param user
     * @return
     */
    void  register(User user);

    /**
     * 登录验证
     * @param username
     * @return
     */
     User findByUsername(String username);

    /**
     * 更新用户
     * @param user
     * @return
     */
     int updateUser(User user);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     *
     * @return
     */
    UserPageQuery findUserPageByQuery(UserPageQuery query);

    /**
     * 根据用户id查询用户
     * @param UserId
     */
    void deleteByUserId(Long UserId);


}
