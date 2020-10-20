package com.shiro.demo.service;

import com.shiro.demo.pojo.User;

/**
 * @CLASSNAME UserService
 * @DESCRIPTION 描述
 * @AUTHOR chen
 * @DATE 2018-11-24 15:11
 **/
public interface UserService {

    User findByName(String username);
    User login(String username);
    void insert(User user);
    void update(User user);
    User VerifyUserName(String user);
}
