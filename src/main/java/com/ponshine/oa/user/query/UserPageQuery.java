package com.ponshine.oa.user.query;

import com.ponshine.oa.common.entity.BasePageQuery;
import com.ponshine.oa.user.entity.User;

/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @date
 */
public class UserPageQuery  extends BasePageQuery<User> {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
