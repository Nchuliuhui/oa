package com.ponshine.oa.user.dao;

import com.ponshine.oa.user.entity.SysRole;
import com.ponshine.oa.user.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleDao {



    List<SysRole> findByUserId(@Param(value = "userId") Long userId);



}
