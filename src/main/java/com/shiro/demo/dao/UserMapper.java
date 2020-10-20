package com.shiro.demo.dao;

import com.shiro.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @CLASSNAME UserMapper
 * @DESCRIPTION 描述
 * @AUTHOR chen
 * @DATE 2018-11-24 15:10
 **/
public interface UserMapper {

    User findByUserName(@Param( "username" )String username);

    User findByName(@Param( "username" )String username);

    void insert(User u);

    void update(User user);
}
