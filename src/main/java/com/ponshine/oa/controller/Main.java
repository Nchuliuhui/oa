package com.ponshine.oa.controller;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @date
 */
public class Main {
    public static void main(String[] args){
        String algorithmName = "md5";
        String username = "lh";
        String password = "123";
        String salt1 = username;
        String salt2 = "72748b496a5a1a861cfe76f82ba29a6b";
        int hashIterations = 2;

        SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);
        String encodedPassword = hash.toHex();
        System.out.print("密码为："+ encodedPassword);
    }
}
