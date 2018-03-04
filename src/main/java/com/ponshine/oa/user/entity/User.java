package com.ponshine.oa.user.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO 用户实体类
 * @date
 */
public class User implements Serializable{

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 年龄
     */

    private Integer age;

    /**
     * 性别
     */

    private String sex;

    /**
     * 密码
     */

    private String password;

    /**
     * 加密密码的盐
     */

    private String salt;

    /**
     * 邮箱
     */

    private String email;

    /**
     * 创建时间
     */

    private Date createTime ;

    /**
     * 用户类型
     */
    
    private String userType;

    /**
     * 部门id
     */
    
    private String departmentId;
    /**
     * 家庭住址
     */
  
    private String address;


    /**
     * 用户状态
     * 0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户
     * 1:正常状态
     * 2：用户被锁定.
     */
 
    private Byte state;
    /**
     * 立即从数据库中进行加载数据
     * 一个用户具有多个角色
     */
    private List<SysRole> roleList;


    public String getCredentialsSalt() {
        return this.username + this.salt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public User() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String username, Integer age, String sex, String password, String salt, String email, Date createTime, String userType, String departmentId, String address, Byte state, List<SysRole> roleList) {
        this.username = username;
        this.age = age;
        this.sex = sex;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.createTime = createTime;
        this.userType = userType;
        this.departmentId = departmentId;
        this.address = address;
        this.state = state;
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", userType='" + userType + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                '}';
    }
}
