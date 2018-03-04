package com.ponshine.oa.user.service.impl;

import com.ponshine.oa.common.dto.PageDTO;
import com.ponshine.oa.user.dao.SysPermissionDao;
import com.ponshine.oa.user.dao.SysRoleDao;
import com.ponshine.oa.user.dao.UserDao;
import com.ponshine.oa.user.entity.SysPermission;
import com.ponshine.oa.user.entity.SysRole;
import com.ponshine.oa.user.entity.User;
import com.ponshine.oa.user.query.UserPageQuery;
import com.ponshine.oa.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
    private UserDao userDao;

    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public void register(User user) {

    }

    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        if (user != null) {
            List<SysRole> sysRoleList = sysRoleDao.findByUserId(user.getUserId());
            if (!CollectionUtils.isEmpty(sysRoleList)) {
                for (SysRole role : sysRoleList) {
                    List<SysPermission> sysPermissionList = sysPermissionDao.findByRoleId(role.getId());
                    role.setPermissions(sysPermissionList);
                }
            }
            user.setRoleList(sysRoleList);
        } else {
            return null;
        }
        return user;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public UserPageQuery findUserPageByQuery(UserPageQuery query) {
        query.setRows(userDao.findUserPageByQuery(query));
        query.setTotal(userDao.countUserByQuery(query));
        return query;
    }

    @Override
    public void deleteByUserId(Long UserId) {

    }
}
