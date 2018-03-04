package com.ponshine.oa.user.dao;

import com.ponshine.oa.user.entity.SysPermission;
import com.ponshine.oa.user.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysPermissionDao {



    List<SysPermission> findByRoleId(@Param(value = "roleId") Long roleId);



}
