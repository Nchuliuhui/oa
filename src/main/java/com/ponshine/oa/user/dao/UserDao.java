package com.ponshine.oa.user.dao;

import com.ponshine.oa.user.entity.User;
import com.ponshine.oa.user.query.UserPageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDao {



    User findByUsername(@Param(value = "username") String username);


    List<User> findUserPageByQuery(UserPageQuery userPageQuery);

    int countUserByQuery(UserPageQuery userPageQuery);

}
